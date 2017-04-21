/**
 * 
 */
package model.bean;

/**
 * @author Attila
 *
 */
public class Discount {
	private int id;
	private int lower_limit;
	private double rate;
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
	 * @return the lower_limit
	 */
	public int getLower_limit() {
		return lower_limit;
	}
	/**
	 * @param lower_limit the lower_limit to set
	 */
	public void setLower_limit(int lower_limit) {
		this.lower_limit = lower_limit;
	}
	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
}
