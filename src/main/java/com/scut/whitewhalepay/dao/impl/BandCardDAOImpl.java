package com.scut.whitewhalepay.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.scut.whitewhalepay.dao.BandCardDAO;
import com.scut.whitewhalepay.enity.BandCard;

@Repository
public class BandCardDAOImpl implements BandCardDAO{
	
	@Resource
    private SessionFactory sessionFactory;
	
	@Override
	 public List<BandCard> getAll() {
		System.out.println(sessionFactory.getCurrentSession().createQuery("FROM BandCard").list().get(0));
		return sessionFactory.getCurrentSession().createQuery("FROM BandCard").list();
		 
	 }
}
