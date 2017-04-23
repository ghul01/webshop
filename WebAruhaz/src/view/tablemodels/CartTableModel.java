/**
 * 
 */
package view.tablemodels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import model.bean.Cart;
import view.Labels;

/**
 * @author Attila
 *
 */
public class CartTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnNames = new String[] {
			Labels.id,
			Labels.user_name,
			Labels.product,
			Labels.piece
	};
	
	Map<Integer, Cart> carts = new HashMap<Integer, Cart>();
	
	public CartTableModel(List<Cart> carts) {
		super();
		
		prepareDataStructure(carts);
	}
	private void prepareDataStructure(List<Cart> carts) {
		int row = 0;
		for (Cart cart : carts) {
			this.carts.put(row, cart);
			row++;
		}
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	
	@Override
	public int getRowCount() {
		return carts.entrySet().size();
	}

	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		Cart cart = carts.get(row);
		String askedColumnName = columnNames[col];
		
		if (askedColumnName.equals(Labels.id)){
			return cart.getId();
		} else if (askedColumnName.equals(Labels.user_name)){
			return cart.getUserName();
		} else if (askedColumnName.equals(Labels.product)){
			return cart.getProduct_id();
		} else if (askedColumnName.equals(Labels.piece)){
			return cart.getPiece();
		} 
		
		return Labels.unknown;
	}
	// Nagyon fontos! Eredetileg egy JTable-ben minden String
    // Így viszont, ami boolean, az checkboxkent jelenik meg.
	@Override
	public Class<?> getColumnClass(int c){
		return getValueAt(0 ,c).getClass();
	}
	// Nagyon fontos! Eredetileg egy JTable minden mezõje szerkeszthetõ
    // Jelenleg ezt letiltjuk, a szerkesztéshez a kontrolleren keresztül az
    // adatbázis kommunikációt is implementalni kell!
	@Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

}
