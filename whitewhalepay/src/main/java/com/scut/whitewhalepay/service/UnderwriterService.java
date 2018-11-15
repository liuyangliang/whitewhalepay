package com.scut.whitewhalepay.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public interface UnderwriterService {
	
	/**
	 * 
	 * @param mctIdentNo
	 * @param loginSecret
	 * @return
	 */
	public Map<String, Object> login(String mctIdentNo, String loginSecret);

	/**
	 * 
	 * @param uwIdentNo
	 * @param loginSecret
	 * @param uwName
	 * @param uwPhone
	 * @param uwAliPayName
	 * @param uwIdCardPic1
	 * @param uwIdCardPic1FileName
	 * @param uwIdCardPic2
	 * @param uwIdCardPic2FileName
	 * @param uwAliPayQrCode
	 * @param uwAliPayQrCodeFileName
	 * @param uwAliPayPic
	 * @param uwAliPayPicFileName
	 * @return
	 */
	public Map<String, Object> signup(String uwIdentNo, String loginSecret, String uwName, String uwPhone,
			String uwAliPayName, File uwIdCardPic1, String uwIdCardPic1FileName, File uwIdCardPic2,
			String uwIdCardPic2FileName, File uwAliPayQrCode, String uwAliPayQrCodeFileName, File uwAliPayPic,
			String uwAliPayPicFileName);
	
	
	/**
	 * function：当商户执行发起交易时，白鲸匹配到承兑商之后，通知承兑商做好准备，这些信息存在 
	 * 
	 * @param transId
	 * @param mctUSDTAct
	 * @param mctUSDTAct2 
	 * @param usdtAmount
	 * @return
	 */
	public Map<String, Object> inform(String transId, String uwIdentNo, String mctUSDTAct, int usdtAmount);

	/**
	 * @param model  用于表示承兑商是否确认，确认表示已经支付。model 0：未确认订单  1：确认订单   2：全部订单  
	 * @return
	 */
	Map<String, Object> queryTransactions(int model);

	

	/**
	 * 功能描述:交易完成时候调用。当承兑商转账之后，收到numaex的返回的信息，成功之后调用此接口通知后台表示承兑商已经支付
	 * @param transId
	 * @param txId
	 * @return
	 */
	Map<String, Object> finish(String transId, String txId);

	
	/**
	 * 功能描述：承兑商发起USDT转账请求
	 * @param transId
	 * @param uwId
	 * @param paySecret
	 * @return
	 */
	Map<String, Object> transfer(String transId, String uwId, String paySecret);

	/**
	 * @param transId
	 * @return
	 */
	Map<String, Object> confirm(String transId);

	/**
	 * @param n
	 * @param transId
	 * @return
	 */
	boolean timer(int n, String transId);
	
	
}
