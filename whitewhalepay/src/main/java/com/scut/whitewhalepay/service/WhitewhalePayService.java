package com.scut.whitewhalepay.service;

import java.io.File;
import java.util.Map;

public interface WhitewhalePayService {
	//专门写给白鲸平台管理员的操作的接口
	public Map<String, Object> login(String mctIdentNo, String loginSecret);
	
	//商户用户完成支付，后台审核通过过，主动发起通知，调用商户接口notification
	public void inform();
}
