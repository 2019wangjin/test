package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleName;
	private String roleDesc;
	private Long roleFlag;
	private Set sysRoleRights = new HashSet(0);
	private Set sysUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** full constructor */
	public SysRole(String roleName, String roleDesc, Long roleFlag,
			Set sysRoleRights, Set sysUsers) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
		this.sysRoleRights = sysRoleRights;
		this.sysUsers = sysUsers;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Long getRoleFlag() {
		return this.roleFlag;
	}

	public void setRoleFlag(Long roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Set getSysRoleRights() {
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}

	public Set getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set sysUsers) {
		this.sysUsers = sysUsers;
	}

}