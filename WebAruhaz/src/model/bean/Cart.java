/**
 * 
 */
package model.bean;

/**
 * @author Attila
 *
 */
public class Cart {
	private int id;
	private String userName;
	private int product_id;
	private int piece;
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
	 * @return the user_id
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	 * @return the piece
	 */
	public int getPiece() {
		return piece;
	}
	/**
	 * @param piece the piece to set
	 */
	public void setPiece(int piece) {
		this.piece = piece;
	}
}
