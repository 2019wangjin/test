package entity;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.SysRole
 * @author MyEclipse Persistence Tools
 */

public class SysRoleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SysRoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_DESC = "roleDesc";
	public static final String ROLE_FLAG = "roleFlag";

	protected void initDao() {
		// do nothing
	}

	public void save(SysRole transientInstance) {
		log.debug("saving SysRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysRole persistentInstance) {
		log.debug("deleting SysRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysRole findById(java.lang.Long id) {
		log.debug("getting SysRole instance with id: " + id);
		try {
			SysRole instance = (SysRole) getHibernateTemplate().get(
					"entity.SysRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SysRole instance) {
		log.debug("finding SysRole instance by example");
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
		log.debug("finding SysRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByRoleDesc(Object roleDesc) {
		return findByProperty(ROLE_DESC, roleDesc);
	}

	public List findByRoleFlag(Object roleFlag) {
		return findByProperty(ROLE_FLAG, roleFlag);
	}

	public List findAll() {
		log.debug("finding all SysRole instances");
		try {
			String queryString = "from SysRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysRole merge(SysRole detachedInstance) {
		log.debug("merging SysRole instance");
		try {
			SysRole result = (SysRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysRole instance) {
		log.debug("attaching dirty SysRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysRole instance) {
		log.debug("attaching clean SysRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysRoleDAO) ctx.getBean("SysRoleDAO");
	}
}