package entity;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.SysUser
 * @author MyEclipse Persistence Tools
 */

public class SysUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SysUserDAO.class);
	// property constants
	public static final String USR_NAME = "usrName";
	public static final String USR_PASSWORD = "usrPassword";
	public static final String USR_FLAG = "usrFlag";

	protected void initDao() {
		// do nothing
	}

	//自定义根据多条件分页查询
	public List<SysUser> findByAll(SysUser user, int first, int last) 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select a from SysUser a inner join fetch a.sysRole ");
		if(user != null){
			if(user.getUsrName()!=null && !user.getUsrName().equals(""))
			{
				sb.append(" where a.usrName like :name ");
			}
			if(user.getUsrFlag() != null && user.getUsrFlag().equals(0))
			{
				sb.append(" and a.usrFlag= :flag ");
			}
		}
		//获取Session
		Session session = getSession();
		Query query = session.createQuery(sb.toString());
		if(user != null){
			if(user.getUsrName()!=null && !user.getUsrName().equals(""))
			{
				query.setString("name", "%"+user.getUsrName()+"%");
			}
			if(user.getUsrFlag() != null && user.getUsrFlag().equals(0))
			{
				query.setLong("flag", user.getUsrFlag());
			}
		}
		
		//设置开始页面
		query.setFirstResult(first);
		query.setMaxResults(last);
		return query.list();
	}
	
	//自定义多条件查询
	public int findCount(SysUser user){
		StringBuffer sb = new StringBuffer();
		sb.append("select a from SysUser a inner join fetch a.sysRole ");
		if(user != null)
		{
			if(user.getUsrName()!=null && !user.getUsrName().equals(""))
			{
				sb.append(" where a.usrName like :name ");
			}
			if(user.getUsrFlag() != null && user.getUsrFlag().equals(0))
			{
				sb.append(" and a.usrFlag= :flag ");
			}
		}
		
		//获取Session
		Session session = getSession();
		Query query = session.createQuery(sb.toString());
		if(user != null){
			if(user.getUsrName()!=null && !user.getUsrName().equals(""))
			{
				query.setString("name", "%"+user.getUsrName()+"%");
			}
			if(user.getUsrFlag() != null && user.getUsrFlag().equals(0))
			{
				query.setLong("flag", user.getUsrFlag());
			}
			
		}
		
		return query.list().size();
	}
	
	
	public void save(SysUser transientInstance) {
		log.debug("saving SysUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysUser persistentInstance) {
		log.debug("deleting SysUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysUser findById(java.lang.Long id) {
		log.debug("getting SysUser instance with id: " + id);
		try {
			SysUser instance = (SysUser) getHibernateTemplate().get(
					"entity.SysUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SysUser instance) {
		log.debug("finding SysUser instance by example");
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
		log.debug("finding SysUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsrName(Object usrName) {
		return findByProperty(USR_NAME, usrName);
	}

	public List findByUsrPassword(Object usrPassword) {
		return findByProperty(USR_PASSWORD, usrPassword);
	}

	public List findByUsrFlag(Object usrFlag) {
		return findByProperty(USR_FLAG, usrFlag);
	}

	public List findAll() {
		log.debug("finding all SysUser instances");
		try {
			String queryString = "from SysUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysUser merge(SysUser detachedInstance) {
		log.debug("merging SysUser instance");
		try {
			SysUser result = (SysUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysUser instance) {
		log.debug("attaching dirty SysUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysUser instance) {
		log.debug("attaching clean SysUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysUserDAO) ctx.getBean("SysUserDAO");
	}
}