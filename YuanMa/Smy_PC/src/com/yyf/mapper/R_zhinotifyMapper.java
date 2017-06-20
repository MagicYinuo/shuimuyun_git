package com.yyf.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface R_zhinotifyMapper {
	/**
	 * 微信回调修改订单状态
	 * 
	 * @author 田浩
	 * @created 2017年6月17日 下午2:41:00
	 * @param 
	 *            
	 * @return 
	 */
	@Update("UPDATE order_table SET openid=#{openid},is_subscribe=#{is_subscribe},bank_type=#{bank_type},cash_fee=#{cash_fee}"
			+ ",nonce_str=#{nonce_str},result_code=#{result_code},return_code=#{return_code},sign=#{sign}"
			+ ",time_end=#{time_end},total_fee=#{total_fee}"
			+ " WHERE out_trade_no=#{out_trade_no}")
	public int UpdateOrder(@Param("openid") String openid,@Param("is_subscribe") String is_subscribe
			,@Param("out_trade_no") String out_trade_no
			,@Param("bank_type") String bank_type,@Param("cash_fee") String cash_fee
			,@Param("nonce_str") String nonce_str,@Param("result_code") String result_code
			,@Param("return_code") String return_code,@Param("sign") String sign
			,@Param("time_end") String time_end,@Param("total_fee") String total_fee
			);
}
