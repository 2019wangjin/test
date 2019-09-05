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
 * CstCustomer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see entity.CstCustomer
 * @author MyEclipse Persistence Tools
 */

public class CstCustomerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CstCustomerDAO.class);
	// property constants
	public static final String CUST_NAME = "custName";
	public static final String CUST_REGION = "custRegion";
	public static final String CUST_LEVEL = "custLevel";
	public static final String CUST_SATISFY = "custSatisfy";
	public static final String CUST_CREDIT = "custCredit";
	public static final String CUST_ADDR = "custAddr";
	public static final String CUST_ZIP = "custZip";
	public static final String CUST_TEL = "custTel";
	public static final String CUST_FAX = "custFax";
	public static final String CUST_WEBSITE = "custWebsite";
	public static final String CUST_LICENCE_NO = "custLicenceNo";
	public static final String CUST_CHIEFTAIN = "custChieftain";
	public static final String CUST_BANKROLL = "custBankroll";
	public static final String CUST_TURNOVER = "custTurnover";
	public static final String CUST_BANK = "custBank";
	public static final String CUST_BANK_ACCOUNT = "custBankAccount";
	public static final String CUST_LOCAL_TAX_NO = "custLocalTaxNo";
	public static final String CUST_NATIONAL_TAX_NO = "custNationalTaxNo";
	public static final String CUST_STATUS = "custStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(CstCustomer transientInstance) {
		log.debug("saving CstCustomer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CstCustomer persistentInstance) {
		log.debug("deleting CstCustomer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstCustomer findById(java.lang.String id) {
		log.debug("getting CstCustomer instance with id: " + id);
		try {
			CstCustomer instance = (CstCustomer) getHibernateTemplate().get(
					"entity.CstCustomer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CstCustomer instance) {
		log.debug("finding CstCustomer instance by example");
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
		log.debug("finding CstCustomer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstCustomer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustName(Object custName) {
		return findByProperty(CUST_NAME, custName);
	}

	public List findByCustRegion(Object custRegion) {
		return findByProperty(CUST_REGION, custRegion);
	}

	public List findByCustLevel(Object custLevel) {
		return findByProperty(CUST_LEVEL, custLevel);
	}

	public List findByCustSatisfy(Object custSatisfy) {
		return findByProperty(CUST_SATISFY, custSatisfy);
	}

	public List findByCustCredit(Object custCredit) {
		return findByProperty(CUST_CREDIT, custCredit);
	}

	public List findByCustAddr(Object custAddr) {
		return findByProperty(CUST_ADDR, custAddr);
	}

	public List findByCustZip(Object custZip) {
		return findByProperty(CUST_ZIP, custZip);
	}

	public List findByCustTel(Object custTel) {
		return findByProperty(CUST_TEL, custTel);
	}

	public List findByCustFax(Object custFax) {
		return findByProperty(CUST_FAX, custFax);
	}

	public List findByCustWebsite(Object custWebsite) {
		return findByProperty(CUST_WEBSITE, custWebsite);
	}

	public List findByCustLicenceNo(Object custLicenceNo) {
		return findByProperty(CUST_LICENCE_NO, custLicenceNo);
	}

	public List findByCustChieftain(Object custChieftain) {
		return findByProperty(CUST_CHIEFTAIN, custChieftain);
	}

	public List findByCustBankroll(Object custBankroll) {
		return findByProperty(CUST_BANKROLL, custBankroll);
	}

	public List findByCustTurnover(Object custTurnover) {
		return findByProperty(CUST_TURNOVER, custTurnover);
	}

	public List findByCustBank(Object custBank) {
		return findByProperty(CUST_BANK, custBank);
	}

	public List findByCustBankAccount(Object custBankAccount) {
		return findByProperty(CUST_BANK_ACCOUNT, custBankAccount);
	}

	public List findByCustLocalTaxNo(Object custLocalTaxNo) {
		return findByProperty(CUST_LOCAL_TAX_NO, custLocalTaxNo);
	}

	public List findByCustNationalTaxNo(Object custNationalTaxNo) {
		return findByProperty(CUST_NATIONAL_TAX_NO, custNationalTaxNo);
	}

	public List findByCustStatus(Object custStatus) {
		return findByProperty(CUST_STATUS, custStatus);
	}

	public List findAll() {
		log.debug("finding all CstCustomer instances");
		try {
			String queryString = "from CstCustomer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CstCustomer merge(CstCustomer detachedInstance) {
		log.debug("merging CstCustomer instance");
		try {
			CstCustomer result = (CstCustomer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CstCustomer instance) {
		log.debug("attaching dirty CstCustomer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstCustomer instance) {
		log.debug("attaching clean CstCustomer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CstCustomerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CstCustomerDAO) ctx.getBean("CstCustomerDAO");
	}
}