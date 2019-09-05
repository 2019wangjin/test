package entity;

import java.sql.Timestamp;

/**
 * CstService entity. @author MyEclipse Persistence Tools
 */

public class CstService implements java.io.Serializable {

	// Fields

	private Long svrId;
	private String svrType;
	private String svrTitle;
	private String svrCustNo;
	private String svrStatus;
	private String svrRequest;
	private Long svrCreateId;
	private Timestamp svrCreateDate;
	private Timestamp svrDueDate;
	private String svrDeal;
	private Long svrDealId;
	private Timestamp svrDealDate;
	private String svrResult;
	private Long svrSatisfy;

	// Constructors

	/** default constructor */
	public CstService() {
	}

	/** full constructor */
	public CstService(String svrType, String svrTitle, String svrCustNo,
			String svrStatus, String svrRequest, Long svrCreateId,
			Timestamp svrCreateDate, Timestamp svrDueDate, String svrDeal,
			Long svrDealId, Timestamp svrDealDate, String svrResult,
			Long svrSatisfy) {
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrCustNo = svrCustNo;
		this.svrStatus = svrStatus;
		this.svrRequest = svrRequest;
		this.svrCreateId = svrCreateId;
		this.svrCreateDate = svrCreateDate;
		this.svrDueDate = svrDueDate;
		this.svrDeal = svrDeal;
		this.svrDealId = svrDealId;
		this.svrDealDate = svrDealDate;
		this.svrResult = svrResult;
		this.svrSatisfy = svrSatisfy;
	}

	// Property accessors

	public Long getSvrId() {
		return this.svrId;
	}

	public void setSvrId(Long svrId) {
		this.svrId = svrId;
	}

	public String getSvrType() {
		return this.svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	public String getSvrTitle() {
		return this.svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	public String getSvrCustNo() {
		return this.svrCustNo;
	}

	public void setSvrCustNo(String svrCustNo) {
		this.svrCustNo = svrCustNo;
	}

	public String getSvrStatus() {
		return this.svrStatus;
	}

	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}

	public String getSvrRequest() {
		return this.svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	public Long getSvrCreateId() {
		return this.svrCreateId;
	}

	public void setSvrCreateId(Long svrCreateId) {
		this.svrCreateId = svrCreateId;
	}

	public Timestamp getSvrCreateDate() {
		return this.svrCreateDate;
	}

	public void setSvrCreateDate(Timestamp svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	public Timestamp getSvrDueDate() {
		return this.svrDueDate;
	}

	public void setSvrDueDate(Timestamp svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	public String getSvrDeal() {
		return this.svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	public Long getSvrDealId() {
		return this.svrDealId;
	}

	public void setSvrDealId(Long svrDealId) {
		this.svrDealId = svrDealId;
	}

	public Timestamp getSvrDealDate() {
		return this.svrDealDate;
	}

	public void setSvrDealDate(Timestamp svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	public String getSvrResult() {
		return this.svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	public Long getSvrSatisfy() {
		return this.svrSatisfy;
	}

	public void setSvrSatisfy(Long svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

}