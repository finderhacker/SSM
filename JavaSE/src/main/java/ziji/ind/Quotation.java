package ziji.ind;

import java.math.BigDecimal;

public class Quotation {

	private Long sku;
	private Integer realQuantity;  //真实数量， 有可能为0
	private Integer quantity; //参加计算的数量，当real=0时， 赋值为1
	private BigDecimal price;  //含税仓报价
	private BigDecimal totalPrice;
	/**
	 * @return the sku
	 */
	public Long getSku() {
		return sku;
	}
	/**
	 * @param sku the sku to set
	 */
	public void setSku(Long sku) {
		this.sku = sku;
	}
	/**
	 * @return the realQuantity
	 */
	public Integer getRealQuantity() {
		return realQuantity;
	}
	/**
	 * @param realQuantity the realQuantity to set
	 */
	public void setRealQuantity(Integer realQuantity) {
		this.realQuantity = realQuantity;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Quotation(Long sku, Integer realQuantity, BigDecimal price) {
		super();
		this.sku = sku;
		this.realQuantity = realQuantity;
		this.price = price;
	}

	
	
}
