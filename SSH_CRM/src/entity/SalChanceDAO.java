package entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SalChance entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.SalChance
 * @author MyEclipse Persistence Tools
 */

public class SalChanceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SalChanceDAO.class);
	// property constants
	public static final String CHC_SOURCE = "chcSource";
	public static final String CHC_CUST_NAME = "chcCustName";
	public static final String CHC_TITLE = "chcTitle";
	public static final String CHC_RATE = "chcRate";
	public static final String CHC_LINKMAN = "chcLinkman";
	public static final String CHC_TEL = "chcTel";
	public static final String CHC_DESC = "chcDesc";
	public static final String CHC_STATUS = "chcStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(SalChance transientInstance) {
		log.debug("saving SalChance instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalChance persistentInstance) {
		log.debug("deleting SalChance instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalChance findById(java.lang.Long id) {
		log.debug("getting SalChance instance with id: " + id);
		try {
			SalChance instance = (SalChance) getHibernateTemplate().get(
					"entity.SalChance", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SalChance instance) {
		log.debug("finding SalChance instance by example");
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
		log.debug("finding SalChance instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalChance as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChcSource(Object chcSource) {
		return findByProperty(CHC_SOURCE, chcSource);
	}

	public List findByChcCustName(Object chcCustName) {
		return findByProperty(CHC_CUST_NAME, chcCustName);
	}

	public List findByChcTitle(Object chcTitle) {
		return findByProperty(CHC_TITLE, chcTitle);
	}

	public List findByChcRate(Object chcRate) {
		return findByProperty(CHC_RATE, chcRate);
	}

	public List findByChcLinkman(Object chcLinkman) {
		return findByProperty(CHC_LINKMAN, chcLinkman);
	}

	public List findByChcTel(Object chcTel) {
		return findByProperty(CHC_TEL, chcTel);
	}

	public List findByChcDesc(Object chcDesc) {
		return findByProperty(CHC_DESC, chcDesc);
	}

	public List findByChcStatus(Object chcStatus) {
		return findByProperty(CHC_STATUS, chcStatus);
	}

	public List findAll() {
		log.debug("finding all SalChance instances");
		try {
			String queryString = "from SalChance";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalChance merge(SalChance detachedInstance) {
		log.debug("merging SalChance instance");
		try {
			SalChance result = (SalChance) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalChance instance) {
		log.debug("attaching dirty SalChance instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalChance instance) {
		log.debug("attaching clean SalChance instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalChanceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalChanceDAO) ctx.getBean("SalChanceDAO");
	}
}