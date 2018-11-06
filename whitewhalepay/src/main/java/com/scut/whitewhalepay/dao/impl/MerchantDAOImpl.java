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

import com.scut.whitewhalepay.dao.MerchantDAO;
import com.scut.whitewhalepay.enity.Merchant;

@Repository
public class MerchantDAOImpl implements MerchantDAO{
	private static final Logger log = LoggerFactory.getLogger(MerchantDAOImpl.class);
	// property constants
	public static String _MCTNAME = "mctName";
	public static String _LOGINSECRET = "loginSecret";
	public static String _MCTUSDTACT = "mctUsdtAct";
	public static String _MCTPHONE = "mctPhone";
	public static String _MCTIDENTNO = "mctIdentNo";
	public static String _MCTIDCARDPIC1 = "mctIdCardPic1";
	public static String _MCTIDCARDPIC2 = "mctIdCardPic2";
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Merchant transientInstance) {
		log.debug("saving Merchant instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Merchant persistentInstance) {
		log.debug("deleting Merchant instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Merchant findById(java.lang.String id) {
		log.debug("getting Merchant instance with id: " + id);
		try {
			Merchant instance = (Merchant) getCurrentSession().get("com.scut.whitewhalpay.enity.Merchant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Merchant> findByExample(Merchant instance) {
		log.debug("finding Merchant instance by example");
		try {
			List<Merchant> results = (List<Merchant>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.Merchant").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Merchant instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Merchant as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<Merchant> findByMctName(Object MctName) {
		return findByProperty(_MCTNAME, MctName);
	}

	@Override
	public List<Merchant> findByLoginSecret(Object LoginSecret) {
		return findByProperty(_LOGINSECRET, LoginSecret);
	}
	
	@Override
	public List<Merchant> findByMctUsdtAct(Object MctUsdtAct) {
		return findByProperty(_MCTUSDTACT, MctUsdtAct);
	}
	
	@Override
	public List<Merchant> findByMctPhone(Object MctPhone) {
		return findByProperty(_MCTPHONE, MctPhone);
	}
	
	@Override
	public List<Merchant> findByMctIdentNo(Object MctIdentNo) {
		return findByProperty(_MCTIDENTNO, MctIdentNo);
	}
	
	@Override
	public List<Merchant> findByMctIdCardPic1(Object MctIdCardPic1) {
		return findByProperty(_MCTIDCARDPIC1, MctIdCardPic1);
	}
	
	@Override
	public List<Merchant> findByMctIdCardPic2(Object MctIdCardPic2) {
		return findByProperty(_MCTIDCARDPIC2, MctIdCardPic2);
	}

	@Override
	public List findAll() {
		log.debug("finding all Merchant instances");
		try {
			String queryString = "from Merchant";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get Merchant instances count");
		return findAll().size();
	}

	@Override
	public Merchant merge(Merchant detachedInstance) {
		log.debug("merging Merchant instance");
		try {
			Merchant result = (Merchant) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Merchant instance) {
		log.debug("attaching dirty Merchant instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Merchant instance) {
		log.debug("attaching clean Merchant instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MerchantDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MerchantDAO) ctx.getBean("MerchantDAO");
	}
}
