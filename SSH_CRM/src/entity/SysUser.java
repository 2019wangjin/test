package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Long usrId;
	private SysRole sysRole;
	private String usrName;
	private String usrPassword;
	private Long usrFlag;
	private Set salChancesForChcCreateId = new HashSet(0);
	private Set cstLosts = new HashSet(0);
	private Set cstCustomers = new HashSet(0);
	private Set salChancesForChcDueId = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(SysRole sysRole, String usrName, String usrPassword,
			Long usrFlag, Set salChancesForChcCreateId, Set cstLosts,
			Set cstCustomers, Set salChancesForChcDueId) {
		this.sysRole = sysRole;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
		this.salChancesForChcCreateId = salChancesForChcCreateId;
		this.cstLosts = cstLosts;
		this.cstCustomers = cstCustomers;
		this.salChancesForChcDueId = salChancesForChcDueId;
	}

	// Property accessors

	public Long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		sysRole.setRoleId(Long.parseLong("1"));	//设置默认的角色
		this.sysRole = sysRole;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Long getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(Long usrFlag) {
		this.usrFlag = usrFlag;
	}

	public Set getSalChancesForChcCreateId() {
		return this.salChancesForChcCreateId;
	}

	public void setSalChancesForChcCreateId(Set salChancesForChcCreateId) {
		this.salChancesForChcCreateId = salChancesForChcCreateId;
	}

	public Set getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set cstLosts) {
		this.cstLosts = cstLosts;
	}

	public Set getCstCustomers() {
		return this.cstCustomers;
	}

	public void setCstCustomers(Set cstCustomers) {
		this.cstCustomers = cstCustomers;
	}

	public Set getSalChancesForChcDueId() {
		return this.salChancesForChcDueId;
	}

	public void setSalChancesForChcDueId(Set salChancesForChcDueId) {
		this.salChancesForChcDueId = salChancesForChcDueId;
	}

}