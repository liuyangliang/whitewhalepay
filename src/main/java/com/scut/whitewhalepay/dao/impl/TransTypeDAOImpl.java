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

import com.scut.whitewhalepay.dao.TransTypeDAO;
import com.scut.whitewhalepay.enity.TransType;

public class TransTypeDAOImpl implements TransTypeDAO{
	private static final Logger log = LoggerFactory.getLogger(TransTypeDAOImpl.class);
	// property constants
	public static final String _TRANSTYPE = "transType";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(TransType transientInstance) {
		log.debug("saving TransType instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(TransType persistentInstance) {
		log.debug("deleting TransType instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public TransType findById(java.lang.String id) {
		log.debug("getting TransType instance with id: " + id);
		try {
			TransType instance = (TransType) getCurrentSession().get("com.scut.whitewhalpay.enity.TransType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<TransType> findByExample(TransType instance) {
		log.debug("finding TransType instance by example");
		try {
			List<TransType> results = (List<TransType>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.TransType").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TransType instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TransType as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<TransTypeDAO> findByTransType(Object TransType) {
		return findByProperty(_TRANSTYPE, TransType);
	}


	@Override
	public List findAll() {
		log.debug("finding all TransType instances");
		try {
			String queryString = "from TransType";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get TransType instances count");
		return findAll().size();
	}

	@Override
	public TransType merge(TransType detachedInstance) {
		log.debug("merging TransType instance");
		try {
			TransType result = (TransType) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(TransType instance) {
		log.debug("attaching dirty TransType instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(TransType instance) {
		log.debug("attaching clean TransType instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TransTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TransTypeDAO) ctx.getBean("TransTypeDAO");
	}
}
