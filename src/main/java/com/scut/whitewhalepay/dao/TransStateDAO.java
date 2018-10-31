package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.TransState;


public interface TransStateDAO {
	 public void save(TransState transientInstance);
	 public void delete(TransState persistentInstance);
	 public TransState findById( java.lang.String id);
	 public List<TransState> findByExample(TransState instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<TransState> findByTransState(Object TransState);
	 public List findAll();
	 public int count();
	 public TransState merge(TransState detachedInstance);
	 public void attachDirty(TransState instance);
	 public void attachClean(TransState instance);
}
