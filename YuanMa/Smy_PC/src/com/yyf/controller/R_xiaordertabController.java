package com.yyf.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.yyf.model.Balancetab;
import com.yyf.model.City;
import com.yyf.model.Commenttab;
import com.yyf.model.PageModel;
import com.yyf.model.R_kuaiketab;
import com.yyf.model.R_xiaordertab;
import com.yyf.service.BalancetabService;
import com.yyf.service.CityService;
import com.yyf.service.R_kuaiketabService;
import com.yyf.service.R_qiangordertabService;
import com.yyf.service.R_xiaordertabService;
import com.yyf.util.R_xiaordertabEnum;

import net.sf.json.JSONObject;

/**
 * 
 * 文件名： R_xiaordertabController.java 描述： 下单，表现层 修改人： tianhao 修改时间： 2017年5月16日
 * 下午4:49:39 修改内容：
 */
@Controller
@RequestMapping("/xiaordertab")
public class R_xiaordertabController {

	// 自动装配 取发货人默认信息
	@Autowired
	private R_kuaiketabService kuaiketabService;
	// 自动装配 下单
	@Autowired
	private R_xiaordertabService r_xiaordertabService;
	// 自动装配 抢单
	@Autowired
	private R_qiangordertabService r_qiangordertabService;
	// 自动装配 地址
	@Autowired
	private CityService cityService;
	// 账户信息注入
	@Autowired
	private BalancetabService balancetabService;

	// 地球平均半径
	private static final double EARTH_RADIUS = 6378137;

	// TODO public APP和PC端共用
	/***********************************************************************************************/
	/***********************************
	 * public APP和PC端共用
	 ************************/
	/***********************************************************************************************/

	/**
	 * 
	 * 抢单流程，到达目的地后修改下单抢单状态
	 * 
	 * @author tianhao
	 * @created 2017年6月22日 上午11:41:35
	 * @param i
	 *            app/pc
	 * @param pageName
	 *            页面名称
	 * @param xiaId
	 *            下单id
	 * @return url
	 */

	@RequestMapping(value = "/getShowCode/{i}/{pageName}", method = RequestMethod.GET)
	public String getShowCode(@PathVariable("i") String i, @PathVariable("pageName") String pageName,
			@RequestParam(value = "xiaId", required = false) String xiaId, HttpServletRequest request) {
		if (!StringUtils.isEmpty(xiaId)) {
			// 通过当前状态来修改状态，
			r_xiaordertabService.updateStatus(R_xiaordertabEnum.YDD.ordinal(), xiaId);
		}
		request.getSession().removeAttribute("xiaId");
		request.getSession().removeValue("xiaId");
		return i + "/" + pageName;
	}

	/**
	 * 
	 * 下单付款，点击付款，传出金额
	 * 
	 * @author tianhao
	 * @created 2017年6月21日 下午10:08:20
	 * @param i
	 *            APP/PC
	 * @param pageName
	 *            页面名称
	 * @param xiaId
	 *            下单id
	 * @param sh
	 *            金额
	 * @param request
	 *            请求
	 * @return url
	 */
	@RequestMapping(value = "/setYuEPam/{i}/{pageName}/{xiaId}", method = RequestMethod.GET)
	public String setYuEPam(@PathVariable("i") String i, @PathVariable("pageName") String pageName,
			@PathVariable("xiaId") String xiaId,
			@RequestParam(value = "sh", required = false, defaultValue = "0.01") double sh, ModelMap model) {

		model.addAttribute("sh", sh);
		model.addAttribute("xiaId", xiaId);
		return i + "/" + pageName;
	}

	/**
	 * 
	 * 我的个人中心里面根据订单状态统计
	 * 
	 * @author tianhao
	 * @created 2017年6月17日 上午10:24:15
	 * @return url
	 */
	@RequestMapping(value = "/getMyInfoOrderStatus", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getMyInfoOrderStatus(
			@RequestParam(value = "kuaikeId", required = false) String kuaikeId, ModelMap model) {
		Map<String, Object> myInfoOrderStatus = r_xiaordertabService.getMyInfoOrderStatus(kuaikeId);
		return myInfoOrderStatus;
	}

	/**
	 * 
	 * 根据下单id修改指定状态下单单子，抢单单子的status状态
	 * 
	 * @author tianhao
	 * @created 2017年6月16日 下午5:43:00
	 * @param xiaId
	 *            下单id
	 * @param status
	 *            状态
	 * @return url
	 */
	@RequestMapping(value = "/updateXiaQiangStatus/{xiaId}/{status}/{kuaikeId}", method = RequestMethod.GET)
	public String updateXiaQiangStatus(@PathVariable("xiaId") String xiaId, @PathVariable("status") int status,
			@PathVariable("kuaikeId") String kuaikeId, ModelMap model, HttpServletRequest request) {
		// 调用接口修改下单状态,抢单状态
		r_xiaordertabService.updateStatus(status, xiaId);
		// 得到数据
		R_xiaordertab queryIdStatusXiaId = r_qiangordertabService.queryIdStatusXiaId(kuaikeId, status, xiaId);
		request.getSession().removeAttribute("xiaId");
		request.getSession().removeValue("xiaId");
		model.addAttribute("info", queryIdStatusXiaId);
		return "APP/grabASingleProcess";
	}

	/**
	 * 
	 * 下单数据模糊搜索
	 * 
	 * @author tianhao
	 * @created 2017年6月16日 下午1:40:06
	 * @param searchKey
	 *            搜索条件
	 * @return 数据集合
	 */
	@RequestMapping(value = "/singleDataFuzzySearch/{searchKey}", method = RequestMethod.GET)
	public @ResponseBody List<R_xiaordertab> singleDataFuzzySearch(@PathVariable("searchKey") String searchKey) {
		// 得到数据
		List<R_xiaordertab> singleDataFuzzySearch = r_xiaordertabService.singleDataFuzzySearch(searchKey);
		return singleDataFuzzySearch;
	}

	/**
	 * 根据快客Id,下单id以及抢单状态，得到抢单记录，返回下单单子数据
	 * 
	 * @author tianhao
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId
	 *            快客Id
	 * @param status
	 *            抢单状态
	 * @param xiaId
	 *            下单id return 下单数据
	 */
	@RequestMapping(value = "/queryIdStatus/{kuaikeId}/{status}/{xiaId}", method = RequestMethod.GET)
	public String queryIdStatusXiaId(@PathVariable("kuaikeId") String kuaikeId, @PathVariable("status") int status,
			@PathVariable("xiaId") String xiaId, ModelMap model) {
		// 得到数据
		R_xiaordertab queryIdStatusXiaId = r_qiangordertabService.queryIdStatusXiaId(kuaikeId, status, xiaId);

		model.addAttribute("info", queryIdStatusXiaId);

		return "APP/grabASingleProcess";
	}

	/**
	 * 根据快客Id以及抢单状态，得到抢单记录，返回下单单子数据 ajax
	 * 
	 * @author tianhao
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId
	 *            快客Id
	 * @param status
	 *            抢单状态 return 下单数据集合
	 */
	@RequestMapping(value = "/queryIdStatus/{kuaikeId}/{status}", method = RequestMethod.GET)
	public @ResponseBody List<R_xiaordertab> queryIdStatus(@PathVariable("kuaikeId") String kuaikeId,
			@PathVariable("status") int status) {
		// 得到数据
		List<R_xiaordertab> queryIdStatus = r_qiangordertabService.queryIdStatus(kuaikeId, status);
		return queryIdStatus;
	}

	/**
	 * 
	 * 添加下单评论记录
	 * 
	 * @author tianhao
	 * @created 2017年5月23日 下午2:40:36
	 * @param tab
	 * @return URL
	 */
	@RequestMapping(value = "/insertCommentInfo", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertCommentInfo(Commenttab tab) {
		try {
			// 评论id
			tab.setCommentId(UUID.randomUUID().toString());
			// 评论时间
			tab.setCommentDate(new Date());
			r_xiaordertabService.insertCommentInfo(tab);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 
	 * 根据下单id删除
	 * 
	 * @author tianhao
	 * @created 2017年5月19日 下午5:09:23
	 * @param xiaId下单id
	 * @return
	 */
	@RequestMapping(value = "/delete/{xiaId}", method = RequestMethod.GET)
	public String delete(@PathVariable("xiaId") String xiaId) {
		R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(xiaId);
		// 判断状态是否为0，否则不能删除
		if (xiaorderInfo != null && xiaorderInfo.getStatus() == R_xiaordertabEnum.WJD.ordinal()) {
			// 删除
			r_xiaordertabService.delete(xiaId);
			return "index";
		}

		return "PC/index";
	}

	/**
	 * 
	 * 修改下单状态
	 * 
	 * @author tianhao
	 * @created 2017年5月19日 上午11:47:32
	 * @return URL
	 */
	@RequestMapping(value = "/updateStatus/{xiaId}/{status}", method = RequestMethod.GET)
	public String updateStatus(@PathVariable("xiaId") String xiaId, @PathVariable("status") int status) {
		// 调用方法
		r_xiaordertabService.updateStatus(status, xiaId);

		return "PC/index";
	}

	/**
	 * 
	 * 获取下单数据集合
	 * 
	 * @author tianhao
	 * @created 2017年5月18日 下午3:13:16
	 * @return list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String xiaorderList(Map<String, Object> map) {
		List<R_xiaordertab> query = r_xiaordertabService.query();
		map.put("query", query);

		return "PC/index";
	}

	// TODO APP端
	/***********************************************************************************************/
	/*********************************** APP端 **************************************/
	/***********************************************************************************************/

	/**
	 * app根据下单状态，快客id，下单id查询下单数据
	 * 
	 * @author tianhao
	 * @created 2017年6月15日 下午3:01:44
	 * @param kuaikeId
	 *            快客id
	 * @param status
	 *            下单状态
	 * @param xiaId
	 *            下单id
	 * @return 数据
	 */
	@RequestMapping(value = "/getXiaIdStatusList/{kuaikeId}/{status}/{xiaId}", method = RequestMethod.GET)
	public String getXiaIdStatusList(@PathVariable("kuaikeId") String kuaikeId, @PathVariable("status") int status,
			@PathVariable("xiaId") String xiaId, ModelMap model) {
		// 得到数据
		R_xiaordertab statusQueryXiaId = r_xiaordertabService.statusQueryXiaId(status, kuaikeId, xiaId);
		model.addAttribute("info", statusQueryXiaId);
		return "APP/placeAnOrderInfo";
	}

	/**
	 * app根据快客id以及状态得到下单数据
	 * 
	 * @author tianhao
	 * @created 2017年6月15日 下午3:01:44
	 * @param kuaikeId
	 *            快客id
	 * @param status
	 *            下单状态
	 * @return 数据集合
	 */
	@RequestMapping(value = "/getXiaIdStatusList/{kuaikeId}/{status}", method = RequestMethod.GET)
	public @ResponseBody List<R_xiaordertab> getXiaIdStatusList(@PathVariable("kuaikeId") String kuaikeId,
			@PathVariable("status") int status) {
		// 得到数据
		List<R_xiaordertab> statusQuery = r_xiaordertabService.statusQuery(status, kuaikeId);
		return statusQuery;
	}

	/**
	 * app根据下单id跳转到抢单页面
	 * 
	 * @author tianhao
	 * @created 2017年6月14日 上午9:53:42
	 * @param xiaId
	 *            下单id
	 * @param model
	 *            map
	 * @return url
	 */
	@RequestMapping(value = "/grabASingleRquest/{i}/{pageName}/{xiaId}", method = RequestMethod.GET)
	public String grabASingleRquest(@PathVariable("i") String i, @PathVariable("pageName") String pageName,
			@PathVariable("xiaId") String xiaId, ModelMap model) {
		// 得到数据
		R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(xiaId);
		// 设置到map
		model.addAttribute("info", xiaorderInfo);
		//
		return i + "/" + pageName;
	}

	/**
	 * 
	 * app根据下单id得到下单详细详细，ajax
	 * 
	 * @author tianhao
	 * @created 2017年6月12日 下午2:20:33
	 * @param xiaId
	 * @param request
	 */
	@RequestMapping(value = "/xiaorderInfoAjax/{xiaId}", method = RequestMethod.POST)
	public @ResponseBody R_xiaordertab xiaorderInfoAjax(@PathVariable("xiaId") String xiaId,
			HttpServletRequest request) {
		// 得到下单详细
		R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(xiaId);
		return xiaorderInfo;
	}

	/**
	 * 
	 * app跳转下单页面初始化
	 * 
	 * @author tianhao
	 * @created 2017年7月3日 下午17:25:28
	 * @param pageName
	 *            页面名称
	 * @return
	 */
	@RequestMapping(value = "/appOrderRequest/{pageName}", method = RequestMethod.GET)
	public String appOrderRequest(R_xiaordertab tab, @PathVariable("pageName") String pageName,
			HttpServletRequest request, ModelMap model) {
		// 下单id
		Object attribute = request.getSession().getAttribute("xiaId");

		R_kuaiketab selectUser = kuaiketabService
				.selectUser(String.valueOf(request.getSession().getAttribute("kuaikeId")));
		if("shipperInformation".equals(pageName)){
			// 清空session
			request.getSession().setAttribute("fahuoname", selectUser.getKuaikeName());
			request.getSession().setAttribute("fahuophone", selectUser.getKuaikePhone());
			request.getSession().setAttribute("fahuoadress", selectUser.getKuaikeAddress());
			request.getSession().setAttribute("fahuoadressinfo", selectUser.getKuaikeAddressInfo());
		}
		if (StringUtils.isEmpty(attribute)) {
			// 初始化值
			tab.setXiaId(UUID.randomUUID().toString());
			tab.setStatus(R_xiaordertabEnum.WJD.ordinal());
			tab.setPayment(0);// 未付款
			tab.setShopDate(new Date());

			// 清空session
			request.getSession().removeAttribute("xiaId");
			request.getSession().removeValue("xiaId");
			// 设置id到session
			request.getSession().setAttribute("xiaId", tab.getXiaId());
			r_xiaordertabService.add(tab);
			return "APP/" + pageName;
		} else {
			R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(attribute.toString());
			model.addAttribute("xiainfo", xiaorderInfo);
			request.getSession().setAttribute("xiaId", attribute);
			return "APP/" + pageName;
		}

	}

	/**
	 * 
	 * app下单发货人信息ajax
	 * 
	 * @author tianhao
	 * @created 2017年6月12日 上午10:56:33
	 * @param kuaikeName
	 * @param kuaikePhone
	 * @param kuaikeAddressInfo
	 */
	@RequestMapping(value = "/fa/{xiaId}/{kuaikeName}/{kuaikePhone}/{kuaikeAddress}/{kuaikeAddressInfo}", method = RequestMethod.POST)
	public @ResponseBody void fa(@PathVariable("kuaikeName") String kuaikeName,
			@PathVariable("kuaikePhone") String kuaikePhone, @PathVariable("kuaikeAddress") String kuaikeAddress,
			@PathVariable("xiaId") String xiaId, @PathVariable("kuaikeAddressInfo") String kuaikeAddressInfo,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(kuaikeAddress + kuaikeAddressInfo);
		// 发货人信息
		Map<String, Double> map = getLngAndLat((kuaikeAddress + kuaikeAddressInfo).replace(" ", ""));

		double falng = map.get("lng");
		double falat = map.get("lat");
		request.getSession().removeAttribute("distance");
		request.getSession().removeValue("distance");

		try {
			request.setCharacterEncoding("UTF-8");

			response.setContentType("text/html;charset=UTF-8");

			r_xiaordertabService.fa(kuaikeName, kuaikePhone, kuaikeAddress, xiaId, kuaikeAddressInfo, falng, falat);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * app下单收货人信息ajax
	 * 
	 * @author tianhao
	 * @created 2017年6月12日 上午10:44:44
	 * @param shouhuoName
	 *            收货人名称
	 * @param shouhuoPhone
	 *            收货人电话
	 * @param shouhuoAddressInfo
	 *            收货人地址详情
	 */
	@RequestMapping(value = "/shou/{xiaId}/{shouhuoName}/{shouhuoPhone}/{shouhuoAddress}/{shouhuoAddressInfo}", method = RequestMethod.POST)
	public @ResponseBody void shou(@PathVariable("shouhuoName") String shouhuoName,
			@PathVariable("shouhuoPhone") String shouhuoPhone, @PathVariable("shouhuoAddress") String shouhuoAddress,
			@PathVariable("xiaId") String xiaId, @PathVariable("shouhuoAddressInfo") String shouhuoAddressInfo,
			HttpServletRequest request, HttpServletResponse response) {
		// 收货人信息
		System.out.println(shouhuoAddress + shouhuoAddressInfo);
		Map<String, Double> map = getLngAndLat((shouhuoAddress + shouhuoAddressInfo).replace(" ", ""));
		double shoulng = map.get("lng");
		double shoulat = map.get("lat");
		request.getSession().removeAttribute("distance");
		request.getSession().removeValue("distance");
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			r_xiaordertabService.shou(shouhuoName, shouhuoPhone, shouhuoAddress, xiaId, shouhuoAddressInfo, shoulng,
					shoulat);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * app下单的提交ajax
	 * 
	 * @author tianhao
	 * @created 2017年6月12日 上午10:14:53
	 * @param xiaId
	 *            下单id
	 * @param shopType
	 *            货物类型
	 * @param shopNumer
	 *            货物数量
	 * @param shopzholiang
	 *            货物重量
	 * @param timeString
	 *            取货时间
	 * @return 提示
	 */
	@RequestMapping(value = "/orderSbmit", method = RequestMethod.POST)
	public String orderSbmit(@RequestParam(value = "files", required = false) MultipartFile[] files, R_xiaordertab tab,
			HttpServletRequest request, ModelMap model) {
		try {
			// 获取到当前服务器项目的跟路径
			String path = request.getSession().getServletContext().getRealPath("upload");

			String imagesPath = "";
			if (!StringUtils.isEmpty(files)) {
				for (int i = 0; i < files.length; i++) {

					MultipartFile file = files[i];
					// 文件1
					String fileName = file.getOriginalFilename();
					imagesPath += request.getContextPath() + "/upload/" + fileName;
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}

					// 保存
					file.transferTo(targetFile);

				}
			}
			tab.setShopImages(imagesPath);

			r_xiaordertabService.orderSbmit(tab);
			// 清空session中的下单id
			request.getSession().removeAttribute("xiaId");
			request.getSession().removeValue("xiaId");

			request.getSession().removeAttribute("xiainfo");
			request.getSession().removeValue("xiainfo");
			model.remove("xiainfo");

			String parameter = request.getParameter("kuaikeId");
			Balancetab queryKuaikeId = balancetabService.queryKuaikeId(parameter);

			if (!"".equals(queryKuaikeId) && queryKuaikeId != null) {

				request.getSession().setAttribute("zhifumima", queryKuaikeId.getZhifupwd());

			}
			request.getSession().removeAttribute("distance");
			request.getSession().removeValue("distance");
			model.addAttribute("xiaId", tab.getXiaId());
			model.addAttribute("sh", tab.getShopprices());
			return "APP/myWallet_Recharge";
		} catch (Exception e) {
			e.printStackTrace();
			return "APP/placeAnOrder";
		}
	}

	// TODO PC端
	/***********************************************************************************************/
	/*********************************** PC端 *******************************************/
	/***********************************************************************************************/

	/**
	 * 
	 * 通过ajax请求，根据状态返回集合
	 * 
	 * @author tianhao
	 * @created 2017年5月28日 上午9:05:17
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/xiadanAjax/{status}", method = RequestMethod.GET)
	public @ResponseBody PageModel<R_xiaordertab> ajxaJson(@PathVariable("status") int status) {
		// 分页模型
		PageModel<R_xiaordertab> page = new PageModel<R_xiaordertab>();
		// 设置分页数值
		page.setNumCount(r_xiaordertabService.statusQueryCount(status));
		page.setStatus(status);
		// 得到分页数据,默认
		List<R_xiaordertab> statusQuery = r_xiaordertabService.statusQueryPaging(status,
				((page.getPageIndex() - 1) * page.getPageNum()), page.getPageNum());

		// 设置到page
		page.setList(statusQuery);

		return page;
	}

	/**
	 * 
	 * 通过ajax请求，根据状态返回分页集合
	 * 
	 * @author tianhao
	 * @created 2017年6月7日 上午11:12:16
	 * @param status
	 *            下单状态
	 * @param pageIndex
	 *            当前页
	 * @param pageNum
	 *            页容量
	 * @param model
	 *            模型，保存page
	 * @return 集合
	 */
	@RequestMapping(value = "/xiadanAjax/{status}/{pageIndex}/{pageNum}", method = RequestMethod.GET)
	public @ResponseBody PageModel<R_xiaordertab> statusQueryPaging(@PathVariable("status") int status,
			@PathVariable("pageIndex") int pageIndex, @PathVariable("pageNum") int pageNum) {
		// 分页模型
		PageModel<R_xiaordertab> page = new PageModel<R_xiaordertab>();
		// 设置分页数值
		page.setPageIndex(pageIndex);
		page.setPageNum(pageNum);
		page.setNumCount(r_xiaordertabService.statusQueryCount(status));
		page.setStatus(status);
		// 得到分页数据
		List<R_xiaordertab> statusQueryPaging = r_xiaordertabService.statusQueryPaging(status,
				((pageIndex - 1) * pageNum), pageNum);
		// 设置到page
		page.setList(statusQueryPaging);
		return page;
	}

	/**
	 * 
	 * 下单的详细信息
	 * 
	 * @author tianhao
	 * @created 2017年5月19日 下午3:05:32
	 * @param xiaId
	 *            下单id
	 * @return URL
	 */
	@RequestMapping(value = "/xiaorderInfo/{xiaId}", method = RequestMethod.GET)
	public String xiaorderInfo(@PathVariable("xiaId") String xiaId, ModelMap map) {
		// 得到数据
		R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(xiaId);
		map.addAttribute("info", xiaorderInfo);

		R_kuaiketab querytKuaike = r_qiangordertabService.querytKuaike(xiaId);
		map.addAttribute("kuaike", querytKuaike);

		// 获取省
		List<City> province = cityService.getProvince();
		map.addAttribute("province", province);

		// 获取市
		List<City> city = cityService.getCity();
		map.addAttribute("city", city);

		// 获取区
		List<City> area = cityService.getArea();
		map.addAttribute("area", area);

		return "PC/placeAnOrderInfo";

	}

	/**
	 * 
	 * 添加下单纪录
	 * 
	 * @author tianhao
	 * @created 2017年5月16日 下午5:12:24
	 * @param 实体数据
	 * @return URL
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "fileImages", required = false) MultipartFile fileImages,
			HttpServletRequest request, R_xiaordertab tab) {

		// 获取到当前服务器项目的跟路径
		String path = request.getSession().getServletContext().getRealPath("upload");
		// 文件1
		String fileName1 = fileImages.getOriginalFilename();
		File targetFile1 = new File(path, fileName1);
		if (!targetFile1.exists()) {
			targetFile1.mkdirs();
		}

		// 保存
		try {
			fileImages.transferTo(targetFile1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 下单id
		tab.setXiaId(UUID.randomUUID().toString());
		// 下单状态,默认
		tab.setStatus(R_xiaordertabEnum.WJD.ordinal());
		// 商品图片
		tab.setShopImages(request.getContextPath() + "/upload/" + fileName1);

		r_xiaordertabService.add(tab);
		// 防止session里的值一直保持不变
		// 先移除session中的值
		request.getSession().removeAttribute("pricse");
		request.getSession().removeAttribute("xiaId");
		// 再把值-->对象存入Session中
		request.getSession().setAttribute("pricse", tab.getShopprices());
		request.getSession().setAttribute("xiaId", tab.getXiaId());

		return "PC/fukuan";
	}

	public static Map<String, Double> getLngAndLat(String address) {
		Map<String, Double> map = new HashMap<String, Double>();
		String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address
				+ "&output=json&ak=Yog3Re4RxEwS79CETmcwBaxIpl70VDra";
		String json = loadJSON(url);
		JSONObject obj = JSONObject.fromObject(json);
		if (obj.get("status").toString().equals("0")) {
			double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
			double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
			map.put("lng", lng);
			map.put("lat", lat);
			// System.out.println("经度："+lng+"---纬度："+lat);
		} else {
			// System.out.println("未找到相匹配的经纬度！");
		}
		return map;
	}

	public static String loadJSON(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return json.toString();
	}

	/**
	 * 
	 * 取得两点间的直线距离
	 * 
	 * @author tianhao
	 * @created 2017年6月30日 上午9:12:24
	 * @param
	 * @throws IOException
	 */
	@RequestMapping(value = "/distance", method = RequestMethod.POST)
	public void distance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		double distance = 0;
		String xiaId = request.getParameter("xiaId");
		R_xiaordertab xiatab = r_xiaordertabService.getlnglat(xiaId);
		double shou = xiatab.getShoulng();
		double fa = xiatab.getFalng();
		String dist  = "";
		if (shou != 0 && fa != 0) {
			System.out.println("获取距离");
			double shoulng = xiatab.getShoulng();// 收获经度
			double shoulat = xiatab.getShoulat();// 收获纬度
			double falng = xiatab.getFalng();// 发货经度
			double falat = xiatab.getFalat();// 发货纬度
			distance = getDistance(shoulng, shoulat, falng, falat) / 1000;
			r_xiaordertabService.setDistance(xiaId, distance);
			NumberFormat nf = NumberFormat.getNumberInstance();
			// 保留两位小数
	        nf.setMaximumFractionDigits(2); 
			dist= nf.format(distance);
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.getSession().removeAttribute("distance");
		request.getSession().removeValue("distance");
		System.out.println("存入session:" + dist);

		request.getSession().setAttribute("distance", dist);
		out.print(dist);

	}

	// 根据经纬度获取两点间的直线距离
	public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		// s = Math.round(s * 10000) / 10000;
		return s;
	}

	// 把经纬度转为度（°）
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

}
