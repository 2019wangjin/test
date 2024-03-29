package entity;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstService entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.CstService
 * @author MyEclipse Persistence Tools
 */

public class CstServiceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CstServiceDAO.class);
	// property constants
	public static final String SVR_TYPE = "svrType";
	public static final String SVR_TITLE = "svrTitle";
	public static final String SVR_CUST_NO = "svrCustNo";
	public static final String SVR_STATUS = "svrStatus";
	public static final String SVR_REQUEST = "svrRequest";
	public static final String SVR_CREATE_ID = "svrCreateId";
	public static final String SVR_DEAL = "svrDeal";
	public static final String SVR_DEAL_ID = "svrDealId";
	public static final String SVR_RESULT = "svrResult";
	public static final String SVR_SATISFY = "svrSatisfy";

	protected void initDao() {
		// do nothing
	}

	public void save(CstService transientInstance) {
		log.debug("saving CstService instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CstService persistentInstance) {
		log.debug("deleting CstService instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstService findById(java.lang.Long id) {
		log.debug("getting CstService instance with id: " + id);
		try {
			CstService instance = (CstService) getHibernateTemplate().get(
					"entity.CstService", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CstService instance) {
		log.debug("finding CstService instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstService instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstService as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySvrType(Object svrType) {
		return findByProperty(SVR_TYPE, svrType);
	}

	public List findBySvrTitle(Object svrTitle) {
		return findByProperty(SVR_TITLE, svrTitle);
	}

	public List findBySvrCustNo(Object svrCustNo) {
		return findByProperty(SVR_CUST_NO, svrCustNo);
	}

	public List findBySvrStatus(Object svrStatus) {
		return findByProperty(SVR_STATUS, svrStatus);
	}

	public List findBySvrRequest(Object svrRequest) {
		return findByProperty(SVR_REQUEST, svrRequest);
	}

	public List findBySvrCreateId(Object svrCreateId) {
		return findByProperty(SVR_CREATE_ID, svrCreateId);
	}

	public List findBySvrDeal(Object svrDeal) {
		return findByProperty(SVR_DEAL, svrDeal);
	}

	public List findBySvrDealId(Object svrDealId) {
		return findByProperty(SVR_DEAL_ID, svrDealId);
	}

	public List findBySvrResult(Object svrResult) {
		return findByProperty(SVR_RESULT, svrResult);
	}

	public List findBySvrSatisfy(Object svrSatisfy) {
		return findByProperty(SVR_SATISFY, svrSatisfy);
	}

	public List findAll() {
		log.debug("finding all CstService instances");
		try {
			String queryString = "from CstService";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CstService merge(CstService detachedInstance) {
		log.debug("merging CstService instance");
		try {
			CstService result = (CstService) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CstService instance) {
		log.debug("attaching dirty CstService instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstService instance) {
		log.debug("attaching clean CstService instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CstServiceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CstServiceDAO) ctx.getBean("CstServiceDAO");
	}
}