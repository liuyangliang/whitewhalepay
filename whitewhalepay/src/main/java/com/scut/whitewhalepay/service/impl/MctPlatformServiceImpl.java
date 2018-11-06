package com.scut.whitewhalepay.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
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
import com.scut.whitewhalepay.dao.TransactionsDAO;
import com.scut.whitewhalepay.dao.UnderwriterDAO;
import com.scut.whitewhalepay.enity.BankCard;
import com.scut.whitewhalepay.enity.Margin;
import com.scut.whitewhalepay.enity.Merchant;
import com.scut.whitewhalepay.enity.Transactions;
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
	
	private static final Logger log = LoggerFactory.getLogger(MctPlatformServiceImpl.class);

	@Autowired
	private MerchantDAO merchantDAO;
	private UnderwriterDAO underwriteDAO;
	private MarginDAO marginDAO;
	private BankCardDAO bankcardDAO;
	private TransactionsDAO transactionsDAO;
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
						String uwId=marginList.get(0).getUwId().toString();
						Underwriter underwriter=underwriteDAO.findById(uwId);
					
						
						Transactions  transaction=new Transactions();
						String transId=UUID.randomUUID().toString();
						transaction.setTransId(transId);  
						transaction.setTransState(0);
						transaction.setTransBTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));   
						transaction.setTransAmt(rmbAmount);
						transaction.setTransUsdtAmt(usdtAmount);
						transaction.setMctId(mctIdentNo);
						transaction.setUwId(uwId);
						transaction.setUwUsdtAct(underwriter.getUwUsdtAct());
						transaction.setUwConfirm(false);			
						transactionsDAO.save(transaction);
	
						List<BankCard> bankcardList=bankcardDAO.findByUwId(uwId);
						String alipayCode=underwriter.getUwAliPayPic();
						rtn.put("result", RESULT_SUCCESS);
						rtn.put("transId", transId);
						rtn.put("uwId", uwId);
		    			rtn.put("bankInfo",bankcardList);  //暂时这样返回，但是这样返回不太好，商户jsp要想接收到还得定义一个BankCard类似的类。应该可以转化为map或者dictionary类型的
		    			rtn.put("alipayCode",alipayCode);  //暂时返回地址，最后应该返回图片。因为返回地址会暴露文件位置
		    		
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
	//这个接口似乎没必要写，这个应该是商户自己数据库就存了用户要查询的信息，不需要到我们这里查询的。而对于商户查询交易记录，在MerchantServiceImpl里面实现就可以啦
	public Map<String, Object> queryTransactions(String mctIdentNo, String loginSecret,String TransationId,Time BeginTime,Time EndTime) {
		// TODO Auto-generated method stub
		//新建一个实体，专门用于返回给商户查询的。从数据库Transactions表里面抽取一部分数据  
		
		return null;
	}





	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.service.MctPlatformService#uploadTransactionsPic(java.io.File)
	 */
	@Override
	public Map<String, Object> uploadPayInfo(String transId,String transactionPicName,File transactionPic,boolean isAlipay,String bankcardNo) {
		
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("result", RESULT_FAIL);
		
		Transactions  transaction=transactionsDAO.findById(transId);
		if(transaction==null) {
			rtn.put("result", RESULT_FAIL);
			rtn.put("info", "交易Id错误");
			return rtn;	
		}
	
		if (transactionPic == null) {
			rtn.put("upload_info", "上传图片为空");
			return rtn;
		}		
		
		//检测上传照片是否图片类型
		if (!PicUtil.isPic(transactionPicName)) {
			rtn.put("signup_info", "照片格式错误，应为.jpg/.jpeg/.png格式");
			return rtn;
		}
		
		if(!isAlipay) {
			List<BankCard> bankcardList= bankcardDAO.findByUwId(transaction.getUwId());
			boolean flag=false;
			for(int i=0;i<bankcardList.size();++i) {
				if(bankcardList.get(i).getBankCardNo().equals(bankcardNo)) {
					flag=true;
					transaction.setUwBankCard(bankcardNo);
					transaction.setTransType(0);
					break;					
				}
			}
			if(!flag) {
				
				rtn.put("result", RESULT_FAIL);
				rtn.put("info", "承兑商没有该银行卡");
				return rtn;	
			}
			
		}
		else 
			transaction.setTransType(1);  //1表示支付宝支付，0表示银行卡，未赋值表示没有支付。如果不行就把2定义为没有支付
		
		String transactionPicPath = "";
	
		try{
			transactionPicPath = PicUtil.saveTransactionPic(transactionPic,transactionPicName);
			
	    	}catch(Exception e) {
	    		
			log.error("save picture failed", e);
		}
		
		if (transactionPicPath.equals("")) {
			rtn.put("info", "照片保存出错");
			return rtn;
		}
		else 
			transaction.setTransactionPic(transactionPicPath);
		
		
		transactionsDAO.merge(transaction);			
		rtn.put("result", RESULT_SUCCESS);
		return rtn;
	}
	
	
	 
	 
}