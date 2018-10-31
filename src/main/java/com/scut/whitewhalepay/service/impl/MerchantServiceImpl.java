package com.scut.whitewhalepay.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scut.whitewhalepay.dao.MerchantDAO;
import com.scut.whitewhalepay.enity.Merchant;
import com.scut.whitewhalepay.service.MerchantService;
import com.scut.whitewhalepay.util.IdCardUtil;
import com.scut.whitewhalepay.util.PhoneUtil;
import com.scut.whitewhalepay.util.PicUtil;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {
	
	private static final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);

	@Autowired
	private MerchantDAO merchantDAO;

	private static final String RESULT_SUCCESS = "SUCCESS";
	private static final String RESULT_FAIL = "FAIL";

	/**
	 * 登录
	 * 
	 * @param mctIdentNo  商户身份证号
	 * @param loginSecret 登录密码
	 * @return
	 */
	@Override
	public Map<String, Object> login(String mctIdentNo, String loginSecret) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		if (mctIdentNo == null || mctIdentNo.equals("") || loginSecret == null || loginSecret.equals(""))
			return rtn;
		List<Merchant> merchantList = merchantDAO.findByMctIdentNo(mctIdentNo);
		if (merchantList != null && merchantList.size() > 0
				&& loginSecret.equals(merchantList.get(0).getLoginSecret())) {
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("merchant", merchantList.get(0));
		}
		return rtn;
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
	@Override
	public Map<String, Object> signup(String mctIdentNo, String loginSecret, String mctName, String mctPhone,
			File mctIdCardPic1, String mctIdCardPic1FileName, File mctIdCardPic2, String mctIdCardPic2FileName) {
		
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		if (mctIdentNo == null || mctIdentNo.equals("") || loginSecret == null || loginSecret.equals("")
				|| mctName == null || mctName.equals("") || mctPhone == null || mctPhone.equals("")
				|| mctIdCardPic1 == null || mctIdCardPic2 == null || mctIdCardPic1FileName == null
				|| mctIdCardPic1FileName.equals("") || mctIdCardPic2FileName == null || mctIdCardPic2FileName.equals("")) {
			rtn.put("signup_info", "信息不完整");
			return rtn;
		}
		
		//验证身份证号码格式是否正确
		if (!IdCardUtil.isIdCardNo(mctIdentNo)) {
			rtn.put("signup_info", "身份证号码格式有误");
			return rtn;
		}
		
		//查询身份证号是否注册过
		if (merchantDAO.findByMctIdentNo(mctIdentNo).size() > 0) {
			rtn.put("signup_info", "该身份证号已被注册");
			return rtn;
		}
		
		//检测手机号码格式是否正确
		if (!PhoneUtil.isPhone(mctPhone)) {
			rtn.put("signup_info", "手机号格式有误");
			return rtn;
		}
		
		//检测上传照片是否图片类型
		if (!PicUtil.isPic(mctIdCardPic1FileName) || !PicUtil.isPic(mctIdCardPic2FileName)) {
			rtn.put("signup_info", "照片格式错误，应为.jpg/.jpeg/.png格式");
			return rtn;
		}
		
		//需要Usdt钱包账户注册接口
		String mctUsdtAct = "123456789"; 
		
		//验证身份证人证合一接口
		
		//保存证件照片
		String mctIdCardPic1Path = "";
		String mctIdCardPic2Path = "";
		try{
			mctIdCardPic1Path = PicUtil.save(mctIdCardPic1,mctIdCardPic1FileName);
			mctIdCardPic2Path = PicUtil.save(mctIdCardPic2,mctIdCardPic2FileName);
		}catch(Exception e) {
			log.error("save picture failed", e);
		}
		if (mctIdCardPic1Path.equals("") || mctIdCardPic2Path.equals("")) {
			rtn.put("signup_info", "照片保存出错");
			return rtn;
		}
		
		//保存信息到数据库
		Merchant merchant = new Merchant();
		merchant.setMctId(UUID.randomUUID().toString());
		merchant.setMctName(mctName);
		merchant.setLoginSecret(loginSecret);
		merchant.setMctUsdtAct(mctUsdtAct);
		merchant.setMctPhone(mctPhone);
		merchant.setMctIdentNo(mctIdentNo);
		merchant.setMctIdCardPic1(mctIdCardPic1Path);
		merchant.setMctIdCardPic2(mctIdCardPic2Path);
		merchantDAO.save(merchant);
		
		rtn.put("result", RESULT_SUCCESS);
		return rtn;
	}
}
