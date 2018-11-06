package com.scut.whitewhalepay.service;

import java.io.File;
import java.util.Map;

public interface MerchantService {
	public Map<String, Object> login(String mctIdentNo, String loginSecret);
	public Map<String, Object> signup(String mctIdentNo, String loginSecret, String mctName, String mctPhone,
			File mctIdCardPic1, String mctIdCardPic1FileName, File mctIdCardPic2, String mctIdCardPic2FileName);
}
