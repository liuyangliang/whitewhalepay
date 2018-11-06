package com.scut.whitewhalepay.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.scut.whitewhalepay.enity.BankCard;

public interface BankCardDAO {
	 public void save(BankCard transientInstance);
	 public void delete(BankCard persistentInstance);
	 public BankCard findById( java.lang.String id);
	 public List<BankCard> findByExample(BankCard instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<BankCard> findByUwId(Object BankCardNo);
	 public List<BankCard> findByBankInfo(Object BankInfo);
	 public List findAll();
	 public int count();
	 public BankCard merge(BankCard detachedInstance);
	 public void attachDirty(BankCard instance);
	 public void attachClean(BankCard instance);
}
