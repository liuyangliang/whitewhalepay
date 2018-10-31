package com.scut.whitewhalepay.action;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scut.whitewhalepay.service.MerchantService;

@Controller
public class MerchantAction extends ActionSupport {

	private String mctIdentNo;
	private String loginSecret;
	private String mctName;
	private String mctPhone;
	private File mctIdCardPic1;
	private String mctIdCardPic1FileName;
	private File mctIdCardPic2;
	private String mctIdCardPic2FileName;

	public void setMctIdentNo(String mctIdentNo) {
		this.mctIdentNo = mctIdentNo;
	}

	public void setLoginSecret(String loginSecret) {
		this.loginSecret = loginSecret;
	}

	public void setMctName(String mctName) {
		this.mctName = mctName;
	}

	public void setMctPhone(String mctPhone) {
		this.mctPhone = mctPhone;
	}

	public void setMctIdCardPic1(File mctIdCardPic1) {
		this.mctIdCardPic1 = mctIdCardPic1;
	}

	public void setMctIdCardPic1FileName(String mctIdCardPic1FileName) {
		this.mctIdCardPic1FileName = mctIdCardPic1FileName;
	}

	public void setMctIdCardPic2(File mctIdCardPic2) {
		this.mctIdCardPic2 = mctIdCardPic2;
	}

	public void setMctIdCardPic2FileName(String mctIdCardPic2FileName) {
		this.mctIdCardPic2FileName = mctIdCardPic2FileName;
	}

	@Autowired
	private MerchantService merchantService;

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
		Map<String, Object> result = merchantService.login(mctIdentNo, loginSecret);
		if (result.get("result").equals(RESULT_SUCCESS)) {
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
			session.put("merchant", result.get("merchant"));
			return RESULT_SUCCESS;
		} else {
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("login_state", RESULT_FAIL);
			return RESULT_FAIL;
		}
	}

	/**
	 * 注册
	 * 
	 * @param mctIdentNo            商户身份证号码
	 * @param loginSecret           登录密码
	 * @param mctName               商户姓名
	 * @param mctPhone              商户手机号码
	 * @param mctIdCardPic1                商户身份证正面照
	 * @param mctIdCardPic1FileName 商户身份证正面照文件名
	 * @param mctIdCardPic2                商户身份证反面照
	 * @param mctIdCardPic2FileName 商户身份证反面照文件名
	 * @return
	 */
	public String signup() {
		Map<String, Object> result = merchantService.signup(mctIdentNo, loginSecret, mctName, mctPhone, mctIdCardPic1,
				mctIdCardPic1FileName, mctIdCardPic2, mctIdCardPic2FileName);
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

}
