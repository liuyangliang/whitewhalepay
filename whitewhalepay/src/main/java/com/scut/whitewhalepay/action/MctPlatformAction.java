package com.scut.whitewhalepay.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scut.whitewhalepay.service.MctPlatformService;
import com.scut.whitewhalepay.service.MerchantService;

import com.scut.whitewhalepay.util.PicUtil;

@Controller
public class MctPlatformAction extends ActionSupport  {

	private String mctIdentNo;
	private String loginSecret;
	private int  usdtAmount;    //本次发起交易的USDT量 
	private int  rnbAmount;  //本次发起交易的金额 
	private String transId;
	private File transactionPic;
	private String transactionPicName;
	private boolean isAlipay;
	private String bankcardNo;

	
	private HttpServletRequest request;
    private HttpServletResponse response;
    
	public void setMctIdentNo(String mctIdentNo) {
		this.mctIdentNo = mctIdentNo;
	}

	public void setLoginSecret(String loginSecret) {
		this.loginSecret = loginSecret;
	}
	public void setUsdtAmount(int usdtAmount) {
		this.usdtAmount = usdtAmount;
	}
	public void setTransactionPic(File transactionPic) {
		this.transactionPic = transactionPic;
	}
	public void setTransactionPicName(String transactionPicName) {
		this.transactionPicName = transactionPicName;
	}


	@Autowired
	private MctPlatformService mctPlatformService;

	private static final String RESULT_SUCCESS = "SUCCESS";
	private static final String RESULT_FAIL = "FAIL";

	/**
	 * 登录
	 * 
	 * @param mctIdentNo  商户身份证号
	 * @param loginSecret 登录密码
	 * @return
	 */
	public String beginTransactions() {
		Map<String, Object> result = mctPlatformService.beginTransactions(mctIdentNo, loginSecret,usdtAmount,rnbAmount);
		if (result.get("result").equals(RESULT_SUCCESS)) {
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
			session.put("BankInfo", result.get("BankInfo"));
			session.put("AlipayCode", result.get("AlipayCode"));
			return RESULT_SUCCESS;
		} else {
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
			session.put("result", RESULT_FAIL);
			return RESULT_FAIL;
		}
	}
	
	
	public String uploadPayInfo() {
		Map<String, Object> result = mctPlatformService.uploadPayInfo(transId, transactionPicName, transactionPic, isAlipay, bankcardNo);
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
		if (result.get("result").equals(RESULT_SUCCESS)) {
			session.put("result", RESULT_SUCCESS);
			return RESULT_SUCCESS;
		} else {
			session.put("result", RESULT_FAIL);
			session.put("signup_info", result.get("signup_info"));
			return RESULT_FAIL;
		}
	}




}
