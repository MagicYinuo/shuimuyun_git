package com.yyf.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.yyf.model.R_kuaiketab;

/**
 * 文件名：R_kuaiketabService.java 描述： 用户登陆 注册 service接口 修改人： 杨杰 修改时间：2017年5月18日
 * 下午3:48:51 修改内容：
 */
public interface R_kuaiketabService {

	/**
	 * 
	 * 修改身份证正反面，手持身份证
	 * @author lijie     
	 * @created 2017年6月17日 下午3:27:37  
	 * @param kuaikeShenfenZF		身份证正反面
	 * @param kuaikeShouchiSFZ		手持身份证照片
	 * @param kuaikeId				快客id
	 */
	public void updateSFZImages(String kuaikeShenfenZF,String kuaikeShouchiSFZ, String kuaikeId);
	
	/**
	 * 
	 * 根据快客id修改用户名，电话号码，快客详细地址
	 * @author lijie     
	 * @created 2017年6月17日 下午2:21:23  
	 * @param kuaikeName			姓名
	 * @param kuaikePhone			电话号码
	 * @param kuaikeAddressInfo		快客详细地址
	 * @param kuaikeId				快客id
	 */
	public void updataFirst(String kuaikeName, String kuaikePhone,String kuaikeAddressInfo, String kuaikeId);
	
	/**
	 * 根据用户名或手机号 和密码登陆
	 * 
	 * @author 杨杰
	 * @created 2017年5月18日 下午3:49:22
	 * @param uname
	 *            用户名 手机号
	 * @param upass
	 *            密码
	 * @return
	 */
	// This Is A LOGIN METHOD ACCODING TO UNAME AND UPASS
	public R_kuaiketab login(String uname, String upass);
	
	/**
	 * 根据快客Id修改快客登陆状态  0未通过审核  1通过审核  2在线 3离线
	 * @author 杨杰     
	 * @created 2017年6月12日 上午9:28:58  
	 * @param kuaikeStatus 0未通过审核  1通过审核  2在线 3离线
	 * @param kuaikeId 快客ID
	 */
	public void updateKuaikeStatus(int kuaikeStatus,String kuaikeId);

	/**
	 * 根据 用户名 查看 用户名是否存在相同
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:24:22
	 * @param kuaikeName
	 *            快客名称
	 * @return // 用户名查询是否相同
	 */
	public R_kuaiketab selectUsername(String kuaikeName);

	/**
	 * // 手机号码查询是否已经注册
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:25:38
	 * @param kuaikePhone
	 *            手机号
	 * @return
	 */
	public R_kuaiketab selectKuaiKephone(String kuaikePhone);

	/**
	 * // 查询注册信息&& 查看 在线的快客数量
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:26:00
	 * @return
	 */
	public ArrayList<R_kuaiketab> selectU();

	/**
	 * 根据 快客Id 删除快客信息
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:26:14
	 * @param kuaikeId
	 *            快客Id
	 * @return
	 */
	public int deletetU(String kuaikeId);

	/**
	 * 根据自己的Id查看自己的注册信息
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:27:00
	 * @param kuaikeId
	 *            自己的信息
	 * @return
	 */
	public R_kuaiketab selectUser(String kuaikeId);

	/**
	 * 用户通过手机号找回密码
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:16:39
	 * @param kuaikePhone
	 *            手机号
	 * @return
	 */
	public void findBackPassWord(String password,String kuaikePhone);

	/**
	 * PC 人工找回密码
	 * 
	 * @author 杨杰
	 * @created 2017年5月24日 上午10:50:57
	 * @param password
	 *            密码【重置密码】
	 * @param kuaikeName
	 *            快客姓名
	 * @param kuaikePhone
	 *            快客电话
	 * @param kuaikeAddress
	 *            快客地址
	 * @param kuaikeAddressInfo
	 *            快客详情地址【可选】
	 * @return
	 */
	public void updatePassword(String password, String kuaikeName, String kuaikePhone, String kuaikeAddress,
			String kuaikeAddressInfo);

	
	/**
	 * PC 通过人工找回密码   查询数据中是否存在该用户  则进行匹配  并且得到 对应的返回结果 
	 * @author 杨杰     
	 * @created 2017年5月26日 上午9:53:00  
	 * @param kuaikeName  快客姓名
	 * @param kuaikePhone   快客电话
	 * @param kuaikeAddress   快客地址
	 * @param kuaikeAddressInfo   详情地址【可选】
	 * @return
	 */
	public R_kuaiketab selectUpdatePasswordBykuaikeInfo(String kuaikeName, String kuaikePhone, String kuaikeAddress,
			String kuaikeAddressInfo);

	
	
	/**
	 * APP 端 申诉找回密码  通过匹配快客的原有手机号 和 姓名 进行验证数据库中是否存在该用户
	 * @author 杨杰     
	 * @created 2017年6月16日 上午9:12:52  
	 * @param kuaikeName 快客姓名
	 * @param kuaikePhone 原有手机号码
	 * @return
	 */
	public R_kuaiketab selectPasswordBykuaikeInfo(String kuaikeName,String newkuaikePhone);
	
	/**  
	 * APP 通过现有的手机号码 对以前的手机号码进行换绑处理  再找回密码进行申诉找回
	 * @author 杨杰     
	 * @created 2017年6月15日 下午4:10:00  
	 * @param newkuaikePhone  现有手机号码
	 * @param kuaikeName     快客姓名
	 * @param kuaikePhone   原有手机号码
	 * @return
	 */
	public int updatePasswordByAppeal(String newkuaikePhone,String kuaikeName,String kuaikePhone);
	
	
	/**
	 * APP端 通过姓名和手机号找回密码
	 * @author 杨杰     
	 * @created 2017年6月16日 上午9:24:44  
	 * @param kuaikeName
	 * @param kuaikePhone
	 */
	public void updatePasswordByKuaikeNameAndKuaikePhone(String password,String kuaikeName,String newkuaikePhone);
	
	
	
	/**
	 * 用户根据手机号 重置密码
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:17:19
	 * @param password
	 *            密码
	 * @param kuaikePhone
	 *            手机号
	 * @return
	 */
	public void updateUserpass(String password, String kuaikePhone);

	/**
	 * 根据手机号码接收验证码进行登陆【快捷登陆】
	 * 
	 * @author 杨杰
	 * @created 2017年5月23日 上午9:28:08
	 * @param kuaikePhone
	 *            手机号码
	 * @return
	 */
	public R_kuaiketab phoneLogin(String kuaikePhone);

	/**
	 * 用户注册
	 * 
	 * @author 杨杰
	 * @created 2017年5月18日 下午3:50:02
	 * @param kuaiketab
	 *            实体集合对象
	 * @return
	 */
	public int addUser(R_kuaiketab kuaiketab);
	
	/**
	 * 根据快客Id修改手机号码
	 * @author 杨杰     
	 * @created 2017年6月1日 下午4:12:29  
	 * @param kuaikePhone  手机号码
	 * @param kuaikeId  快客Id
	 */
	public void updatePhoneById(String kuaikePhone,String kuaikeId);
}
