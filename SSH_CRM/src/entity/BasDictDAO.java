package entity;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * BasDict entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.BasDict
 * @author MyEclipse Persistence Tools
 */

public class BasDictDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BasDictDAO.class);
	// property constants
	public static final String DICT_TYPE = "dictType";
	public static final String DICT_ITEM = "dictItem";
	public static final String DICT_VALUE = "dictValue";
	public static final String DICT_IS_EDITABLE = "dictIsEditable";

	protected void initDao() {
		// do nothing
	}

	public void save(BasDict transientInstance) {
		log.debug("saving BasDict instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BasDict persistentInstance) {
		log.debug("deleting BasDict instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BasDict findById(java.lang.Long id) {
		log.debug("getting BasDict instance with id: " + id);
		try {
			BasDict instance = (BasDict) getHibernateTemplate().get(
					"entity.BasDict", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BasDict instance) {
		log.debug("finding BasDict instance by example");
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
		log.debug("finding BasDict instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BasDict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDictType(Object dictType) {
		return findByProperty(DICT_TYPE, dictType);
	}

	public List findByDictItem(Object dictItem) {
		return findByProperty(DICT_ITEM, dictItem);
	}

	public List findByDictValue(Object dictValue) {
		return findByProperty(DICT_VALUE, dictValue);
	}

	public List findByDictIsEditable(Object dictIsEditable) {
		return findByProperty(DICT_IS_EDITABLE, dictIsEditable);
	}

	public List findAll() {
		log.debug("finding all BasDict instances");
		try {
			String queryString = "from BasDict";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BasDict merge(BasDict detachedInstance) {
		log.debug("merging BasDict instance");
		try {
			BasDict result = (BasDict) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BasDict instance) {
		log.debug("attaching dirty BasDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BasDict instance) {
		log.debug("attaching clean BasDict instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BasDictDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BasDictDAO) ctx.getBean("BasDictDAO");
	}
}