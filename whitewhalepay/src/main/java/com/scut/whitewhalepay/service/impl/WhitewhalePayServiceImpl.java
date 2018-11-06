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

import com.scut.whitewhalepay.dao.UnderwriterDAO;
import com.scut.whitewhalepay.enity.Underwriter;
import com.scut.whitewhalepay.service.UnderwriterService;
import com.scut.whitewhalepay.service.WhitewhalePayService;
import com.scut.whitewhalepay.util.IdCardUtil;
import com.scut.whitewhalepay.util.PhoneUtil;
import com.scut.whitewhalepay.util.PicUtil;

@Service
@Transactional
public class WhitewhalePayServiceImpl implements WhitewhalePayService {


	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.service.WhitewhalePayService#login(java.lang.String, java.lang.String)
	 */
	@Override
	/**
	 * 后台管理员登录，但是不应该提供注册接口，平台直接分配写入数据库
	 */
	public Map<String, Object> login(String mctIdentNo, String loginSecret) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.service.WhitewhalePayService#inform()
	 */
	@Override
	public void inform() {
		// TODO Auto-generated method stub
		
	}


	
	
	
}