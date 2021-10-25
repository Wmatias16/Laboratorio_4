package presentacion.vista;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import java.awt.Rectangle;

public class JpanelListarPersona extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel DefaultTableModel;
	
	
	
	/**
	 * Create the panel.
	 */
	public JpanelListarPersona() {
		
		
		table = new JTable();
		table.setBounds(new Rectangle(0, 10, 0, 0));
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Dni", "Nombre", "Apellido"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(10, 264, 417, -234);
		add(table);
		
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	
	public DefaultTableModel getDefaultTableModel() {
		return DefaultTableModel;
	}


	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		DefaultTableModel = defaultTableModel;
		table.setModel(defaultTableModel);
	}

	
}
