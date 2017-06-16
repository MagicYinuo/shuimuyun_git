package com.yyf.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import com.yyf.model.R_kuaiketab;
import com.yyf.model.R_qiangordertab;
import com.yyf.model.R_xiaordertab;

/**
 * 文件名：R_qiangordertabMapper.java 描述： 我要抢单 修改人： 杨杰 修改时间：2017年5月18日 下午6:45:44
 * 修改内容：
 */
public interface R_qiangordertabMapper {

	/**
	 * 根据快客Id,下单id以及抢单状态，得到抢单记录，返回下单单子数据
	 * @author lijie
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId    	快客Id
	 * @param status		抢单状态
	 * @param xiaId			下单id
	 * return 下单数据
	 */
	@Select(value="SELECT xi.* "	
			+ " FROM qiangordertab q INNER JOIN xiaordertab xi ON q.`xiaId`=xi.`xiaId` "
			+ " WHERE q.kuaikeId=#{kuaikeId} AND q.status=#{status}  AND q.xiaId=#{xiaId}")
	public R_xiaordertab queryIdStatusXiaId(@Param("kuaikeId") String kuaikeId,@Param("status")int status,@Param("xiaId")String xiaId);
	
	/**
	 * 根据快客Id以及抢单状态，得到抢单记录，返回下单单子数据
	 * @author lijie
	 * @created 2017年6月5日 下午3:30:05
	 * @param kuaikeId    	快客Id
	 * @param status		抢单状态
	 * return 下单数据集合
	 */
	//@Select(value="SELECT xi.kuaikeId,xi.xiaId,xi.kuaikeName,xi.kuaikePhone,xi.kuaikeAddress,xi.shouhuoName,xi.shouhuoPhone,xi.shouhuoAddress,xi.shouhuoAddressInfo,xi.quhouDate,xi.kaikePrioes,xi.status,xi.okDate,xi.shopName,xi.Shopzholiang,xi.ShopNumer,xi.Shopprices,xi.shopguige,xi.Shopdate,xi.kuaikeAddressInfo,xi.shopType,xi.timeString,xi.shopImages,xi.payment"
	@Select(value="SELECT xi.* "	
			+ " FROM qiangordertab q INNER JOIN xiaordertab xi ON q.`xiaId`=xi.`xiaId` "
			+ " WHERE q.kuaikeId=#{kuaikeId} AND q.status=#{status}")
	public List<R_xiaordertab> queryIdStatus(@Param("kuaikeId") String kuaikeId,@Param("status")int status);
	
	
	/**
	 * 当快客点击抢单的时候 进行信息的填写
	 * 
	 * @author 杨杰
	 * @created 2017年5月18日 下午6:41:00
	 * @param qiangordertab
	 *            抢单实体集合对象
	 * @return 返回 0 表示添加失败 1表示抢单成功
	 */
	@Insert("insert into qiangordertab(qiangId,xiaId,kuaikeId,status,qiangDate) values(#{qiangId},#{xiaId},#{kuaikeId},#{status},#{qiangDate})")
	public int Insert(@Param("qiangId") String qiangId,@Param("xiaId") String xiaId,@Param("kuaikeId") String kuaikeId,@Param("status") int status,@Param("qiangDate") Date qiangDate);

	/**
	 * 得到List 集合对象 得到一个抢单记录
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 上午9:46:32
	 * @return 返回List
	 */
	@Select("select * from qiangordertab")
	public List<R_qiangordertab> query();
	
	/**
	 * 根据下单Id查询 快客的id，姓名，电话
	 * @author 杨杰     
	 * @created 2017年5月26日 下午2:25:36  
	 * @param xiaId  下单ID
	 * @return  返回一个实体对象
	 */
	@Select("SELECT q.`kuaikeId`,k.`kuaikeName`,k.`kuaikePhone` FROM qiangordertab AS q INNER JOIN kuaiketab AS k ON q.`kuaikeId`=k.`kuaikeId` WHERE q.`xiaId`=#{xiaId}")
	public R_kuaiketab querytKuaike(@Param("xiaId") String xiaId);
	

	/**
	 * 得到数据总条数
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 上午9:47:13
	 * @return 返回总条数
	 */
	@Select("select count(*) from qiangordertab")
	public int queryCount();

	/**
	 * 根据抢单id删除抢单信息
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 上午9:47:50
	 * @param qiangorderId
	 *            抢单ID
	 * @return 返回一个 数值 0失败 1成功
	 */
	@Delete("delete from qiangordertab where qiangorderId=#{qiangorderId}")
	public int delete(@Param("qiangorderId") String qiangorderId);

	/**
	 * 根据抢单Id修改状态
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 上午11:34:35
	 * @param status
	 *            抢单状态'状态',状态(0=抢单成功，1=抢单失败，2=等待取货，3=等待配送（点击确认配送），4=已经到达（修改下单状态2，确认到达），5=派单成功)
	 * @param qiangorderId
	 *            抢单ID
	 */
	@Update("update qiangordertab set status=#{status} where qiangorderId=#{qiangorderId}")
	public void updateStatus(@Param("status") Integer status, @Param("qiangorderId") String qiangorderId);

	/**
	 * 根据地图 进行模糊查询 匹配 附近的单子 地址 及 收货人的地址
	 * 
	 * @author 杨杰
	 * @created 2017年5月19日 下午3:04:57
	 * @param kuaikeAddress
	 *            快客地址
	 * @param shouhuoAddress
	 *            收货人地址
	 * @return 返回一个List集合对象
	 */
	@Select("select * from xiaordertab  where  kuaikeAddress like '%${kuaikeAddress}%' or shouhuoAddress like '%${shouhuoAddress}%'")
	public List<R_xiaordertab> queryAddress(@Param("kuaikeAddress") String kuaikeAddress,
			@Param("shouhuoAddress") String shouhuoAddress);
	
	
	/**
	 * 根据快客Id得到抢单记录信息
	 * @author 杨杰     
	 * @created 2017年6月5日 下午3:15:23  
	 * @param kuaikeId  快客Id
	 * @return
	 */
	@Select("SELECT * FROM qiangordertab AS q INNER JOIN kuaiketab k ON q.`kuaikeId`=k.`kuaikeId` where k.kuaikeId=#{kuaikeId}")
	public List<R_qiangordertab> queryQiangOrderBykuaikeId(@Param("kuaikeId") String kuaikeId);

}
