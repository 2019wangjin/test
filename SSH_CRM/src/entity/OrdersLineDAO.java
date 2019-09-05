package entity;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrdersLine entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.OrdersLine
 * @author MyEclipse Persistence Tools
 */

public class OrdersLineDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrdersLineDAO.class);
	// property constants
	public static final String ODD_COUNT = "oddCount";
	public static final String ODD_UNIT = "oddUnit";
	public static final String ODD_PRICE = "oddPrice";

	protected void initDao() {
		// do nothing
	}

	public void save(OrdersLine transientInstance) {
		log.debug("saving OrdersLine instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrdersLine persistentInstance) {
		log.debug("deleting OrdersLine instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrdersLine findById(java.lang.Long id) {
		log.debug("getting OrdersLine instance with id: " + id);
		try {
			OrdersLine instance = (OrdersLine) getHibernateTemplate().get(
					"entity.OrdersLine", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrdersLine instance) {
		log.debug("finding OrdersLine instance by example");
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
		log.debug("finding OrdersLine instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrdersLine as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOddCount(Object oddCount) {
		return findByProperty(ODD_COUNT, oddCount);
	}

	public List findByOddUnit(Object oddUnit) {
		return findByProperty(ODD_UNIT, oddUnit);
	}

	public List findByOddPrice(Object oddPrice) {
		return findByProperty(ODD_PRICE, oddPrice);
	}

	public List findAll() {
		log.debug("finding all OrdersLine instances");
		try {
			String queryString = "from OrdersLine";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrdersLine merge(OrdersLine detachedInstance) {
		log.debug("merging OrdersLine instance");
		try {
			OrdersLine result = (OrdersLine) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrdersLine instance) {
		log.debug("attaching dirty OrdersLine instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrdersLine instance) {
		log.debug("attaching clean OrdersLine instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrdersLineDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrdersLineDAO) ctx.getBean("OrdersLineDAO");
	}
}