package com.scut.whitewhalepay.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;


import com.scut.whitewhalepay.dao.TransactionsDAO;
import com.scut.whitewhalepay.enity.Transactions;


@Repository
public class TransactionsDAOImpl implements TransactionsDAO{
	private static final Logger log = LoggerFactory.getLogger(TransactionsDAOImpl.class);
	// property constants
	public static final String _TRANSTYPE = "transType";
	public static final String _USDTTRANSTYPE = "usdtTransType";
	public static final String _TRANSSTATE = "transState";
	public static final String _REASON = "reason";
	public static final String _TRANSBTIME = "transBTime";
	public static final String _TRANSETIME = "transETime";
	public static final String _TRANSAMT = "transAmt";
	public static final String _TRANSUSDTAMT = "transUsdtAmt";
	public static final String _MCTID = "mctId";
	public static final String _UWID = "uwID";
	public static final String _UWUSDTACT = "uwUsdtAct";
	public static final String _UWBANKCARD = "uwBankCard";
	public static final String _TransactionPic = "transactionPic";
	public static final String _UwConfirm = "uwConfirm";
 
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Transactions transientInstance) {
		log.debug("saving Transactions instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Transactions persistentInstance) {
		log.debug("deleting Transactions instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Transactions findById(java.lang.String id) {
		log.debug("getting Transactions instance with id: " + id);
		try {
			Transactions instance = (Transactions) getCurrentSession().get("com.scut.whitewhalpay.enity.Transactions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Transactions> findByExample(Transactions instance) {
		log.debug("finding Transactions instance by example");
		try {
			List<Transactions> results = (List<Transactions>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.Transactions").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Transactions instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Transactions as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<Transactions> findByTransType(Object TransType) {
		return findByProperty(_TRANSTYPE, TransType);
	}
	
	@Override
	public List<Transactions> findByUsdtTransType(Object UsdtTransType) {
		return findByProperty(_USDTTRANSTYPE, UsdtTransType);
	}

	@Override
	public List<Transactions> findByTransState(Object TransState) {
		return findByProperty(_TRANSSTATE, TransState);
	}
	
	@Override
	public List<Transactions> findByReason(Object Reason) {
		return findByProperty(_REASON, Reason);
	}
	
	@Override
	public List<Transactions> findByTransBTime(Object TransBTime) {
		return findByProperty(_TRANSBTIME, TransBTime);
	}
	
	@Override
	public List<Transactions> findByTransETime(Object TransETime) {
		return findByProperty(_TRANSETIME, TransETime);
	}
	
	@Override
	public List<Transactions> findByTransAmt(Object TransAmt) {
		return findByProperty(_TRANSAMT, TransAmt);
	}
	
	@Override
	public List<Transactions> findByTransUsdtAmt(Object TransUsdtAmt) {
		return findByProperty(_TRANSUSDTAMT, TransUsdtAmt);
	}
	
	@Override
	public List<Transactions> findByMctId(Object MctId) {
		return findByProperty(_MCTID, MctId);
	}
	
	@Override
	public List<Transactions> findByUwId(Object UwId) {
		return findByProperty(_UWID, UwId);
	}
	
	@Override
	public List<Transactions> findByUwUsdtAct(Object UwUsdtAct) {
		return findByProperty(_UWUSDTACT, UwUsdtAct);
	}
	
	@Override
	public List<Transactions> findByUwBankCard(Object UwBankCard) {
		return findByProperty(_UWBANKCARD, UwBankCard);
	}
	



	@Override
	public List findAll() {
		log.debug("finding all Transactions instances");
		try {
			String queryString = "from Transactions";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get Transactions instances count");
		return findAll().size();
	}

	@Override
	public Transactions merge(Transactions detachedInstance) {
		log.debug("merging Transactions instance");
		try {
			Transactions result = (Transactions) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Transactions instance) {
		log.debug("attaching dirty Transactions instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Transactions instance) {
		log.debug("attaching clean Transactions instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TransactionsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TransactionsDAO) ctx.getBean("TransactionsDAO");
	}
}
