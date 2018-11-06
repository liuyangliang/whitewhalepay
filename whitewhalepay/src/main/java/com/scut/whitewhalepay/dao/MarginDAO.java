package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.Margin;


public interface MarginDAO {
	 public void save(Margin transientInstance);
	 public void delete(Margin persistentInstance);
	 public Margin findById( java.lang.String id);
	 public List<Margin> findByExample(Margin instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<MarginDAO> findByAmount(Object Amount); 
	 public List findAll();
	 public int count();
	 public Margin merge(Margin detachedInstance);
	 public void attachDirty(Margin instance);
	 public void attachClean(Margin instance);
	/**
	 * @param string
	 * @param i
	 * @return
	 */
	public List<Margin> findByCondition(int usdtAmount);
}
