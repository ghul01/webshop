/**
 * 
 */
package view.tablemodels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import model.bean.Product;
import view.Labels;

/**
 * @author Attila
 *
 */
public class ProductTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 6300331383535466024L;

	private String[] columnNames = new String[] {
			Labels.product_id,
			Labels.product_name,
			Labels.product_unit_price,
			Labels.product_stock,
			Labels.product_category
	};
	
	Map<Integer, Product> products = new HashMap<Integer, Product>();
	
	public ProductTableModel(List<Product> products) {
		super();
		
		prepareDataStructure(products);
	}

	private void prepareDataStructure(List<Product> products) {
		int row = 0;
		for (Product product : products) {
			this.products.put(row, product);
			row++;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return products.entrySet().size();
	}

	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Product product = products.get(row);
		String askedColumnName = columnNames[col];
		
		if (askedColumnName.equals(Labels.product_id)){
			return product.getProduct_id();
		} else if (askedColumnName.equals(Labels.product_name)){
			return product.getProduct_name();
		} else if (askedColumnName.equals(Labels.product_unit_price)){
			return product.getUnit_price();
		} else if (askedColumnName.equals(Labels.product_stock)){
			return product.getStock();
		} else if (askedColumnName.equals(Labels.product_category)){
			return product.getCategory_name();
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
