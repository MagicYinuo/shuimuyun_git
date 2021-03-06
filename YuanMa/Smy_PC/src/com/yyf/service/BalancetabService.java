package com.yyf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyf.model.Balancetab;

/**
  * 文件名：BalancetabService.java
  * 描述： 余额操作
  * 修改人： 杨杰
  * 修改时间：2017年6月21日 下午2:45:44
  * 修改内容：
 */
public interface BalancetabService {

	/**
	 * 根据快客iD 得到账户余额
	 * @author 杨杰     
	 * @created 2017年6月21日 下午2:46:05  
	 * @param kuaikeId
	 * @return
	 */
	public Balancetab queryKuaikeId(String kuaikeId);
	
	
	/**
	 * 通过余额付款
	 * @author 杨杰     
	 * @created 2017年6月21日 下午9:39:28
	 * @param balance 余额
	 * @param xiaId 下单Id
	 * @return 
	 */
	public void updateBalance1(double balance,String kuaikeId,String zhifupwd);
	
	
	/**
	 * 根据快客Id和旧支付密码修改支付密码
	 * @author 杨杰     
	 * @created 2017年6月28日 下午4:51:48  
	 * @param newzhifupwd 新支付密码
	 * @param kuaikeId  快客Id
	 * @param zhiufpwd  旧支付密码
	 * @return
	 */
	public boolean updateZhifupwd(String newzhifupwd,String kuaikeId,String zhifupwd);
	
	/**
	 * @author 杨杰     
	 * @created 2017年6月22日 上午11:35:45  
	 * @return
	 */
	public List<Balancetab> queryallbalance();


	/**
	 * 插入该快客id的账户
	 * @author 田浩
	 * @created 2017年6月26日 上午11:43:42  
	 * @param kuaikeId 快客ID
	 * @return
	 */
	void insert(String kuaikeId, String out_trade_no,String zhifupwd);
	
	
	/**
	 * @author 田浩     
	 * @created 2017年6月26日 上午11:35:45  
	 * @return
	 */
	public void updateBalance(String out_trade_no,double total_fee);
	
	
	/**
	 * @author 田浩     
	 * @created 2017年6月26日 上午11:35:45  
	 * @return
	 */
	public void setKuaikeIdStatus(String kuaikeId,String out_trade_no);
	
	/**
	 * @author 田浩     
	 * @created 2017年6月26日 上午11:35:45  
	 * @return
	 */
	
	public String selectresult(String kuaikeId);
	
	/**
	 * @author 田浩     
	 * @created 2017年6月26日 上午11:35:45  
	 * @return
	 */
	
	public Balancetab selectfigure(String balanceId);
	
	/**
	 * @author 田浩     
	 * @created 2017年6月26日 上午11:35:45  
	 * @return
	 */
	public void setstatus(String out_trade_no );
	
	/**
	 * @author 田浩     
	 * @created 2017年6月26日 上午11:35:45  
	 * @return
	 */
	
	public String selectdeposit(String kuaikeId);
}
