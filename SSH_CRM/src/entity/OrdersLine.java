package entity;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */

public class OrdersLine implements java.io.Serializable {

	// Fields

	private Long oddId;
	private Orders orders;
	private Product product;
	private Long oddCount;
	private String oddUnit;
	private Double oddPrice;

	// Constructors

	/** default constructor */
	public OrdersLine() {
	}

	/** full constructor */
	public OrdersLine(Orders orders, Product product, Long oddCount,
			String oddUnit, Double oddPrice) {
		this.orders = orders;
		this.product = product;
		this.oddCount = oddCount;
		this.oddUnit = oddUnit;
		this.oddPrice = oddPrice;
	}

	// Property accessors

	public Long getOddId() {
		return this.oddId;
	}

	public void setOddId(Long oddId) {
		this.oddId = oddId;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getOddCount() {
		return this.oddCount;
	}

	public void setOddCount(Long oddCount) {
		this.oddCount = oddCount;
	}

	public String getOddUnit() {
		return this.oddUnit;
	}

	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}

	public Double getOddPrice() {
		return this.oddPrice;
	}

	public void setOddPrice(Double oddPrice) {
		this.oddPrice = oddPrice;
	}

}