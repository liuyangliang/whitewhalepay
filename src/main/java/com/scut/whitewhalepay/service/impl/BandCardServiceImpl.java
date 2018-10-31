package com.scut.whitewhalepay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scut.whitewhalepay.dao.BandCardDAO;
import com.scut.whitewhalepay.enity.BandCard;
import com.scut.whitewhalepay.service.BandCardService;

@Service
@Transactional
public class BandCardServiceImpl implements BandCardService {

	@Autowired
	BandCardDAO bandCardDAO;
	
	@Override
	public List<BandCard> getAll() {
		return bandCardDAO.getAll();
	}
}
