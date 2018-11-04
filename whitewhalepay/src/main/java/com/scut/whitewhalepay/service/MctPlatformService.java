package com.scut.whitewhalepay.service;

import java.io.File;
import java.util.Map;

public interface MctPlatformService {
	
	
	/**
	 * @param mctIdentNo
	 * @param loginSecret
	 * @param usdtAmount
	 * @param rmbAmount
	 * @return
	 */
	
	public Map<String, Object> beginTransactions(String mctIdentNo, String loginSecret, int usdtAmount, int rmbAmount);
	//商户平台用户上传交易凭证（初期是照片，后期弄视频，更安全，防止钓鱼），并通知白鲸平台。白鲸平台收到商户用户支付凭证后，人工审核后提醒承兑商付款

	
	public Map<String, Object> QueryTransactions(String mctIdentNo, String loginSecret,int tranAmount);


	/**
	 * @param transactionPicName
	 * @param transactionPic
	 * @return
	 */
	Map<String, Object> uploadTransactionsPic(String transactionPicName, File transactionPic);
	
	
	
}
