package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.Merchant;


public interface MerchantDAO {
	 public void save(Merchant transientInstance);
	 public void delete(Merchant persistentInstance);
	 public Merchant findById( java.lang.String id);
	 public List<Merchant> findByExample(Merchant instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<Merchant> findByMctName(Object MctName);
	 public List<Merchant> findByLoginSecret(Object LoginSecret);
	 public List<Merchant> findByMctUsdtAct(Object MctUsdtAct);
	 public List<Merchant> findByMctPhone(Object MctPhone);
	 public List<Merchant> findByMctIdentNo(Object MctIdentNo);
	 public List<Merchant> findByMctIdCardPic1(Object MctIdCardPic1);
	 public List<Merchant> findByMctIdCardPic2(Object MctIdCardPic2); 
	 public List findAll();
	 public int count();
	 public Merchant merge(Merchant detachedInstance);
	 public void attachDirty(Merchant instance);
	 public void attachClean(Merchant instance);
}
