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


import com.scut.whitewhalepay.dao.UsdtTransTypeDAO;
import com.scut.whitewhalepay.enity.UsdtTransType;


public class UsdtTransTypeDAOImpl implements UsdtTransTypeDAO{
	private static final Logger log = LoggerFactory.getLogger(UsdtTransTypeDAOImpl.class);
	// property constants
	public static final String _USDTTRANSTYPE = "usdtTransType";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(UsdtTransType transientInstance) {
		log.debug("saving UsdtTransType instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(UsdtTransType persistentInstance) {
		log.debug("deleting UsdtTransType instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public UsdtTransType findById(java.lang.String id) {
		log.debug("getting UsdtTransType instance with id: " + id);
		try {
			UsdtTransType instance = (UsdtTransType) getCurrentSession().get("com.scut.whitewhalpay.enity.UsdtTransType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<UsdtTransType> findByExample(UsdtTransType instance) {
		log.debug("finding UsdtTransType instance by example");
		try {
			List<UsdtTransType> results = (List<UsdtTransType>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.UsdtTransType").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UsdtTransType instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from UsdtTransType as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<UsdtTransType> findByUsdtTransType(Object UsdtTransType) {
		return findByProperty(_USDTTRANSTYPE, UsdtTransType);
	}

	@Override
	public List findAll() {
		log.debug("finding all UsdtTransType instances");
		try {
			String queryString = "from UsdtTransType";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get UsdtTransType instances count");
		return findAll().size();
	}

	@Override
	public UsdtTransType merge(UsdtTransType detachedInstance) {
		log.debug("merging UsdtTransType instance");
		try {
			UsdtTransType result = (UsdtTransType) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(UsdtTransType instance) {
		log.debug("attaching dirty UsdtTransType instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(UsdtTransType instance) {
		log.debug("attaching clean UsdtTransType instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsdtTransTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsdtTransTypeDAO) ctx.getBean("UsdtTransTypeDAO");
	}
}
