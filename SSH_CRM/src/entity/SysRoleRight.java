package entity;

/**
 * SysRoleRight entity. @author MyEclipse Persistence Tools
 */

public class SysRoleRight implements java.io.Serializable {

	// Fields

	private Long rfId;
	private SysRight sysRight;
	private SysRole sysRole;

	// Constructors

	/** default constructor */
	public SysRoleRight() {
	}

	/** full constructor */
	public SysRoleRight(SysRight sysRight, SysRole sysRole) {
		this.sysRight = sysRight;
		this.sysRole = sysRole;
	}

	// Property accessors

	public Long getRfId() {
		return this.rfId;
	}

	public void setRfId(Long rfId) {
		this.rfId = rfId;
	}

	public SysRight getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

}