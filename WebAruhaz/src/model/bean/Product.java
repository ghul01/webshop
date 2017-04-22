/**
 * 
 */
package model.bean;

/**
 * @author Attila
 *
 */
public class Product {
	private int product_id;
	private String product_name;
	private int unit_price;
	private int stock;
	private String kategory_name;
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the unit_price
	 */
	public int getUnit_price() {
		return unit_price;
	}
	/**
	 * @param unit_price the unit_price to set
	 */
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * @return the kategory_name
	 */
	public String getCategory_name() {
		return kategory_name;
	}
	/**
	 * @param kategory_name the kategory_name to set
	 */
	public void setKategory_name(String kategory_name) {
		this.kategory_name = kategory_name;
	}
}
