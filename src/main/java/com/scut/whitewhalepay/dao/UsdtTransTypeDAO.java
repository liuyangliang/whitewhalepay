package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.UsdtTransType;


public interface UsdtTransTypeDAO {
	 public void save(UsdtTransType transientInstance);
	 public void delete(UsdtTransType persistentInstance);
	 public UsdtTransType findById( java.lang.String id);
	 public List<UsdtTransType> findByExample(UsdtTransType instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<UsdtTransType> findByUsdtTransType(Object UsdtTransType);
	 public List findAll();
	 public int count();
	 public UsdtTransType merge(UsdtTransType detachedInstance);
	 public void attachDirty(UsdtTransType instance);
	 public void attachClean(UsdtTransType instance);
}
