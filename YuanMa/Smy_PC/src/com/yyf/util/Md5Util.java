package com.yyf.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	public static String md5(String pwd){
		return DigestUtils.md5Hex(pwd);
	}
	
	public static void main(String[] args) {
		String pwd="123456asdasf@#4";
		System.out.println(md5(pwd)+"//");
		System.out.println(md5(pwd));
	}
}
