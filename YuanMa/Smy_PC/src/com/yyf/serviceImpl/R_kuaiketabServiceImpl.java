package com.yyf.serviceImpl;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyf.mapper.R_kuaiketabMapper;
import com.yyf.mapper.IBalanceMapper;
import com.yyf.model.R_kuaiketab;
import com.yyf.service.R_kuaiketabService;

/**
 * 文件名：R_kuaiketabServiceImpl.java 描述： 用户登陆注册 service接口的实现 修改人： 杨杰
 * 修改时间：2017年5月18日 下午3:50:32 修改内容：
 */
@Service
public class R_kuaiketabServiceImpl implements R_kuaiketabService {

	/* 自动添加依赖注入 */
	@Autowired
	private R_kuaiketabMapper kuaiketabMapper;
	
	// 自动装配	账户信息
	@Autowired
	private IBalanceMapper balanceMapper;

	@Override
	public void updateSFZImages(String kuaikeShenfenZF, String kuaikeShouchiSFZ, String kuaikeId) {
		kuaiketabMapper.updateSFZImages(kuaikeShenfenZF, kuaikeShouchiSFZ, kuaikeId);
	}
	
	@Override
	public void updataFirst(String kuaikeName, String kuaikePhone, String kuaikeAddressInfo, String kuaikeId) {
		kuaiketabMapper.updataFirst(kuaikeName, kuaikePhone, kuaikeAddressInfo, kuaikeId);
	}
	
	/**
	 * 根据用户名 手机号和密码登陆
	 * 
	 * @author 杨杰
	 * @created 2017年5月18日 下午3:51:15
	 * @param uname
	 *            手机号 用户名
	 * @param upass
	 *            密码
	 * @return
	 */
	@Override
	public R_kuaiketab login(String uname, String upass) {
		R_kuaiketab login = kuaiketabMapper.login(uname, upass);
		return login;
	}

	/**
	 * 根据快客Id修改快客登陆状态  0未通过审核  1通过审核  2在线 3离线
	 * @author 杨杰     
	 * @created 2017年6月12日 上午9:30:49  
	 * @param kuaikeStatus 0未通过审核  1通过审核  2在线 3离线
	 * @param kuaikeId 快客Id
	 */
	@Override
	public void updateKuaikeStatus(int kuaikeStatus, String kuaikeId) {
		kuaiketabMapper.updateKuaikeStatus(kuaikeStatus, kuaikeId);
	}
	
	
	/**
	 * 根据 用户名 查看 用户名是否存在相同
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:38:00
	 * @param kuaikeName
	 *            注册时的用户名
	 * @return
	 */
	@Override
	public R_kuaiketab selectUsername(String kuaikeName) {
		R_kuaiketab selectUsername = kuaiketabMapper.selectUsername(kuaikeName);
		return selectUsername;
	}

	/**
	 * // 手机号码查询是否已经注册
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:38:37
	 * @param kuaikePhone
	 *            手机号码
	 * @return
	 */
	@Override
	public R_kuaiketab selectKuaiKephone(String kuaikePhone) {
		R_kuaiketab selectKuaiKephone = kuaiketabMapper.selectKuaiKephone(kuaikePhone);
		return selectKuaiKephone;
	}

	/**
	 * 查询在线快客根据快客的状态 如果是3的话 就是在线的快客
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:40:05
	 * @return
	 */
	@Override
	public ArrayList<R_kuaiketab> selectU() {
		ArrayList<R_kuaiketab> selectU = kuaiketabMapper.selectU();
		return selectU;
	}

	/**
	 * 根据快客Id 删除快客信息
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:44:42
	 * @param kuaikeId
	 *            快客ID
	 * @return
	 */
	@Override
	public int deletetU(String kuaikeId) {
		int deletetU = kuaiketabMapper.deletetU(kuaikeId);
		return deletetU;
	}

	/**
	 * 根据自己的ID查看自己的注册信息
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:46:02
	 * @param kuaikeId
	 *            快客ID
	 * @return
	 */
	@Override
	public R_kuaiketab selectUser(String kuaikeId) {
		R_kuaiketab selectUser = kuaiketabMapper.selectUser(kuaikeId);
		return selectUser;
	}

	/**
	 * 用户通过手机号码找回密码
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:47:20
	 * @param kuaikePhone
	 *            手机号
	 * @return
	 */
	@Override
	public void findBackPassWord(String password, String kuaikePhone) {
		kuaiketabMapper.findBackPassWord(password, kuaikePhone);

	}

	/**
	 * 快客通过手机号码重置密码
	 * 
	 * @author 杨杰
	 * @created 2017年5月20日 上午10:49:10
	 * @param password
	 *            密码
	 * @param kuaikePhone
	 *            手机号码
	 * @return
	 */
	@Override
	public void updateUserpass(String password, String kuaikePhone) {
		kuaiketabMapper.updateUserpass(password, kuaikePhone);
	}

	/**
	 * PC 人工找回密码
	 * 
	 * @author 杨杰
	 * @created 2017年5月24日 上午10:53:49
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
	@Override
	public void updatePassword(String password, String kuaikeName, String kuaikePhone, String kuaikeAddress,
			String kuaikeAddressInfo) {
		kuaiketabMapper.updatePassword(password, kuaikeName, kuaikePhone, kuaikeAddress, kuaikeAddressInfo);

	}

	/**
	 * 快捷登陆【通过手机号码接收验证码登陆】
	 * 
	 * @author 杨杰
	 * @created 2017年5月23日 上午9:29:23
	 * @param kuaikePhone
	 *            手机号码
	 * @return
	 */
	@Override
	public R_kuaiketab phoneLogin(String kuaikePhone) {
		R_kuaiketab phoneLogin = kuaiketabMapper.phoneLogin(kuaikePhone);
		return phoneLogin;
	}

	/**
	 * 用户注册
	 * 
	 * @author 杨杰
	 * @created 2017年5月18日 下午3:52:05
	 * @param kuaiketab com.yyf.mapper.IBalanceMapper.insertBalance
	 *            实体集合对象
	 * @return
	 */
	@Override
	@Transactional
	public int addUser(R_kuaiketab kuaiketab) {
		int addUser = kuaiketabMapper.addUser(kuaiketab);
		
		return addUser;
	}

	/**
	 *  PC 通过人工找回密码 并且通过查询数据库中是否存在该用户信息 进行匹配
	 * 
	 * @author 杨杰
	 * @created 2017年5月26日 上午9:56:00
	 * @param kuaikeName
	 *            快客姓名
	 * @param kuaikePhone
	 *            快客电话
	 * @param kuaikeAddress
	 *            快客地 址
	 * @param kuaikeAddressInfo
	 *            详情地址【可选】
	 * @return 返回 0没有匹配的数据 1 有匹配的数据 匹配成功
	 */
	@Override
	public R_kuaiketab selectUpdatePasswordBykuaikeInfo(String kuaikeName, String kuaikePhone, String kuaikeAddress,
			String kuaikeAddressInfo) {
		R_kuaiketab supw = kuaiketabMapper.selectUpdatePasswordBykuaikeInfo(kuaikeName, kuaikePhone, kuaikeAddress,
				kuaikeAddressInfo);
		return supw;
	}
	
	
	
	
	
	/**
	 * APP 端 申诉找回密码  通过匹配快客的原有手机号 和 姓名 进行验证数据库中是否存在该用户
	 * @author 杨杰     
	 * @created 2017年6月16日 上午9:12:52  
	 * @param kuaikeName 快客姓名
	 * @param newkuaikePhone 现有手机号码
	 * @return
	 */
	@Override
	public R_kuaiketab selectPasswordBykuaikeInfo(String kuaikeName, String newkuaikePhone) {
		
		R_kuaiketab tab = kuaiketabMapper.selectPasswordBykuaikeInfo(kuaikeName, newkuaikePhone);
		
		return tab;
	}

	
	/**
	 * APP  通过对原手机号码进行换绑  再对密码进行找回
	 * @author 杨杰     
	 * @created 2017年6月15日 下午4:07:06  
	 * @param newkuaikePhone 现有手机号码
	 * @param kuaikeName  快客姓名
	 * @param kuaikePhone  原有电话
	 * @return
	 */
	@Override
	public int updatePasswordByAppeal(String newkuaikePhone,String kuaikeName,String kuaikePhone){
		
		int appeal = kuaiketabMapper.updatePasswordByAppeal(newkuaikePhone, kuaikeName, kuaikePhone);

		return appeal;
		
	}
	
	/**
	 * APP端 通过姓名和手机号找回密码
	 * @author 杨杰     
	 * @created 2017年6月16日 上午9:24:44  
	 * @param kuaikeName 快客姓名
	 * @param kuaikePhone  手机号
	 */
	@Override
	public void updatePasswordByKuaikeNameAndKuaikePhone(String password,String kuaikeName, String kuaikePhone) {

		kuaiketabMapper.updatePasswordByKuaikeNameAndKuaikePhone(password, kuaikeName, kuaikePhone);
		
	}
	
	

	/**
	 * 根据快客iD修改手机号码
	 * @author 杨杰     
	 * @created 2017年6月1日 下午4:13:24  
	 * @param kuaikePhone  手机号码
	 * @param kuaikeId  快客Id
	 */
	@Override
	public void updatePhoneById(String kuaikePhone, String kuaikeId) {

		kuaiketabMapper.updatePhoneById(kuaikePhone, kuaikeId);
	}


	/**
	 * APP 根据原有手机号和密码修改手机号码
	 * @author 杨杰     
	 * @created 2017年6月18日 上午12:12:28  
	 * @param regPhone 现有手机号
	 * @param lastPhone  原有手机号
	 * @param pass  密码
	 * @return
	 */
	@Override
	public boolean updatePhoneBykuaikePhoneAndPassword(String regPhone, String lastPhone, String password) {
		boolean f=kuaiketabMapper.updatePhoneByPhoneAndPwd(regPhone,lastPhone,password);
		if(f){
			return true;
			
		}
		return false;
	}

	/**
	 * APP 根据快客Id 和 原密码 对快客密码进行修改
	 * @author 杨杰     
	 * @created 2017年6月18日 上午1:01:30  
	 * @param newPassword 新密码
	 * @param kuaikeID   快客Id
	 * @param password  原密码
	 */
	@Override
	public int updatePassWordByOldPassword(String newPassword, String kuaikeId, String password) {
		
		int newpass = kuaiketabMapper.updatePassWordByOldPassword(newPassword, kuaikeId, password);
		
		return newpass;
	}

	

	

}
