package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class JPanelEliminarPersona extends JPanel {


	private static final long serialVersionUID = 1L;
	private JButton btnEliminar;
	private JList<Persona> JListPersonas;
	private DefaultListModel<Persona> defaultListModelPersonas;

	public JPanelEliminarPersona() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar usuarios");
		lblNewLabel.setBounds(161, 27, 128, 20);
		add(lblNewLabel);
		
		JListPersonas = new JList<Persona>();
		JListPersonas.setBounds(111, 48, 216, 215);
		add(JListPersonas);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(161, 271, 115, 29);
		add(btnEliminar);

	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JList<Persona> getJListPersonas() {
		return JListPersonas;
	}

	public DefaultListModel<Persona> getDefaultListModelPersonas() {
		return defaultListModelPersonas;
	}

	public void setDefaultListModelPersonas(DefaultListModel<Persona> defaultListModelPersonas) {
		this.defaultListModelPersonas = defaultListModelPersonas;
		JListPersonas.setModel(this.defaultListModelPersonas);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
