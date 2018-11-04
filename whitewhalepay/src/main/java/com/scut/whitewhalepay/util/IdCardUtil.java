package com.scut.whitewhalepay.util;

import java.util.regex.Pattern;

public class IdCardUtil {
	 private static final String REGEX_IDCARDNO = "[1-9]{2}[0-9]{4}(19|20)[0-9]{2}"
            + "((0[1-9]{1})|(1[1-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))"
            + "[0-9]{3}[0-9x]{1}";
	 
	 public static boolean isIdCardNo(String isCardNo) {
		 Pattern pattern = Pattern.compile(REGEX_IDCARDNO);
	     return pattern.matcher(isCardNo).matches();
	 }
}
