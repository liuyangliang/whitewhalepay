/**
 * 
 */
package com.scut.whitewhalepay.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.scut.whitewhalepay.service.PlatformService;
import com.scut.whitewhalepay.service.impl.PlatFormServiceImpl;

/**
 * @author Administrator
* @Title PlatFormAction.java
 *@param  
   *@return_type  
 * @Description: TODO
 */

public class PlatFormAction extends ActionSupport {
	private String transId;
	
	/**
	 * @return the transId
	 */
	public String getTransId() {
		return transId;
	}


	/**
	 * @param transId the transId to set
	 */
	public void setTransId(String transId) {
		this.transId = transId;
	}


	private PlatformService platFormService;
	
	
	public Map<String, Object> transfer() {
		
		Map<String, Object> result = platFormService.transfer(transId);
		
		return result;
		
		
	}

}
