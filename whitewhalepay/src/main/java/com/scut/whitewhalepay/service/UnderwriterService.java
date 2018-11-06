package com.scut.whitewhalepay.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public interface UnderwriterService {
	public Map<String, Object> login(String mctIdentNo, String loginSecret);

	public Map<String, Object> signup(String uwIdentNo, String loginSecret, String uwName, String uwPhone,
			String uwAliPayName, File uwIdCardPic1, String uwIdCardPic1FileName, File uwIdCardPic2,
			String uwIdCardPic2FileName, File uwAliPayQrCode, String uwAliPayQrCodeFileName, File uwAliPayPic,
			String uwAliPayPicFileName);
	public void notification();
	
	
}
