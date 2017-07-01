package com.yyf.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 文件名： R_xiaordertab.java 描述： 下单实体表 修改人： lijie 修改时间： 2017年5月16日 下午3:49:20 修改内容：
 */
public class R_xiaordertab {

	
	
	@Override
	public String toString() {
		return "R_xiaordertab [vehicle=" + vehicle + ", distance=" + distance + ", xiaId=" + xiaId
				+ ", kuaikeName=" + kuaikeName + ", kuaikePhone=" + kuaikePhone + ", kuaikeAddress=" + kuaikeAddress
				+ ", shouhuoName=" + shouhuoName + ", shouhuoPhone=" + shouhuoPhone + ", shouhuoAddress="
				+ shouhuoAddress + ", shouhuoAddressInfo=" + shouhuoAddressInfo + ", quhouDate=" + quhouDate
				+ ", kaikePrioes=" + kaikePrioes + ", status=" + status + ", okDate=" + okDate + ", shopName="
				+ shopName + ", shopzholiang=" + shopzholiang + ", shopNumer=" + shopNumer + ", shopprices="
				+ shopprices + ", shopGuige=" + shopGuige + ", shopDate=" + shopDate + ", kuaikeAddressInfo="
				+ kuaikeAddressInfo + ", shopType=" + shopType + ", timeString=" + timeString + ", shopImages="
				+ shopImages + ", payment=" + payment + ", kuaikeId=" + kuaikeId + "]";
	}

	private String vehicle;//  `vehicle` VARCHAR(200) DEFAULT NULL COMMENT '交通工具',
	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	private double distance;//	  `distance` INT(11) DEFAULT NULL COMMENT '货物体积'

	public double getDistance() {
		return distance;
	}


	public R_xiaordertab(String vehicle, double distance, String xiaId, String kuaikeName, String kuaikePhone,
			String kuaikeAddress, String shouhuoName, String shouhuoPhone, String shouhuoAddress,
			String shouhuoAddressInfo, String quhouDate, Float kaikePrioes, int status, String okDate, String shopName,
			float shopzholiang, int shopNumer, float shopprices, String shopGuige, Date shopDate,
			String kuaikeAddressInfo, String shopType, String timeString, String shopImages, int payment,
			String kuaikeId, double shoulng, double shoulat, double falng, double falat) {
		super();
		this.vehicle = vehicle;
		this.distance = distance;
		this.xiaId = xiaId;
		this.kuaikeName = kuaikeName;
		this.kuaikePhone = kuaikePhone;
		this.kuaikeAddress = kuaikeAddress;
		this.shouhuoName = shouhuoName;
		this.shouhuoPhone = shouhuoPhone;
		this.shouhuoAddress = shouhuoAddress;
		this.shouhuoAddressInfo = shouhuoAddressInfo;
		this.quhouDate = quhouDate;
		this.kaikePrioes = kaikePrioes;
		this.status = status;
		this.okDate = okDate;
		this.shopName = shopName;
		this.shopzholiang = shopzholiang;
		this.shopNumer = shopNumer;
		this.shopprices = shopprices;
		this.shopGuige = shopGuige;
		this.shopDate = shopDate;
		this.kuaikeAddressInfo = kuaikeAddressInfo;
		this.shopType = shopType;
		this.timeString = timeString;
		this.shopImages = shopImages;
		this.payment = payment;
		this.kuaikeId = kuaikeId;
		this.shoulng = shoulng;
		this.shoulat = shoulat;
		this.falng = falng;
		this.falat = falat;
	}

	public R_xiaordertab() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String xiaId;// 下单id `xiaId` VARCHAR(64) NOT NULL,

	public String getXiaId() {
		return xiaId;
	}

	public void setXiaId(String xiaId) {
		this.xiaId = xiaId;
	}

	private String kuaikeName;// 快客名称 `kuaikeName` VARCHAR(11) NOT NULL,

	public String getKuaikeName() {
		return kuaikeName;
	}

	public void setKuaikeName(String kuaikeName) {
		this.kuaikeName = kuaikeName;
	}

	private String kuaikePhone;// 快客电话 `kuaikePhone` VARCHAR(100) NOT NULL,

	public String getKuaikePhone() {
		return kuaikePhone;
	}

	public void setKuaikePhone(String kuaikePhone) {
		this.kuaikePhone = kuaikePhone;
	}

	private String kuaikeAddress;// 快客地址 `kuaikeAddress` VARCHAR(100) NOT NULL,

	public String getKuaikeAddress() {
		return kuaikeAddress;
	}

	public void setKuaikeAddress(String kuaikeAddress) {
		this.kuaikeAddress = kuaikeAddress;
	}

	private String shouhuoName;// 收货人名称 `shouhuoName` VARCHAR(11) NOT NULL,

	public String getShouhuoName() {
		return shouhuoName;
	}

	public void setShouhuoName(String shouhuoName) {
		this.shouhuoName = shouhuoName;
	}

	private String shouhuoPhone;// 收货人电话 `shouhuoShone` VARCHAR(11) NOT NULL,

	public String getShouhuoShone() {
		return shouhuoPhone;
	}

	public void setShouhuoShone(String shouhuoPhone) {
		this.shouhuoPhone = shouhuoPhone;
	}

	private String shouhuoAddress;// 收货人地址 `shouhuoAddress` VARCHAR(100) NOT
									// NULL,

	public String getShouhuoAddress() {
		return shouhuoAddress;
	}

	public void setShouhuoAddress(String shouhuoAddress) {
		this.shouhuoAddress = shouhuoAddress;
	}

	private String shouhuoAddressInfo;// 收货人地址详情

	public String getShouhuoAddressInfo() {
		return shouhuoAddressInfo;
	}

	public void setShouhuoAddressInfo(String shouhuoAddressInfo) {
		this.shouhuoAddressInfo = shouhuoAddressInfo;
	}

	private String quhouDate;// 去获取时间 `quhouDate` TIMESTAMP NOT NULL DEFAULT
							// CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

	public String getQuhuoDate() {
		return quhouDate;
	}

	public void setQuhuoDate(String quhouDate) {
		this.quhouDate = quhouDate;
	}

	private Float kaikePrioes;// 运费 `kaikePrioes` DECIMAL(10,0) NOT NULL,
	public Float getKaikePrioes() {
		return kaikePrioes;
	}

	public void setKaikePrioes(Float kaikePrioes) {
		this.kaikePrioes = kaikePrioes;
	}

	private int status;// 订单状态(0=未接单,1={配送中，已接单}，2=已到达（点击确认到达，修改抢单状态）) `status`
						// TINYINT(4) NOT NULL,

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private String okDate;// 到达时间 `okDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00
						// 00:00:00'

	public String getOkDate() {
		return okDate;
	}

	public void setOkDate(String okDate) {
		this.okDate = okDate;
	}

	private String shopName;// `shopName` VARCHAR(64) NOT NULL COMMENT '商品名称',

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	private float shopzholiang;// `Shopzholiang` FLOAT NOT NULL COMMENT '商品重量',

	public float getShopzholiang() {
		return shopzholiang;
	}

	public void setShopzholiang(float shopzholiang) {
		this.shopzholiang = shopzholiang;
	}

	private int shopNumer;// `ShopNumer`INT(11) NOT NULL DEFAULT 0 COMMENT '库存',

	public int getShopNumer() {
		return shopNumer;
	}

	public void setShopNumer(int shopNumer) {
		this.shopNumer = shopNumer;
	}

	private float shopprices;// `Shopprices` FLOAT NOT NULL COMMENT '商品价格',

	public float getShopprices() {
		return shopprices;
	}

	public void setShopprices(float shopprices) {
		this.shopprices = shopprices;
	}

	private String shopGuige;// `shopguige` varchar(100) NOT NULL COMMENT
								// '商品规格',

	public String getShopGuige() {
		return shopGuige;
	}

	public void setShopGuige(String shopGuige) {
		this.shopGuige = shopGuige;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shopDate;// `Shopdate` TIMESTAMP NOT NULL DEFAULT '0000-00-00
							// 00:00:00' COMMENT '上架时间',

	public Date getShopDate() {
		return shopDate;
	}

	public void setShopDate(Date shopDate) {
		this.shopDate = shopDate;
	}

	/****************************/
	/** add lijie 2017-05-24 ******/
	/****************************/

	private String kuaikeAddressInfo;// `kuaikeAddressInfo` VARCHAR(200) DEFAULT
										// NULL COMMENT '快客详细地址',

	public String getKuaikeAddressInfo() {
		return kuaikeAddressInfo;
	}

	public void setKuaikeAddressInfo(String kuaikeAddressInfo) {
		this.kuaikeAddressInfo = kuaikeAddressInfo;
	}

	private String shopType;// `shopType` INT(11) NOT NULL DEFAULT '0' COMMENT
							// '货物类型',

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	private String timeString;// `timeString` VARCHAR(10) NOT NULL DEFAULT '0'
								// COMMENT '最快取货时间',

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	private String shopImages;// `shopImages` VARCHAR(255) NOT NULL COMMENT
								// '商品图片',

	public String getShopImages() {
		return shopImages;
	}

	public void setShopImages(String shopImages) {
		this.shopImages = shopImages;
	}

	private int payment;// `payment` INT(11) NOT NULL DEFAULT '0' COMMENT '是否付款'

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	private String kuaikeId;//ALTER TABLE xiaordertab ADD kuaikeId VARCHAR(200) NOT NULL COMMENT '快客id';
	
	public String getKuaikeId() {
		return kuaikeId;
	}

	public void setKuaikeId(String kuaikeId) {
		this.kuaikeId = kuaikeId;
	}
	
	private double shoulng;//收获经度
	
	private double shoulat;//收获纬度
	
	private double falng;//发货经度
	
	private double falat;//发货纬度
	
	public String getShouhuoPhone() {
		return shouhuoPhone;
	}

	public void setShouhuoPhone(String shouhuoPhone) {
		this.shouhuoPhone = shouhuoPhone;
	}

	public String getQuhouDate() {
		return quhouDate;
	}

	public void setQuhouDate(String quhouDate) {
		this.quhouDate = quhouDate;
	}

	public double getShoulng() {
		return shoulng;
	}

	public void setShoulng(double shoulng) {
		this.shoulng = shoulng;
	}

	public double getShoulat() {
		return shoulat;
	}

	public void setShoulat(double shoulat) {
		this.shoulat = shoulat;
	}

	public double getFalng() {
		return falng;
	}

	public void setFalng(double falng) {
		this.falng = falng;
	}

	public double getFalat() {
		return falat;
	}

	public void setFalat(double falat) {
		this.falat = falat;
	}
	
	
	
}
