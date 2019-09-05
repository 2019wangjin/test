package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SalChance entity. @author MyEclipse Persistence Tools
 */

public class SalChance implements java.io.Serializable {

	// Fields

	private Long chcId;
	private SysUser sysUserByChcDueId;
	private SysUser sysUserByChcCreateId;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private Long chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcDesc;
	private Timestamp chcCreateDate;
	private Timestamp chcDueDate;
	private Long chcStatus;
	private Set salPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public SalChance() {
	}

	/** full constructor */
	public SalChance(SysUser sysUserByChcDueId, SysUser sysUserByChcCreateId,
			String chcSource, String chcCustName, String chcTitle,
			Long chcRate, String chcLinkman, String chcTel, String chcDesc,
			Timestamp chcCreateDate, Timestamp chcDueDate, Long chcStatus,
			Set salPlans) {
		this.sysUserByChcDueId = sysUserByChcDueId;
		this.sysUserByChcCreateId = sysUserByChcCreateId;
		this.chcSource = chcSource;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcDesc = chcDesc;
		this.chcCreateDate = chcCreateDate;
		this.chcDueDate = chcDueDate;
		this.chcStatus = chcStatus;
		this.salPlans = salPlans;
	}

	// Property accessors

	public Long getChcId() {
		return this.chcId;
	}

	public void setChcId(Long chcId) {
		this.chcId = chcId;
	}

	public SysUser getSysUserByChcDueId() {
		return this.sysUserByChcDueId;
	}

	public void setSysUserByChcDueId(SysUser sysUserByChcDueId) {
		this.sysUserByChcDueId = sysUserByChcDueId;
	}

	public SysUser getSysUserByChcCreateId() {
		return this.sysUserByChcCreateId;
	}

	public void setSysUserByChcCreateId(SysUser sysUserByChcCreateId) {
		this.sysUserByChcCreateId = sysUserByChcCreateId;
	}

	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return this.chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public Long getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(Long chcRate) {
		this.chcRate = chcRate;
	}

	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	public Timestamp getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Timestamp chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	public Timestamp getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Timestamp chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	public Long getChcStatus() {
		return this.chcStatus;
	}

	public void setChcStatus(Long chcStatus) {
		this.chcStatus = chcStatus;
	}

	public Set getSalPlans() {
		return this.salPlans;
	}

	public void setSalPlans(Set salPlans) {
		this.salPlans = salPlans;
	}

}