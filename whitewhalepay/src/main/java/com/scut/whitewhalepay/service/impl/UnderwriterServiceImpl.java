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

import com.scut.whitewhalepay.dao.TransactionsDAO;
import com.scut.whitewhalepay.dao.UnderwriterDAO;
import com.scut.whitewhalepay.enity.Transactions;
import com.scut.whitewhalepay.enity.Underwriter;
import com.scut.whitewhalepay.service.UnderwriterService;
import com.scut.whitewhalepay.util.IdCardUtil;
import com.scut.whitewhalepay.util.PhoneUtil;
import com.scut.whitewhalepay.util.PicUtil;

@Service
@Transactional
public class UnderwriterServiceImpl implements UnderwriterService {

	private static final Logger log = LoggerFactory.getLogger(UnderwriterServiceImpl.class);
	
	@Autowired
	private UnderwriterDAO underwriterDAO;
	private TransactionsDAO transactionsDAO;

	private static final String RESULT_SUCCESS = "SUCCESS";
	private static final String RESULT_FAIL = "FAIL";

	/**
	 * 登录
	 * 
	 * @param uwIdentNo   承兑商身份证号码
	 * @param loginSecret 登录密码
	 * @return
	 */
	@Override
	public Map<String, Object> login(String uwIdentNo, String loginSecret) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		if (uwIdentNo == null || uwIdentNo.equals("") || loginSecret == null || loginSecret.equals(""))
			return rtn;
		List<Underwriter> underwriterList = underwriterDAO.findByUwIdentNo(uwIdentNo);
		if (underwriterList != null && underwriterList.size() > 0
				&& loginSecret.equals(underwriterList.get(0).getLoginSecret())) {
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("underwriter", underwriterList.get(0));
		}
		return rtn;
	}

	/**
	 * 注册
	 * 
	 * @param uwIdentNo              承兑商身份证号码
	 * @param loginSecret            登录密码
	 * @param uwName                 承兑商姓名
	 * @param uwPhone                承兑商手机号码
	 * @param uwAliPayName           承兑商支付宝名称
	 * @param uwIdCardPic1           承兑商身份证正面照
	 * @param uwIdCardPic1FileName   承兑商身份证正面照文件名
	 * @param uwIdCardPic2           承兑商身份证反面照
	 * @param uwIdCardPic2FileName   承兑商身份证反面照文件名
	 * @param uwAliPayQrCode         承兑商支付宝二维码
	 * @param uwAliPayQrCodeFileName 承兑商支付宝二维码文件名
	 * @param uwAliPayPic            承兑商支付宝头像
	 * @param uwAliPayPicFileName    承兑商支付宝头像文件名
	 */
	@Override
	public Map<String, Object> signup(String uwIdentNo, String loginSecret, String uwName, String uwPhone,
			String uwAliPayName, File uwIdCardPic1, String uwIdCardPic1FileName, File uwIdCardPic2,
			String uwIdCardPic2FileName, File uwAliPayQrCode, String uwAliPayQrCodeFileName, File uwAliPayPic,
			String uwAliPayPicFileName) {

		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		if (uwIdentNo == null || uwIdentNo.equals("") || loginSecret == null || loginSecret.equals("") || uwName == null
				|| uwName.equals("") || uwPhone == null || uwPhone.equals("") || uwAliPayName == null
				|| uwAliPayName.equals("") || uwIdCardPic1 == null || uwIdCardPic1FileName == null
				|| uwIdCardPic1FileName.equals("") || uwIdCardPic2 == null || uwIdCardPic2FileName == null
				|| uwIdCardPic2FileName.equals("") || uwAliPayQrCode == null || uwAliPayQrCodeFileName == null
				|| uwAliPayQrCodeFileName.equals("") || uwAliPayPic == null || uwAliPayPicFileName == null
				|| uwAliPayPicFileName.equals("")) {
			rtn.put("signup_info", "信息不完整");
			return rtn;
		}

		// 验证身份证号码格式是否正确
		if (!IdCardUtil.isIdCardNo(uwIdentNo)) {
			rtn.put("signup_info", "身份证格式输入有误");
			return rtn;
		}

		// 查询身份证号是否注册过
		if (underwriterDAO.findByUwIdentNo(uwIdentNo).size() > 0) {
			rtn.put("signup_info", "该身份证号已被注册");
			return rtn;
		}

		// 检测手机号码格式是否正确
		if (!PhoneUtil.isPhone(uwPhone)) {
			rtn.put("signup_info", "手机号格式有误");
			return rtn;
		}
		
		//检测上传照片是否图片类型
		if (!PicUtil.isPic(uwIdCardPic1FileName) || !PicUtil.isPic(uwIdCardPic2FileName) || !PicUtil.isPic(uwAliPayQrCodeFileName) 
				||!PicUtil.isPic(uwAliPayPicFileName)) {
			rtn.put("signup_info", "照片格式错误，应为.jpg/.jpeg/.png格式");
			return rtn;
		}
		
		//需要Usdt钱包账户注册接口
		String uwUsdtAct = "123456789"; 
		
		//验证身份证人证合一接口
		
		//保存照片
		String uwIdCardPic1Path = "";
		String uwIdCardPic2Path = "";
		String uwAliPayQrCodePath = "";
		String uwAliPayPicPath = "";
		try{
			uwIdCardPic1Path = PicUtil.save(uwIdCardPic1,uwIdCardPic1FileName);
			uwIdCardPic2Path = PicUtil.save(uwIdCardPic2,uwIdCardPic2FileName);
			uwAliPayQrCodePath = PicUtil.save(uwAliPayQrCode, uwAliPayQrCodeFileName);
			uwAliPayPicPath = PicUtil.save(uwAliPayPic, uwAliPayPicFileName);
		}catch(Exception e) {
			log.error("save picture failed", e);
		}
		if (uwIdCardPic1Path.equals("") || uwIdCardPic2Path.equals("") 
				|| uwAliPayQrCodePath.equals("") || uwAliPayPicPath.equals("")) {
			rtn.put("signup_info", "照片保存出错");
			return rtn;
		}
		
		//保存信息到数据库
		Underwriter underwriter = new Underwriter();
		underwriter.setUwId(UUID.randomUUID().toString());
		underwriter.setUwName(uwName);
		underwriter.setLoginSecret(loginSecret);
		underwriter.setUwUsdtAct(uwUsdtAct);
		underwriter.setUwIdentNo(uwIdentNo);
		underwriter.setUwPhone(uwPhone);
		underwriter.setUwIdCardPic1(uwIdCardPic1Path);
		underwriter.setUwIdCardPic2(uwIdCardPic2Path);
		underwriter.setUwAliPayName(uwAliPayName);
		underwriter.setUwAliPayQrCode(uwAliPayQrCodePath);
		underwriter.setUwAliPayPic(uwAliPayPicPath);
		underwriterDAO.save(underwriter);
		
		rtn.put("result", RESULT_SUCCESS);
		return rtn;
	}


	
	@Override
	public Map<String, Object> inform(String transId, String uwIdentNo,String mctUSDTAct, int usdtAmount) {
		// TODO Auto-generated method stub
		Map<String, Object> rtn = new HashMap<String, Object>();
	         
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("transId", transId);
			rtn.put("uwIdentNo", uwIdentNo);
			rtn.put("mctUSDTAct", mctUSDTAct);
			rtn.put("usdtAmount", usdtAmount);
		return rtn;
	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryTransactions(int model) {
		// TODO Auto-generated method stub
		Map<String, Object> rtn = new HashMap<String, Object>();
		List<Transactions>  transactionsList=null;
		
		try {
	    
			switch(model) {
			
			case 0: transactionsList=transactionsDAO.findByProperty("UwConfirm", false); break;
			case 1: transactionsList=transactionsDAO.findByProperty("UwConfirm", true); break;
			case 2: transactionsList=transactionsDAO.findAll();
			}
	   
		    rtn.put("result", RESULT_SUCCESS);
			rtn.put("transactionsList", transactionsList);
			return rtn;
		}catch(Exception e) {
			
			log.error("query database error", e);
			rtn.put("result", RESULT_FAIL);
			rtn.put("info", "query database error");
			return rtn;
		}
	
		
	}
	@Override
	public Map<String, Object> confirm(String transId) {
		// TODO Auto-generated method stub
		Map<String, Object> rtn = new HashMap<String, Object>();
	         
		try {
		Transactions  transaction=transactionsDAO.findById(transId);
		transaction.setUwConfirm(true);    
		transaction.setUsdtTransType(0);  //调用这个接口，则是承兑商自己转出的。
		transactionsDAO.save(transaction);
		
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("info", "交易完成！");
			
		return rtn;
		}catch(Exception e) {
			
			rtn.put("result", RESULT_FAIL);
			rtn.put("info", "交易失败，承兑商重新确认！");  //如果这情况，自动重新执行Confirm操作？因为是转账USDT成功之后自动调用的     算了还是前端过段时间再次请求吧
			return rtn;
			
		}
	
	}

	
}
