package entity;

/**
 * BasDict entity. @author MyEclipse Persistence Tools
 */

public class BasDict implements java.io.Serializable {

	// Fields

	private Long dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private Long dictIsEditable;

	// Constructors

	/** default constructor */
	public BasDict() {
	}

	/** full constructor */
	public BasDict(String dictType, String dictItem, String dictValue,
			Long dictIsEditable) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
	}

	// Property accessors

	public Long getDictId() {
		return this.dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public Long getDictIsEditable() {
		return this.dictIsEditable;
	}

	public void setDictIsEditable(Long dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

}