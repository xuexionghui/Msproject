package com.junlaninfo.entity;

public class Msmerchant {
	/*
	 * CREATE TABLE `msmerchant` (
  `id` int(100) NOT NULL,
  `merchantname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `merchantaccount` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `merchantpassword` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `merchantscope` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `merchantshopname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


	 */
	
	private  int id;
	private String  merchantname;     //商户名
	private String  merchantaccount;  //
	private String merchantpassword;//商户密码
	private String merchantscope;//商户经营范围
	private String merchantshopname;//商户店名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMerchantname() {
		return merchantname;
	}
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}
	public String getMerchantaccount() {
		return merchantaccount;
	}
	public void setMerchantaccount(String merchantaccount) {
		this.merchantaccount = merchantaccount;
	}
	public String getMerchantpassword() {
		return merchantpassword;
	}
	public void setMerchantpassword(String merchantpassword) {
		this.merchantpassword = merchantpassword;
	}
	public String getMerchantscope() {
		return merchantscope;
	}
	public void setMerchantscope(String merchantscope) {
		this.merchantscope = merchantscope;
	}
	public String getMerchantshopname() {
		return merchantshopname;
	}
	public void setMerchantshopname(String merchantshopname) {
		this.merchantshopname = merchantshopname;
	}
	@Override
	public String toString() {
		return "Msmerchant [id=" + id + ", merchantname=" + merchantname + ", merchantaccount=" + merchantaccount
				+ ", merchantpassword=" + merchantpassword + ", merchantscope=" + merchantscope + ", merchantshopname="
				+ merchantshopname + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
  
}
