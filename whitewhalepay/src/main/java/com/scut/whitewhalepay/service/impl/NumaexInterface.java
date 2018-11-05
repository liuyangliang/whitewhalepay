package com.scut.whitewhalepay.service.impl;

import java.io.File;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class NumaexInterface {
	
	/**
	 * 注册
	 * 
	 * @param IdentNo  身份证号
	 * @param Name   姓名
	 * @param Phone   电话
	 * @param IdCardPic1   身份证正面
	 * @param IdCardPic2  身份证反面
	 * @param PaySecret   支付密码
	 * 
	 * @return  成功主要返回用户USDT账户，应该就是USDT钱包地址吧
	 */
	public  Map<String, Object> signup(String IdentNo,  String Name, String Phone,File IdCardPic1,  File IdCardPic2,String PaySecret){
		
		final String RESULT_SUCCESS = "SUCCESS";
		final String RESULT_FAIL = "FAIL";
		boolean IsSucceed=false;
		Map<String, Object> rtn = new HashMap<String, Object>();
		
		
		//执行注册操作,注册完成，将IsSucceed设为true。
		
		
		if(IsSucceed) {
			
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("Account", "UserAccount");  //"UserAccount"应该为注册成功之后返回的用户的账户
			
		}
		else {
			rtn.put("result", RESULT_FAIL);		
		}
		return rtn;
	}
	
	/**
	 * 
	 * @param Account   用户账户
	 * @param PaySecret   支付密码  对于钱包不需要区分支付密码和登录密码了，认为只要登录白鲸平台，则默认登录了numaex钱包。可行吗？
	 * @return
	 */
	public  Map<String, Object> queryInfo(String Account,String PaySecret){
		
		final String RESULT_SUCCESS = "SUCCESS";
		final String RESULT_FAIL = "FAIL";
		boolean IsSucceed=false;
		Map<String, Object> rtn = new HashMap<String, Object>();
		
		
		//执行查询操作,查询完成，将IsSucceed设为true。需要定义如下用户类
		User userinfo=new User("Account", "Name", "Phone", "IdCardNo", 10000);
		
		if(IsSucceed) {
			
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("userinfo", userinfo);  
			
		}
		else {
			rtn.put("result", RESULT_FAIL);		
		}
		return rtn;
	}
	
	/**
	 * 修改用户信息  （好像也就只能修改手机号和密码）
	 * 
	 * @param Account  账户
	 * @param PaySecret   密码
	 * @param Phone   手机号
	 * @param NewPaySecret   新密码
	 * @return
	 */
public  Map<String, Object> update(String Account,String PaySecret,String Phone,String NewPaySecret){
	
		
		final String RESULT_SUCCESS = "SUCCESS";
		final String RESULT_FAIL = "FAIL";
		boolean IsSucceed=false;
		Map<String, Object> rtn = new HashMap<String, Object>();
		
		
		//执行修改操作,修改完成，将IsSucceed设为true。
		User userinfo=new User("Account", "Name", "Phone", "IdCardNo", 10000); //将用户新的信息返回
		
		if(IsSucceed) {
			
			rtn.put("result", RESULT_SUCCESS);
			rtn.put("userinfo", userinfo);

		}
		else {
			rtn.put("result", RESULT_FAIL);		
		}
		return rtn;
	}
	
/**
 * USDT转账交易
 * 
 * @param FromAccount  转出账户
 * @param ToAccount    转入账户
 * @param PaySecret    支付密码
 * @param TransationId   白鲸平台交易Id   
 * @param Amount     USDT转账数量
 * @return   返回交易信息，transferinfo就是一个转账类的一个对象，需要numaex定义一下。返回的TransationId也是白鲸平台交易Id，这个Id应该和numaex钱包自身交易ID是一对一关系
 */
public  Map<String, Object> transfer(String FromAccount,String ToAccount,String PaySecret,String TransationId,int Amount){
	
	
	final String RESULT_SUCCESS = "SUCCESS";
	final String RESULT_FAIL = "FAIL";
	boolean IsSucceed=false;
	Map<String, Object> rtn = new HashMap<String, Object>();
	
	
	//执行转账操作,转账完成，将IsSucceed设为true。
	
	
	if(IsSucceed) {
		
		rtn.put("result", RESULT_SUCCESS); 
		//rtn.put("transferinfo", transferinfo);     //transferinfo是一个转账交易记录，包含FromAccount,ToAccount,TransationId,Amount,BeginTime（开始时间   年月日时分秒），EndTIme（结束时间）
		

	}
	else {
		rtn.put("result", RESULT_FAIL);		
	}
	return rtn;
}


/**
 * 查询USDT转账交易记录，这个是给白鲸平台使用的接口
 * 
 * @param FromAccount    转出用户账户
 * @param ToAccount      转入用户账户
 * @param TransationId   白鲸平台交易Id
 * @param BeginTime     开始时间
 * @param EndTime        结束时间
 * @return
 */
public  Map<String, Object> queryTransactions(String FromAccount,String ToAccount,String TransationId,Time BeginTime,Time EndTime){
	
	
	final String RESULT_SUCCESS = "SUCCESS";
	final String RESULT_FAIL = "FAIL";
	boolean IsSucceed=false;
	Map<String, Object> rtn = new HashMap<String, Object>();
	
	
	//执行查询转账操作,查询完成，将IsSucceed设为true。几个查询参数每个都不是必须输入的
	//输入FromAccount，转账交易需要满足USDT转出账户为FromAccount
	//输入ToAccount，转账交易需要满足USDT转入账户为ToAccount
	//输入TransationId，根据白鲸平台交易Id查询
	//输入BeginTime，时间范围应在BeginTime之后
	//输入EndTime，时间范围应在EndTime之前
	//只要输入某一项输入不为空，则数据库查询条件应该是与的关系    FromAccount&ToAccount&TransationId&BeginTime&EndTime
	
	
	if(IsSucceed) {
		
		rtn.put("result", RESULT_SUCCESS); 
		//rtn.put("transferinfoList", transferinfoList);     //transferinfoList是一个transferinfo的list
		

	}
	else {
		rtn.put("result", RESULT_FAIL);		
	}
	return rtn;
}



     //numaex用户类
	 class User{
		private String Account;
		private String Name;
		private String Phone;
		private String IdCardNo;
		private int USDT_Amount;
		/**
		 * 
		 * @param Account  账户
		 * @param Name   姓名
		 * @param Phone   电话
		 * @param IdCardNo  身份证号
		 * @param USDT_Amount   USDT账户余额
		 */
		public User(String Account,String Name,String Phone,String IdCardNo, int USDT_Amount) {
			
			this.Account=Account;
			this.Name=Name;
			this.Phone=Phone;
			this.IdCardNo=IdCardNo;
			this.USDT_Amount=USDT_Amount;
		}
		public User() {
			
		}
		public String getAccount() {
			return this.Account;
		}
		public String getName() {
			return this.Name;
		}
		public String getPhone() {
			return this.Phone;
		}
		public String getIdCardNo() {
			return this.IdCardNo;
		}
		public int getUSDT_Amount() {
			return this.USDT_Amount;
		}
		
		public void SetAccount(String Account) {
			this.Account=Account;
		}
		
		public void SetName(String Name) {
			this.Name=Name;
				}
		public void SetPhone(String Phone) {
			this.Phone=Phone;
		}
		public void SetIdCardNo(String IdCardNo) {
			this.IdCardNo=IdCardNo;
		}
		public void SetUSDT_Amount(int USDT_Amount) {
			this.USDT_Amount=USDT_Amount;
		}

		
		
	}
	
}
