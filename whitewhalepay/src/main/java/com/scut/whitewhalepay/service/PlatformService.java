/**
 * 
 */
package com.scut.whitewhalepay.service;

import java.util.Map;

/**
 * @author Administrator
* @Title PlatFormService.java
 *@param  
   *@return_type  
 * @Description: TODO
 */
public interface PlatformService {

	/**
	 * @param transId 
	 * @return
	 */
	Map<String, Object> transfer(String transId);

	/**
	 * @param transId
	 * @param txId
	 * @return
	 */
	Map<String, Object> finish(String transId, String txId);


}
