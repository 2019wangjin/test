package entity;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class Storage implements java.io.Serializable {

	// Fields

	private Long stkId;
	private Product product;
	private String stkWarehouse;
	private String stkWare;
	private Long stkCount;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** full constructor */
	public Storage(Product product, String stkWarehouse, String stkWare,
			Long stkCount) {
		this.product = product;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
	}

	// Property accessors

	public Long getStkId() {
		return this.stkId;
	}

	public void setStkId(Long stkId) {
		this.stkId = stkId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStkWarehouse() {
		return this.stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Long getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(Long stkCount) {
		this.stkCount = stkCount;
	}

}