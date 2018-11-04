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

import com.scut.whitewhalepay.dao.MarginDAO;
import com.scut.whitewhalepay.enity.Margin;


@Repository
public class MarginDAOImpl implements MarginDAO{
	private static final Logger log = LoggerFactory.getLogger(MarginDAOImpl.class);
	// property constants
	public static String _AMOUNT = "amount";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Margin transientInstance) {
		log.debug("saving Margin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Margin persistentInstance) {
		log.debug("deleting Margin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Margin findById(java.lang.String id) {
		log.debug("getting Margin instance with id: " + id);
		try {
			Margin instance = (Margin) getCurrentSession().get("com.scut.whitewhalpay.enity.Margin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Margin> findByExample(Margin instance) {
		log.debug("finding Margin instance by example");
		try {
			List<Margin> results = (List<Margin>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.Margin").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	

	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Margin instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Margin as model where model." + propertyName + "= ?  " +propertyName;
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	@Override
	public List<MarginDAO> findByAmount(Object Amount) {
		return findByProperty(_AMOUNT, Amount);
	}

	@Override
	public List findAll() {
		log.debug("finding all Margin instances");
		try {
			String queryString = "from Margin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get Margin instances count");
		return findAll().size();
	}

	@Override
	public Margin merge(Margin detachedInstance) {
		log.debug("merging Margin instance");
		try {
			Margin result = (Margin) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Margin instance) {
		log.debug("attaching dirty Margin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Margin instance) {
		log.debug("attaching clean Margin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MarginDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MarginDAO) ctx.getBean("MarginDAO");
	}

	/* (non-Javadoc)
	 * @see com.scut.whitewhalepay.dao.MarginDAO#findByCondition(java.lang.String, int)
	 */
	@Override
	public List<Margin> findByCondition(int usdtAmount) {
		// TODO Auto-generated method stub
		
		log.debug("finding Margin instance with propertyName:usdtAmount, value: " + usdtAmount);
		try {
			String queryString = "from Margin as model where model.usdtAmount >= ?  " +usdtAmount +"order by usdtAmount ASC";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, usdtAmount);   //第一个参数，表示参数传递方法。如果问号换成 ":",则需要把0改为“usdtAmount” 字符串
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}
}
