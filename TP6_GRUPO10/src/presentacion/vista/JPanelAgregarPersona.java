package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelAgregarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;	
	
	public JPanelAgregarPersona() {
		this.setLayout(null);	
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(133, 95, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(133, 120, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(133, 149, 46, 14);
		add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(189, 92, 138, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(189, 117, 138, 20);
		add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(189, 146, 138, 20);
		add(txtDni);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(133, 197, 89, 23);
		add(btnAceptar);

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
	public JButton getBtnAceptar() {
		return this.btnAceptar;
	}
	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
