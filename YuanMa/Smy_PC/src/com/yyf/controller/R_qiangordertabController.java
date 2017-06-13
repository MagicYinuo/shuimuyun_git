package com.yyf.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyf.model.R_kuaiketab;
import com.yyf.model.R_qiangordertab;
import com.yyf.model.R_xiaordertab;
import com.yyf.service.R_qiangordertabService;
import com.yyf.util.R_qiangordertabEnum;

/**
 * 文件名：R_qiangordertabController.java 描述： 我要抢单 修改人： 杨杰 修改时间：2017年5月18日 下午6:52:44
 * 修改内容：
 */
@Controller
public class R_qiangordertabController {

	/* 涉及到页面的跳转的 都没有真实的页面 */

	/* 添加依赖注入 */
	@Autowired
	private R_qiangordertabService qiangordertabService;

	/**
<<<<<<< HEAD
	 * app根据快客Id得到抢单记录
	 * @author lijie
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId    	快客Id
	 * @param status		抢单状态
	 * @param model
	 */
	@RequestMapping(value = "queryIdStatus/{kuaikeId}/{status}", method = RequestMethod.POST)
	@ResponseBody
	public List<R_qiangordertab> queryIdStatus(@PathVariable("kuaikeId") String kuaikeId,@PathVariable("status")int status, ModelMap model) {

		List<R_qiangordertab> QiangOrde = qiangordertabService.queryQiangOrderBykuaikeId(kuaikeId);

		model.addAllAttributes(QiangOrde);

		model.addAttribute("qiangOrde", QiangOrde);

		return QiangOrde;

	}
	
	/**
	 * 
	 * app抢单操作，添加抢单记录
	 * @author lijie     
	 * @created 2017年6月13日 上午10:51:12  
	 * @param xiaId		下单id
	 * @param kuaikeId	快客id
	 * @return
	 */
	@RequestMapping(value="r_qiangordertabController/insertAjax/{xiaId}/{kuaikeId}")
	public @ResponseBody String  insertAjax(@PathVariable("xiaId")String xiaId,@PathVariable("kuaikeId")String kuaikeId){
		try {
			// 得到唯一的ID 作为抢单ID的唯一标示列
			// 默认抢单id
			UUID uuid1 = UUID.randomUUID();
			// 强制转换
			String uuid = uuid1.toString();
			qiangordertabService.Insert(uuid, xiaId, kuaikeId, 0, new Date());
			return "抢单成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "抢单失败";
		}
	}
	
	/**
	 * PC抢单成功的时候 会往抢单表中添加一条记录
	 * 
	 * @author 杨杰
	 * @created 2017年5月18日 下午7:06:36
	 * @param xiaId
	 *            下单ID
	 * @param kuaikeId
	 *            快客ID
	 * @return 返回 失败、 成功页面
	 */
	@RequestMapping(value = "pcInsertQiang", method = RequestMethod.POST)
	public String pcInsert(Map<String, Object> map,@RequestParam("xidId") String xiaId,@RequestParam("kuaikeId") String kuaikeId) {

		// 得到唯一的ID 作为抢单ID的唯一标示列
		// 默认抢单id
		UUID uuid1 = UUID.randomUUID();
		// 强制转换
		String uuid = uuid1.toString();
		
		int insert = qiangordertabService.Insert(uuid, xiaId, kuaikeId, R_qiangordertabEnum.QD_OK.ordinal(), new Date());
		
		if(insert>0){
			return "PC/index";
		}
		return "PC/index";
	}
	
	
	/**
	 * 根据快客Id得到抢单记录
	 * 
	 * @author 杨杰
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId
	 *            快客Id
	 * @param model
	 */
	@RequestMapping(value = "queryQiangOrderBykuaikeId/{kuaikeId}", method = RequestMethod.POST)
	@ResponseBody
	public List<R_qiangordertab> queryQiangOrderBykuaikeId(@PathVariable("kuaikeId") String kuaikeId, ModelMap model) {

		List<R_qiangordertab> QiangOrde = qiangordertabService.queryQiangOrderBykuaikeId(kuaikeId);

		model.addAllAttributes(QiangOrde);

		model.addAttribute("qiangOrde", QiangOrde);

		return QiangOrde;

	}

	/**
	 * 得到抢单集合对象
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 上午10:02:04
	 * @param map
	 *            集合参数对象
	 * @return 返回 显示数据页面
	 */
	@RequestMapping(value = "queryList", method = RequestMethod.GET)
	public String query(Map<String, Object> map) {
		// 调用查询方法 并封装给List集合对象
		List<R_qiangordertab> query = qiangordertabService.query();
		map.put("query", query);

		// 得到抢单数据总条数
		int queryCount = qiangordertabService.queryCount();

		map.put("queryCount", queryCount);
		// 返回 List
		return "PC/qiangOrderPage";
	}

	/**
	 * 根据下单Id 获取到快客的id 姓名 及电话
	 * 
	 * @author 杨杰
	 * @created 2017年5月26日 下午2:34:02
	 * @param map
	 *            map集合对象
	 * @param xiaId
	 *            下单id
	 * @return
	 */
	@RequestMapping(value = "queryKuaike/{xiaId}", method = RequestMethod.GET)
	public String queryKuaike(Map<String, Object> map, @PathVariable("xiaId") String xiaId) {
		R_kuaiketab querytKuaike = qiangordertabService.querytKuaike(xiaId);

		if (!"".equals(querytKuaike) && querytKuaike != null) {

			return "PC/index";
		}
		return null;
	}

	/**
	 * 根据抢单ID 进行对 抢单记录删除
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 上午10:31:03
	 * @param qiangorderId
	 *            抢单Id
	 */
	@RequestMapping(value = "delete/{qiangorderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public int delete(@PathVariable("qiangorderId") String qiangorderId) {
		// 调用删除方法
		int delete = qiangordertabService.delete(qiangorderId);

		if (delete > 0) {

			return 1;
		}
		return 0;

	}

	/**
	 * 根据百度 地图 模糊搜索周边的 单子数 及 收货人地址
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 下午3:47:50
	 * @param map
	 *            集合对象
	 * @param kuaikeAddress
	 *            快客地址
	 * @param shouhuoAddress
	 *            收货人地址
	 * @return 成功 或者失败页面
	 */
	@RequestMapping(value = "queryAddres", method = RequestMethod.POST)
	public String queryAddress(Map<String, Object> map, @RequestParam("kuaikeAddress") String kuaikeAddress,
			@RequestParam("shouhuoAddress") String shouhuoAddress) {

		/* 调用查询方法 并封装为 List 集合对象 */
		List<R_xiaordertab> queryAddress = qiangordertabService.queryAddress(kuaikeAddress, shouhuoAddress);
		/* 对集合进行简单的判断处理 */
		if (queryAddress != null && queryAddress.size() > 0) {
			// 测试 集合是否有值
			/* 添加到集合中 */
			map.put("queryAddress", queryAddress);
			// 返回成功页面
			return "success";
		}
		// 返回失败页面
		return "failer";
	}

	/**
	 * 修改抢单状态
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:10:46
	 * @param status
	 *            状态
	 * @param qiangorderId
	 *            抢单Id
	 * @param map
	 *            集合对象
	 */
	@RequestMapping(value = "updateStatus/{Status}/{qiangorderId}", method = RequestMethod.GET)
	@ResponseBody
	public void updateStatus(@RequestParam("Status") Integer status, @RequestParam("qiangorderId") String qiangorderId,
			Map<String, Object> map) {
		/* 调用修改状态的方法 */
		qiangordertabService.updateStatus(status, qiangorderId);

	}

}
