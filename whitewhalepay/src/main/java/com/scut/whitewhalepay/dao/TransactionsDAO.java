package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.Transactions;


public interface TransactionsDAO {
	 public void save(Transactions transientInstance);
	 public void delete(Transactions persistentInstance);
	 public Transactions findById( java.lang.String id);
	 public List<Transactions> findByExample(Transactions instance);
	 public List findByProperty(String propertyName, Object value); 
	 public List<Transactions> findByTransType(Object TransType);
	 public List<Transactions> findByUsdtTransType(Object UsdtTransType);
	 public List<Transactions> findByTransState(Object TransState);
	 public List<Transactions> findByReason(Object Reason);
	 public List<Transactions> findByTransBTime(Object TransBTime);
	 public List<Transactions> findByTransETime(Object TransETime);
	 public List<Transactions> findByTransAmt(Object TransAmt);
	 public List<Transactions> findByTransUsdtAmt(Object TransUsdtAmt);
	 public List<Transactions> findByMctId(Object MctId);
	 public List<Transactions> findByUwId(Object UwId);
	 public List<Transactions> findByUwUsdtAct(Object UwUsdtAct);
	 public List<Transactions> findByUwBankCard(Object UwBankCard);
	 public List findAll();
	 public int count();
	 public Transactions merge(Transactions detachedInstance);
	 public void attachDirty(Transactions instance);
	 public void attachClean(Transactions instance);
}
