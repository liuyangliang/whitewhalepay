/**
 * 
 */
package com.scut.whitewhalepay.service.impl;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.scut.whitewhalepay.dao.TransactionsDAO;
import com.scut.whitewhalepay.enity.Transactions;

import com.scut.whitewhalepay.service.PlatformService;

/**
 * @author Administrator
* @Title PlatFormServiceImpl.java
 *@param  
   *@return_type  
 * @Description: TODO
 */
public class PlatFormServiceImpl implements PlatformService {

	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.service.PlatFormService#transfer(java.lang.String)
	 */
	TransactionsDAO  transactionsDAO;
	private static final String RESULT_SUCCESS = "SUCCESS";
	private static final String RESULT_FAIL = "FAIL";
	
	
	 
	 
	 
	 @Override
	public Map<String, Object> transfer(String transId) {
		 
		// TODO Auto-generated method stub
		 Transactions	 transaction=transactionsDAO.findById(transId);
    	   transaction.setTransState(4);
    	   transaction.setUwConfirm(true);   //表示用户已经确认   
   		   transaction.setUsdtTransType(1);   //表示保证金转出
    	transactionsDAO.save(transaction);
    	 
		//在这个函数里面执行固定的平台USDT账户转到商户账户
//				HttpResponse<String> response = Unirest.post("http://111.230.254.134:8080/v1/usdt/transfer")
//			  .header("Content-Type", "application/json")
//			  .header("Cache-Control", "no-cache")
//			  .header("Postman-Token", "3dd0579c-a191-47ee-9d11-3487d60b39ca")
//			  .body("{\r\n\t\"tags\": [\r\n\t    \"usdt\"\r\n\t],\r\n\t\"description\": \"get list of transactions\",\r\n\t\"operationId\": \"Usdt.Get Transactions\",\r\n\t\"parameters\": [\r\n\t    {\r\n\t        \"in\": \"formData\",\r\n\t        \"name\": \"from\",\r\n\t        \"description\": \"JzvnVNGkBCRLrBempj4p9wL7hucxvan\", \r\n\t        \"required\": true,\r\n\t        \"type\": \"string\"\r\n\t    },\r\n\t    {\r\n\t        \"in\": \"formData\",\r\n\t        \"name\": \"to\",\r\n\t        \"description\": \"1MsJzvnVNGkBCRLrBempj4p9wL7hucxvan\", \r\n\t  \r\n\t        \"required\": true,\r\n\t        \"type\": \"string\"\r\n\t    },\r\n\t    {\r\n\t        \"in\": \"formData\",\r\n\t        \"name\": \"amount\",\r\n\t        \"description\": \"0\",\r\n\t        \"required\": true,\r\n\t        \"type\": \"number\",\r\n\t        \"format\": \"float\"\r\n\t    }\r\n\t]\r\n}")
//			  .asString();
			  
			  //根据返回的执行相关操作；  finish(transId,txId);
		

		return null;
	}
	
	 @Override
		public Map<String, Object> finish(String transId,String txId) {
			// TODO Auto-generated method stub
			Map<String, Object> rtn = new HashMap<String, Object>();
		         
			try {
			Transactions  transaction=transactionsDAO.findById(transId);
			transaction.setTxId(txId);
		    String time=new Time(0).toString();  //这个时间格式还不知道对不呢
			transaction.setTransETime(time);
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
