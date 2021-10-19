package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class JPanelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private JList<Persona> JListPersonas;
	private DefaultListModel<Persona> defaultListModelPersonas;

	public JPanelModificarPersona() {
		setLayout(null);
		
		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccioneLaPersona.setBounds(91, 16, 344, 20);
		add(lblSeleccioneLaPersona);
		
		JListPersonas = new JList<Persona>();
		JListPersonas.setBounds(15, 41, 452, 163);
		add(JListPersonas);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(15, 230, 125, 26);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(176, 230, 125, 26);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(336, 230, 125, 26);
		txtDni.setEditable(false);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(336, 271, 115, 29);
		add(btnModificar);

	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
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
