package com.scut.whitewhalepay.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hibernate.criterion.Example.create;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.scut.whitewhalepay.dao.BankCardDAO;
import com.scut.whitewhalepay.enity.BankCard;

@Repository
public class BankCardDAOImpl implements BankCardDAO {
	private static final Logger log = LoggerFactory.getLogger(BankCardDAOImpl.class);
	// property constants
	public static final String _UWID = "uwId";
	public static final String _BANKINFO = "bankInfo";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(BankCard transientInstance) {
		log.debug("saving BankCard instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(BankCard persistentInstance) {
		log.debug("deleting BankCard instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public BankCard findById(java.lang.String id) {
		log.debug("getting BankCard instance with id: " + id);
		try {
			BankCard instance = (BankCard) getCurrentSession().get("com.scut.whitewhalpay.enity.BankCard", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<BankCard> findByExample(BankCard instance) {
		log.debug("finding BankCard instance by example");
		try {
			List<BankCard> results = (List<BankCard>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.BankCard").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BankCard instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from BankCard as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<BankCard> findByUwId(Object UwId) {
		return findByProperty(_UWID, UwId);
	}

	@Override
	public List<BankCard> findByBankInfo(Object BankInfo) {
		return findByProperty(_BANKINFO, BankInfo);
	}

	@Override
	public List findAll() {
		log.debug("finding all BankCard instances");
		try {
			String queryString = "from BankCard";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get BankCard instances count");
		return findAll().size();
	}

	@Override
	public BankCard merge(BankCard detachedInstance) {
		log.debug("merging BankCard instance");
		try {
			BankCard result = (BankCard) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(BankCard instance) {
		log.debug("attaching dirty BankCard instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(BankCard instance) {
		log.debug("attaching clean BankCard instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BankCardDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BankCardDAO) ctx.getBean("BankCardDAO");
	}
}
