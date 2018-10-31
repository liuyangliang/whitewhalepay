package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.TransType;


public interface TransTypeDAO {
	 public void save(TransType transientInstance);
	 public void delete(TransType persistentInstance);
	 public TransType findById( java.lang.String id);
	 public List<TransType> findByExample(TransType instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<TransTypeDAO> findByTransType(Object TransType);
	 public List findAll();
	 public int count();
	 public TransType merge(TransType detachedInstance);
	 public void attachDirty(TransType instance);
	 public void attachClean(TransType instance);
}
