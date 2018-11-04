package com.scut.whitewhalepay.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.scut.whitewhalepay.dao.BankCardDAO;
import com.scut.whitewhalepay.dao.MarginDAO;
import com.scut.whitewhalepay.dao.MerchantDAO;
import com.scut.whitewhalepay.dao.UnderwriterDAO;
import com.scut.whitewhalepay.enity.BankCard;
import com.scut.whitewhalepay.enity.Margin;
import com.scut.whitewhalepay.enity.Merchant;
import com.scut.whitewhalepay.enity.Underwriter;
import com.scut.whitewhalepay.service.MctPlatformService;
import com.scut.whitewhalepay.service.MerchantService;
import com.scut.whitewhalepay.util.IdCardUtil;
import com.scut.whitewhalepay.util.PhoneUtil;
import com.scut.whitewhalepay.util.PicUtil;

import javassist.runtime.Desc;

@Service
@Transactional
public class MctPlatformServiceImpl implements MctPlatformService {
	
	private static final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);

	@Autowired
	private MerchantDAO merchantDAO;
	private UnderwriterDAO underwriteDAO;
	private MarginDAO marginDAO;
	private BankCardDAO bankcardDAO;
	HttpServletResponse response;
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
	public Map<String, Object> beginTransactions(String mctIdentNo, String loginSecret,int usdtAmount,int rmbAmount) {
		
		//其实是不是有那种客户端和服务器维持一个会话进程，这样可以不用每次都要传递账户和密码
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		if (mctIdentNo == null || mctIdentNo.equals("") || loginSecret == null || loginSecret.equals(""))
			return rtn;
		List<Merchant> merchantList = merchantDAO.findByMctIdentNo(mctIdentNo);
		if (merchantList != null && merchantList.size() > 0
				&& loginSecret.equals(merchantList.get(0).getLoginSecret())) {
			
			
			List<Margin> marginList=marginDAO.findByCondition(usdtAmount*2); 
			
				if(marginList!=null) {
						String UwId=marginList.get(0).getUwId().toString();
						Underwriter underwriter=underwriteDAO.findById(UwId);
						
						List<BankCard> bankcardList=bankcardDAO.findByUwId(UwId);
						String addr=underwriter.getUwAliPayPic();
						
						rtn.put("result", RESULT_SUCCESS);
		    			rtn.put("BankInfo",bankcardList);  //暂时这样返回，但是这样返回不太好，商户jsp要想接收到还得定义一个BankCard类似的类。应该可以转化为map或者dictionary类型的
		    			rtn.put("AlipayCode",addr);  //暂时返回地址，最后应该返回图片。因为返回地址会暴露文件位置
	
				}
				else {
					  rtn.put("result", RESULT_FAIL);
			          rtn.put("FAIL_INFO", "交易USDT数额太大，不存在匹配承兑商");
					
				}
			
			
			
			
//			 BufferedImage img = new BufferedImage(300, 150, BufferedImage.TYPE_INT_RGB);
//		     img = PicUtil.getInputStream(addr);
//		    //Map<String, Object> response = (Map<String, Object>) ActionContext.getContext().get("response");
//			
//		     if(img==null){
//		           // throw new RuntimeException("打印图片异常：com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
//		            rtn.put("result", RESULT_FAIL);
//		            rtn.put("FAIL_INFO", "打印图片异常：com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
//		        }
//		        if(img!=null){
//		        	
//		        	 try {
//						ImageIO.write(img, "png", response.getOutputStream());
//						rtn.put("result", RESULT_SUCCESS);
//		    			rtn.put("img",response.getOutputStream());
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		            	
//		     
//		        }
				
				
		}
		return rtn;
	}
	
	

	

	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.service.MctPlatformService#QueryTransactions(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Map<String, Object> QueryTransactions(String mctIdentNo, String loginSecret, int tranAmount) {
		// TODO Auto-generated method stub
		return null;
	}





	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.service.MctPlatformService#uploadTransactionsPic(java.io.File)
	 */
	@Override
	public Map<String, Object> uploadTransactionsPic(String transactionPicName,File transactionPic) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		if (transactionPic == null) {
			rtn.put("upload_info", "上传图片为空");
			return rtn;
		}
		
		
		
		//检测上传照片是否图片类型
		if (!PicUtil.isPic(transactionPicName)) {
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