package entity;

import java.sql.Timestamp;

/**
 * CstActivity entity. @author MyEclipse Persistence Tools
 */

public class CstActivity implements java.io.Serializable {

	// Fields

	private Long atvId;
	private CstCustomer cstCustomer;
	private Timestamp atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private String atvMemo;

	// Constructors

	/** default constructor */
	public CstActivity() {
	}

	/** full constructor */
	public CstActivity(CstCustomer cstCustomer, Timestamp atvDate,
			String atvPlace, String atvTitle, String atvDesc, String atvMemo) {
		this.cstCustomer = cstCustomer;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
		this.atvMemo = atvMemo;
	}

	// Property accessors

	public Long getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Long atvId) {
		this.atvId = atvId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public Timestamp getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Timestamp atvDate) {
		this.atvDate = atvDate;
	}

	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

	public String getAtvMemo() {
		return this.atvMemo;
	}

	public void setAtvMemo(String atvMemo) {
		this.atvMemo = atvMemo;
	}

}