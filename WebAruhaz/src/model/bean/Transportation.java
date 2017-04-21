/**
 * 
 */
package model.bean;

import java.time.LocalDate;

/**
 * @author Attila
 *
 */
public class Transportation {
	private int id;
	private LocalDate init_date;
	private LocalDate final_date;
	private double shipping_fee;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the init_date
	 */
	public LocalDate getInit_date() {
		return init_date;
	}
	/**
	 * @param init_date the init_date to set
	 */
	public void setInit_date(LocalDate init_date) {
		this.init_date = init_date;
	}
	/**
	 * @return the final_date
	 */
	public LocalDate getFinal_date() {
		return final_date;
	}
	/**
	 * @param final_date the final_date to set
	 */
	public void setFinal_date(LocalDate final_date) {
		this.final_date = final_date;
	}
	/**
	 * @return the shipping fee
	 */
	public double getShippingFee() {
		return shipping_fee;
	}
	/**
	 * @param amount the shipping fee to set
	 */
	public void setShippingFee(double shipping_fee) {
		this.shipping_fee = shipping_fee;
	}
}
