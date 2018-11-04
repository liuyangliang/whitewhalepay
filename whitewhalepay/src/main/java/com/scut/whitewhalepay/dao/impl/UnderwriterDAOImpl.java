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

import com.scut.whitewhalepay.dao.UnderwriterDAO;
import com.scut.whitewhalepay.enity.Underwriter;

@Repository
public class UnderwriterDAOImpl implements UnderwriterDAO{
	private static final Logger log = LoggerFactory.getLogger(UnderwriterDAOImpl.class);
	// property constants
	public static final String _UWNAME = "uwName";
	public static final String _LOGINSECRET = "loginSecret";
	public static final String _UWUSDTACT = "uwUsdtAct";
	public static final String _UWIDENTNO = "uwIdentNo";
	public static final String _UWPHONE = "uwPhone";
	public static final String _UWIDCARDPIC1 = "uwIdCardPic1";
	public static final String _UWIDCARDPIC2 = "uwIdCardPic2";
	public static final String _UWALIPAYNAME = "uwAliPayName";
	public static final String _UWALIPAYQRCODE = "uwAliPayQrCode";
	public static final String _UWALIPAYPIC = "uwAliPaypic";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Underwriter transientInstance) {
		log.debug("saving Underwriter instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Underwriter persistentInstance) {
		log.debug("deleting Underwriter instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Underwriter findById(java.lang.String id) {
		log.debug("getting Underwriter instance with id: " + id);
		try {
			Underwriter instance = (Underwriter) getCurrentSession().get("com.scut.whitewhalpay.enity.Underwriter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Underwriter> findByExample(Underwriter instance) {
		log.debug("finding Underwriter instance by example");
		try {
			List<Underwriter> results = (List<Underwriter>) getCurrentSession()
					.createCriteria("com.scut.whitewhalpay.enity.Underwriter").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Underwriter instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Underwriter as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<Underwriter> findByUwName(Object UwName) {
		return findByProperty(_UWNAME, UwName);
	}
	
	@Override
	public List<Underwriter> findByLoginSecret(Object LoginSecret) {
		return findByProperty(_LOGINSECRET, LoginSecret);
	}
	
	@Override
	public List<Underwriter> findByUwUsdtAct(Object UwUsdtAct) {
		return findByProperty(_UWUSDTACT, UwUsdtAct);
	}
	
	@Override
	public List<Underwriter> findByUwIdentNo(Object UwIdentNo) {
		return findByProperty(_UWIDENTNO, UwIdentNo);
	}
	
	@Override
	public List<Underwriter> findByUwPhone(Object UwPhone) {
		return findByProperty(_UWPHONE, UwPhone);
	}
	
	@Override
	public List<Underwriter> findByUwIdCardPic1(Object UwIdCardPic1) {
		return findByProperty(_UWIDCARDPIC1, UwIdCardPic1);
	}
	
	@Override
	public List<Underwriter> findByUwIdCardPic2(Object UwIdCardPic2) {
		return findByProperty(_UWIDCARDPIC2, UwIdCardPic2);
	}
	
	@Override
	public List<Underwriter> findByUwAliPayName(Object UwAliPayName) {
		return findByProperty(_UWALIPAYNAME, UwAliPayName);
	}
	
	@Override
	public List<Underwriter> findByUwAliPayQrCode(Object UwAliPayQeCode) {
		return findByProperty(_UWALIPAYQRCODE, UwAliPayQeCode);
	}

	@Override
	public List<Underwriter> findByUwAliPayPic(Object UwAliPayPic) {
		return findByProperty(_UWALIPAYPIC, UwAliPayPic);
	}


	@Override
	public List findAll() {
		log.debug("finding all Underwriter instances");
		try {
			String queryString = "from Underwriter";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public int count() {
		log.debug("get Underwriter instances count");
		return findAll().size();
	}

	@Override
	public Underwriter merge(Underwriter detachedInstance) {
		log.debug("merging Underwriter instance");
		try {
			Underwriter result = (Underwriter) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Underwriter instance) {
		log.debug("attaching dirty Underwriter instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Underwriter instance) {
		log.debug("attaching clean Underwriter instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UnderwriterDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UnderwriterDAO) ctx.getBean("UnderwriterDAO");
	}
}
