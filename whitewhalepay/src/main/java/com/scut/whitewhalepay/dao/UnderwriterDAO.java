package com.scut.whitewhalepay.dao;

import java.util.List;

import com.scut.whitewhalepay.enity.Underwriter;


public interface UnderwriterDAO {
	 public void save(Underwriter transientInstance);
	 public void delete(Underwriter persistentInstance);
	 public Underwriter findById( java.lang.String id);
	 public List<Underwriter> findByExample(Underwriter instance);
	 public List findByProperty(String propertyName, Object value);
	 public List<Underwriter> findByUwName(Object UwName);
	 public List<Underwriter> findByLoginSecret(Object LoginSecret);
	 public List<Underwriter> findByUwUsdtAct(Object UwUsdtAct);
	 public List<Underwriter> findByUwIdentNo(Object UwIdentNo);
	 public List<Underwriter> findByUwPhone(Object UwPhone);
	 public List<Underwriter> findByUwIdCardPic1(Object UwIdCardPic1);
	 public List<Underwriter> findByUwIdCardPic2(Object UwIdCardPic2);
	 public List<Underwriter> findByUwAliPayName(Object UwAliPayName);
	 public List<Underwriter> findByUwAliPayQrCode(Object UwAliPayQeCode);
	 public List<Underwriter> findByUwAliPayPic(Object UwAliPayPic) ;
	 public List findAll();
	 public int count();
	 public Underwriter merge(Underwriter detachedInstance);
	 public void attachDirty(Underwriter instance);
	 public void attachClean(Underwriter instance);
}
