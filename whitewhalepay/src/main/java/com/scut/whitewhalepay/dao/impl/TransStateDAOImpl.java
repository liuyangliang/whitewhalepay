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

import com.scut.whitewhalepay.dao.TransStateDAO;
import com.scut.whitewhalepay.enity.TransState;

public class TransStateDAOImpl implements TransStateDAO{
	private static final Logger log = LoggerFactory.getLogger(TransStateDAOImpl.class);
	// property constants
	public static final String _TRANSSTATE = "transState";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(TransState transientInstance) {
		log.debug("saving TransState instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(TransState persistentInstance) {
		log.debug("deleting TransState instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public TransState findById(java.lang.String id) {
		log.debug("getting TransState instance with id: " + id);
		try {
			TransState instance = (TransState) getCurrentSession().get("com.scut.whitewhalpay.enity.TransState", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<TransState> findByExample(TransState instance) {
		log.debug("finding TransState instance by example");
		try {
			List<TransState> results = (List<TransState>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.TransState").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TransState instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TransState as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	@Override
	public List<TransState> findByTransState(Object TransState) {
		return findByProperty(_TRANSSTATE, TransState);
	}

	@Override
	public List findAll() {
		log.debug("finding all TransState instances");
		try {
			String queryString = "from TransState";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get TransState instances count");
		return findAll().size();
	}

	@Override
	public TransState merge(TransState detachedInstance) {
		log.debug("merging TransState instance");
		try {
			TransState result = (TransState) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(TransState instance) {
		log.debug("attaching dirty TransState instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(TransState instance) {
		log.debug("attaching clean TransState instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TransStateDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TransStateDAO) ctx.getBean("TransStateDAO");
	}
}
