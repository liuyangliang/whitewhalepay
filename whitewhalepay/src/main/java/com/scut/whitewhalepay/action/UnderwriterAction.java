package com.scut.whitewhalepay.action;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scut.whitewhalepay.service.UnderwriterService;

@Controller
public class UnderwriterAction extends ActionSupport {

	private String uwIdentNo;
	private String loginSecret;
	private String uwName;
	private String uwPhone;
	private String uwAliPayName;
	private File uwIdCardPic1;
	private String uwIdCardPic1FileName;
	private File uwIdCardPic2;
	private String uwIdCardPic2FileName;
	private File uwAliPayQrCode;
	private String uwAliPayQrCodeFileName;
	private File uwAliPayPic;
	private String uwAliPayPicFileName;
	private String transId;
	private String mctUSDTAct;
	private int usdtAmount;
	private int model;
	
	public void setUwIdentNo(String uwIdentNo) {
		this.uwIdentNo = uwIdentNo;
	}

	public void setLoginSecret(String loginSecret) {
		this.loginSecret = loginSecret;
	}

	public void setUwName(String uwName) {
		this.uwName = uwName;
	}

	public void setUwPhone(String uwPhone) {
		this.uwPhone = uwPhone;
	}

	public void setUwAliPayName(String uwAliPayName) {
		this.uwAliPayName = uwAliPayName;
	}

	public void setUwIdCardPic1(File uwIdCardPic1) {
		this.uwIdCardPic1 = uwIdCardPic1;
	}

	public void setUwIdCardPic1FileName(String uwIdCardPic1FileName) {
		this.uwIdCardPic1FileName = uwIdCardPic1FileName;
	}

	public void setUwIdCardPic2(File uwIdCardPic2) {
		this.uwIdCardPic2 = uwIdCardPic2;
	}

	public void setUwIdCardPic2FileName(String uwIdCardPic2FileName) {
		this.uwIdCardPic2FileName = uwIdCardPic2FileName;
	}

	public void setUwAliPayQrCode(File uwAliPayQrCode) {
		this.uwAliPayQrCode = uwAliPayQrCode;
	}

	public void setUwAliPayQrCodeFileName(String uwAliPayQrCodeFileName) {
		this.uwAliPayQrCodeFileName = uwAliPayQrCodeFileName;
	}

	public void setUwAliPayPic(File uwAliPayPic) {
		this.uwAliPayPic = uwAliPayPic;
	}

	public void setUwAliPayPicFileName(String uwAliPayPicFileName) {
		this.uwAliPayPicFileName = uwAliPayPicFileName;
	}

	@Autowired
	private UnderwriterService underwriterService;

	private static final String RESULT_SUCCESS = "SUCCESS";
	private static final String RESULT_FAIL = "FAIL";

	/**
	 * 登录
	 * 
	 * @param mctIdentNo  商户身份证号
	 * @param loginSecret 登录密码
	 * @return
	 */
	public String login() {
		Map<String, Object> result = underwriterService.login(uwIdentNo, loginSecret);
		if (result.get("result").equals(RESULT_SUCCESS)) {
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
			session.put("underwriter", result.get("underwriter"));
			return RESULT_SUCCESS;
		} else {
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("login_state", RESULT_FAIL);
			return RESULT_FAIL;
		}
	}

	public String signup() {
		Map<String, Object> result = underwriterService.signup(uwIdentNo, loginSecret, uwName, uwPhone, uwAliPayName,
				uwIdCardPic1, uwIdCardPic1FileName, uwIdCardPic2, uwIdCardPic2FileName, uwAliPayQrCode,
				uwAliPayQrCodeFileName, uwAliPayPic, uwAliPayPicFileName);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		if (result.get("result").equals(RESULT_SUCCESS)) {
			request.put("signup_state", RESULT_SUCCESS);
			return RESULT_SUCCESS;
		} else {
			request.put("signup_state", RESULT_FAIL);
			request.put("signup_info", result.get("signup_info"));
			return RESULT_FAIL;
		}
	}
	
	/**
	 * 暂时没用
	 * @return
	 */
	public String inform() {
		Map<String, Object> result = underwriterService.inform(transId, uwIdentNo,mctUSDTAct, usdtAmount);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		if (result.get("result").equals(RESULT_SUCCESS)) {
			request.put("signup_state", RESULT_SUCCESS);
			return RESULT_SUCCESS;
		} else {
			request.put("signup_state", RESULT_FAIL);
			request.put("signup_info", result.get("signup_info"));
			return RESULT_FAIL;
		}
	}
	
	
	
	public String queryTransactions() {
		Map<String, Object> result = underwriterService.queryTransactions(model);
		@SuppressWarnings("unchecked")
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		if (result.get("result").equals(RESULT_SUCCESS)) {
			request.put("result", RESULT_SUCCESS);
			request.put("transactionsList", result.get("transactionsList"));
			return RESULT_SUCCESS;
		} else {
			request.put("result", RESULT_FAIL);
			request.put("info", result.get("info"));
			return RESULT_FAIL;
		}
	}
	
	public String confirm() {
		Map<String, Object> result = underwriterService.confirm(transId);
		@SuppressWarnings("unchecked")
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		if (result.get("result").equals(RESULT_SUCCESS)) {
			request.put("confirm_state", RESULT_SUCCESS);
			return RESULT_SUCCESS;
		} else {
			request.put("confirm_state", RESULT_FAIL);
			request.put("confirm_info", result.get("info"));
			return RESULT_FAIL;
		}
	}
	
	

}
