package com.yyf.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yyf.model.City;
import com.yyf.model.Commenttab;
import com.yyf.model.PageModel;
import com.yyf.model.R_kuaiketab;
import com.yyf.model.R_xiaordertab;
import com.yyf.service.CityService;
import com.yyf.service.R_qiangordertabService;
import com.yyf.service.R_xiaordertabService;
import com.yyf.util.R_xiaordertabEnum;

/**
 * 
 * 文件名： R_xiaordertabController.java 描述： 下单，表现层 修改人： lijie 修改时间： 2017年5月16日
 * 下午4:49:39 修改内容：
 */
@Controller
@RequestMapping("/xiaordertab")
public class R_xiaordertabController {

	// 自动装配 下单
	@Autowired
	private R_xiaordertabService r_xiaordertabService;
	// 自动装配 抢单
	@Autowired
	private R_qiangordertabService r_qiangordertabService;
	// 自动装配 地址
	@Autowired
	private CityService cityService;
	
	
	// TODO	public APP和PC端共用 
	/***********************************************************************************************/
	/***********************************       public APP和PC端共用                     ************************/
	/***********************************************************************************************/
	
	/**
	 * 
	 * 我的个人中心里面根据订单状态统计
	 * @author lijie     
	 * @created 2017年6月17日 上午10:24:15  
	 * @return url
	 */
	@RequestMapping(value="/getMyInfoOrderStatus",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getMyInfoOrderStatus(@RequestParam(value="kuaikeId",required=false)String kuaikeId,ModelMap model){
		Map<String, Object> myInfoOrderStatus = r_xiaordertabService.getMyInfoOrderStatus();
		System.out.println(kuaikeId);
		return myInfoOrderStatus;
	}
	
	/**
	 * 
	 * 根据下单id修改指定状态下单单子，抢单单子的status状态
	 * @author	lijie     
	 * @created 2017年6月16日 下午5:43:00  
	 * @param xiaId		下单id
	 * @param status	状态
	 * @return url
	 */
	@RequestMapping(value="/updateXiaQiangStatus/{xiaId}/{status}/{kuaikeId}",method=RequestMethod.GET)
	public String updateXiaQiangStatus(@PathVariable("xiaId")String xiaId,@PathVariable("status")int status,@PathVariable("kuaikeId")String kuaikeId,ModelMap model){
		//调用接口修改下单状态,抢单状态
		r_xiaordertabService.updateStatus(status, xiaId);
		//得到数据
		R_xiaordertab queryIdStatusXiaId = r_qiangordertabService.queryIdStatusXiaId(kuaikeId, status, xiaId);
		model.addAttribute("info", queryIdStatusXiaId);
		return "APP/grabASingleProcess";
	}
	
	/**
	 * 
	 * 下单数据模糊搜索
	 * @author lijie     
	 * @created 2017年6月16日 下午1:40:06  
	 * @param searchKey		搜索条件	
	 * @return	数据集合
	 */
	@RequestMapping(value="/singleDataFuzzySearch/{searchKey}",method=RequestMethod.GET)
	public @ResponseBody List<R_xiaordertab> singleDataFuzzySearch(@PathVariable("searchKey")String searchKey) {
		//得到数据
		List<R_xiaordertab> singleDataFuzzySearch = r_xiaordertabService.singleDataFuzzySearch(searchKey);
		return singleDataFuzzySearch;
	}
	
	/**
	 * 根据快客Id,下单id以及抢单状态，得到抢单记录，返回下单单子数据
	 * @author lijie
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId    	快客Id
	 * @param status		抢单状态
	 * @param xiaId			下单id
	 * return 下单数据
	 */
	@RequestMapping(value="/queryIdStatus/{kuaikeId}/{status}/{xiaId}",method=RequestMethod.GET)
	public  String queryIdStatusXiaId(@PathVariable("kuaikeId")String kuaikeId,@PathVariable("status")int status,@PathVariable("xiaId")String xiaId,ModelMap model){
		//得到数据
		R_xiaordertab queryIdStatusXiaId = r_qiangordertabService.queryIdStatusXiaId(kuaikeId, status, xiaId);
		model.addAttribute("info", queryIdStatusXiaId);
		return "APP/grabASingleProcess";
	}
	
	/**
	 * 根据快客Id以及抢单状态，得到抢单记录，返回下单单子数据 ajax
	 * @author lijie
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId    	快客Id
	 * @param status		抢单状态
	 * return 下单数据集合
	 */
	@RequestMapping(value="/queryIdStatus/{kuaikeId}/{status}",method=RequestMethod.GET)
	public @ResponseBody List<R_xiaordertab> queryIdStatus(@PathVariable("kuaikeId")String kuaikeId,@PathVariable("status")int status){
		//得到数据
		List<R_xiaordertab> queryIdStatus = r_qiangordertabService.queryIdStatus(kuaikeId, status);
		return queryIdStatus;
	}
	
	/**
	 * 
	 * 添加下单评论记录
	 * 
	 * @author lijie
	 * @created 2017年5月23日 下午2:40:36
	 * @param tab
	 * @return URL
	 */
	@RequestMapping(value = "/insertCommentInfo", method = RequestMethod.POST)
	public String insertCommentInfo(Commenttab tab) {
		// 评论id
		tab.setCommentId(UUID.randomUUID().toString());
		// 评论时间
		tab.setCommentDate(new Date());
		r_xiaordertabService.insertCommentInfo(tab);
		return "评论成功";
	}
	
	/**
	 * 
	 * 根据下单id删除
	 * 
	 * @author lijie
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
	 * @author lijie
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
	 * @author lijie
	 * @created 2017年5月18日 下午3:13:16
	 * @return list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String xiaorderList(Map<String, Object> map) {
		List<R_xiaordertab> query = r_xiaordertabService.query();
		map.put("query", query);

		return "PC/index";
	}
	

	// TODO	APP端 
	/***********************************************************************************************/
	/***********************************       APP端                    **************************************/
	/***********************************************************************************************/
	
	/**
	 *app根据下单状态，快客id，下单id查询下单数据
	 * @author lijie     
	 * @created 2017年6月15日 下午3:01:44  
	 * @param kuaikeId	快客id
	 * @param status	下单状态
	 * @param xiaId		下单id
	 * @return	数据
	 */
	@RequestMapping(value="/getXiaIdStatusList/{kuaikeId}/{status}/{xiaId}",method=RequestMethod.GET)
	public  String getXiaIdStatusList(@PathVariable("kuaikeId")String kuaikeId,@PathVariable("status")int status,@PathVariable("xiaId")String xiaId,ModelMap model){
		//得到数据
		R_xiaordertab statusQueryXiaId = r_xiaordertabService.statusQueryXiaId(status, kuaikeId, xiaId);
		model.addAttribute("info", statusQueryXiaId);
		return "APP/placeAnOrderInfo";
	}
	
	/**
	 * app根据快客id以及状态得到下单数据
	 * @author lijie     
	 * @created 2017年6月15日 下午3:01:44  
	 * @param kuaikeId	快客id
	 * @param status	下单状态
	 * @return	数据集合
	 */
	@RequestMapping(value="/getXiaIdStatusList/{kuaikeId}/{status}",method=RequestMethod.GET)
	public @ResponseBody List<R_xiaordertab> getXiaIdStatusList(@PathVariable("kuaikeId")String kuaikeId,@PathVariable("status")int status){
		//得到数据
		List<R_xiaordertab> statusQuery = r_xiaordertabService.statusQuery(status,kuaikeId);
		return statusQuery;
	}
	
	/**
	 * app根据下单id跳转到抢单页面
	 * @author lijie     
	 * @created 2017年6月14日 上午9:53:42  
	 * @param xiaId	下单id
	 * @param model	map
	 * @return url
	 */
	@RequestMapping(value="/grabASingleRquest/{i}/{pageName}/{xiaId}",method=RequestMethod.GET)
	public String grabASingleRquest(@PathVariable("i")String i,@PathVariable("pageName")String pageName,@PathVariable("xiaId") String xiaId,ModelMap model){
		//	得到数据
		R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(xiaId);
		//	设置到map
		model.addAttribute("info", xiaorderInfo);
		//	
		return i+"/"+pageName;
	}
	

	/**
	 * 
	 * app根据下单id得到下单详细详细，ajax
	 * @author lijie     
	 * @created 2017年6月12日 下午2:20:33  
	 * @param xiaId
	 * @param request
	 */
	@RequestMapping(value="/xiaorderInfoAjax/{xiaId}",method=RequestMethod.POST)
	public @ResponseBody R_xiaordertab xiaorderInfoAjax(@PathVariable("xiaId") String xiaId,HttpServletRequest request){
		//得到下单详细
		R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(xiaId);
		//赋值到session
		//request.getSession().setAttribute("kuaikeName",xiaorderInfo.getKuaikeName());
		//request.getSession().setAttribute("shouhuoName", xiaorderInfo.getShouhuoNmae());
		
		return xiaorderInfo;
	}
	
	/**
	 * 
	 * app跳转下单页面初始化
	 * @author lijie     
	 * @created 2017年6月12日 上午11:16:28 
	 * @param pageName 页面名称 
	 * @return
	 */
	@RequestMapping(value="/appOrderRequest/{pageName}",method=RequestMethod.GET)
	public String appOrderRequest(R_xiaordertab tab,@PathVariable("pageName")String pageName,HttpServletRequest request,ModelMap model){
		System.out.println("*******************");
		//下单id
		Object attribute = request.getSession().getAttribute("xiaId");
		if(StringUtils.isEmpty(attribute)){
			//初始化值
			tab.setXiaId(UUID.randomUUID().toString());
			tab.setStatus(R_xiaordertabEnum.WJD.ordinal());
			tab.setPayment(0);//未付款
			//设置id到session
			request.getSession().setAttribute("xiaId", tab.getXiaId());
			r_xiaordertabService.add(tab);
			return "APP/"+pageName;
		}else{
			R_xiaordertab xiaorderInfo = r_xiaordertabService.xiaorderInfo(attribute.toString());
			model.addAttribute("info", xiaorderInfo);
			request.getSession().setAttribute("xiaId", attribute);
			return "APP/"+pageName;
		}

	}
	
	/**
	 * 
	 * app下单发货人信息ajax
	 * @author lijie     
	 * @created 2017年6月12日 上午10:56:33  
	 * @param kuaikeName
	 * @param kuaikePhone
	 * @param kuaikeAddressInfo
	 */
	@RequestMapping(value="/fa/{xiaId}/{kuaikeName}/{kuaikePhone}/{kuaikeAddressInfo}",method=RequestMethod.POST)
	public @ResponseBody void fa(@PathVariable("kuaikeName")String kuaikeName,
			@PathVariable("kuaikePhone")String kuaikePhone,
			@PathVariable("xiaId") String xiaId,
			@PathVariable("kuaikeAddressInfo")String kuaikeAddressInfo){
		//发货人信息
		r_xiaordertabService.fa(kuaikeName, kuaikePhone, xiaId, kuaikeAddressInfo);
	}
	
	/**
	 * 
	 * app下单收货人信息ajax
	 * @author lijie     
	 * @created 2017年6月12日 上午10:44:44
	 * @param shouhuoName			收货人名称
	 * @param shouhuoPhone			收货人电话
	 * @param shouhuoAddressInfo	收货人地址详情
	 */
	@RequestMapping(value="/shou/{xiaId}/{shouhuoName}/{shouhuoPhone}/{shouhuoAddressInfo}",method=RequestMethod.POST)
	public @ResponseBody void shou(@PathVariable("shouhuoName")String shouhuoName,
								@PathVariable("shouhuoPhone")String shouhuoPhone,
								@PathVariable("xiaId") String xiaId,
								@PathVariable("shouhuoAddressInfo")String shouhuoAddressInfo,HttpServletRequest request){
		//收货人信息
		r_xiaordertabService.shou(shouhuoName, shouhuoPhone, xiaId, shouhuoAddressInfo);
	}
	
	/**
	 * 
	 * app下单的提交ajax
	 * 
	 * @author lijie
	 * @created 2017年6月12日 上午10:14:53
	 * @param xiaId 		下单id
	 * @param shopType		货物类型
	 * @param shopNumer		货物数量
	 * @param shopzholiang	货物重量
	 * @param timeString	取货时间
	 * @return	提示
	 */
	@RequestMapping(value = "/orderSbmit/{xiaId}/{shopType}/{shopNumer}/{shopzholiang}/{timeString}/{kuaikeId}", method = RequestMethod.POST)
	public @ResponseBody String orderSbmit(@PathVariable("xiaId") String xiaId,
			@PathVariable("shopType") String shopType, @PathVariable("shopNumer") float shopNumer,
			@PathVariable("shopzholiang") int shopzholiang,
			@PathVariable("timeString") String timeString,
			@PathVariable("kuaikeId") String kuaikeId,HttpServletRequest request) {
		try {
			r_xiaordertabService.orderSbmit(xiaId, shopType, shopNumer, shopzholiang, timeString,kuaikeId);
			//清空session中的下单id
			request.getSession().removeAttribute("xiaId");
			request.getSession().removeValue("xiaId");
			return "下单成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "下单失败";
		}
	}

	
	// TODO	PC端  
	/***********************************************************************************************/
	/***********************************       PC端             *******************************************/
	/***********************************************************************************************/
	
	/**
	 * 
	 * 通过ajax请求，根据状态返回集合
	 * 
	 * @author lijie
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
		System.out.println(page.toString());

		return page;
	}
	
	/**
	 * 
	 * 通过ajax请求，根据状态返回分页集合
	 * 
	 * @author lijie
	 * @created 2017年6月7日 上午11:12:16
	 * @param status	       下单状态
	 * @param pageIndex     当前页
	 * @param pageNum       页容量
	 * @param model		        模型，保存page
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
		System.out.println(page.toString());
		// 设置到page
		page.setList(statusQueryPaging);
		return page;
	}


	/**
	 * 
	 * 下单的详细信息
	 * 
	 * @author lijie
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
	 * @author lijie
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
		return "PC/index";
	}

}
