package presentacion.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;

public class JPanelListarPersona extends JPanel {
	private JTable tblPersona;

	/**
	 * Create the panel.
	 */
	public JPanelListarPersona() {
		setLayout(new BorderLayout(0, 0));
		
		tblPersona = new JTable();
		add(tblPersona, BorderLayout.CENTER);

	}

}
