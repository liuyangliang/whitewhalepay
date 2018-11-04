package com.scut.whitewhalepay.util;

import java.util.regex.Pattern;

public class PhoneUtil {
	 private static final String REGEX_MOBILE = "(134[0-8]\\d{7})" +
             "|(" +
                 "((13([0-3]|[5-9]))" +
                     "|149" +
                     "|15([0-3]|[5-9])" +
                     "|166" +
                     "|17(3|[5-8])" +
                     "|18[0-9]" +
                     "|19[8-9]" +
                 ")" +
             "\\d{8}" +
             ")";

	 /**
	  * 验证手机号码格式
	  * 
	  * @param phone  手机号码
	  * @return
	  */
	public static boolean isPhone(String phone) {
		return Pattern.matches(REGEX_MOBILE, phone);
	}
}
