package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * CstCustomer entity. @author MyEclipse Persistence Tools
 */

public class CstCustomer implements java.io.Serializable {

	// Fields

	private String custNo;
	private SysUser sysUser;
	private String custName;
	private Long custRegion;
	private Long custLevel;
	private Long custSatisfy;
	private Long custCredit;
	private String custAddr;
	private String custZip;
	private String custTel;
	private String custFax;
	private String custWebsite;
	private String custLicenceNo;
	private String custChieftain;
	private Long custBankroll;
	private Long custTurnover;
	private String custBank;
	private String custBankAccount;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private Long custStatus;
	private Set cstLosts = new HashSet(0);
	private Set cstActivities = new HashSet(0);
	private Set cstLinkmans = new HashSet(0);
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CstCustomer() {
	}

	/** full constructor */
	public CstCustomer(SysUser sysUser, String custName, Long custRegion,
			Long custLevel, Long custSatisfy, Long custCredit, String custAddr,
			String custZip, String custTel, String custFax, String custWebsite,
			String custLicenceNo, String custChieftain, Long custBankroll,
			Long custTurnover, String custBank, String custBankAccount,
			String custLocalTaxNo, String custNationalTaxNo, Long custStatus,
			Set cstLosts, Set cstActivities, Set cstLinkmans, Set orderses) {
		this.sysUser = sysUser;
		this.custName = custName;
		this.custRegion = custRegion;
		this.custLevel = custLevel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddr = custAddr;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBankroll = custBankroll;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custStatus = custStatus;
		this.cstLosts = cstLosts;
		this.cstActivities = cstActivities;
		this.cstLinkmans = cstLinkmans;
		this.orderses = orderses;
	}

	// Property accessors

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustRegion() {
		return this.custRegion;
	}

	public void setCustRegion(Long custRegion) {
		this.custRegion = custRegion;
	}

	public Long getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(Long custLevel) {
		this.custLevel = custLevel;
	}

	public Long getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(Long custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	public Long getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(Long custCredit) {
		this.custCredit = custCredit;
	}

	public String getCustAddr() {
		return this.custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getCustZip() {
		return this.custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public String getCustLicenceNo() {
		return this.custLicenceNo;
	}

	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}

	public String getCustChieftain() {
		return this.custChieftain;
	}

	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}

	public Long getCustBankroll() {
		return this.custBankroll;
	}

	public void setCustBankroll(Long custBankroll) {
		this.custBankroll = custBankroll;
	}

	public Long getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(Long custTurnover) {
		this.custTurnover = custTurnover;
	}

	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	public String getCustBankAccount() {
		return this.custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	public Long getCustStatus() {
		return this.custStatus;
	}

	public void setCustStatus(Long custStatus) {
		this.custStatus = custStatus;
	}

	public Set getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set cstLosts) {
		this.cstLosts = cstLosts;
	}

	public Set getCstActivities() {
		return this.cstActivities;
	}

	public void setCstActivities(Set cstActivities) {
		this.cstActivities = cstActivities;
	}

	public Set getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}