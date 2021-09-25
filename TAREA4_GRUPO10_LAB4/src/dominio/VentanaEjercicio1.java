package dominio;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaEjercicio1 extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNacimiento;
	private JLabel lblDatos;
		
	
	public VentanaEjercicio1(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(468,328);
		setLocation(450,350);
		setTitle("Ejercicio 1");
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();			
		txtNombre.addMouseListener(new EventTextFiel(txtNombre));	
		txtNombre.setBounds(191, 57, 153, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(95, 60, 46, 14);
		panel.add(lblNombre);
		
		
		txtApellido = new JTextField();
		txtApellido.addMouseListener(new EventTextFiel(txtApellido));		
		txtApellido.setBounds(191, 88, 153, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(95, 91, 46, 14);
		panel.add(lblApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.addMouseListener(new EventTextFiel(txtTelefono));	
		txtTelefono.setBounds(191, 119, 153, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(95, 122, 46, 14);
		panel.add(lblTelefono);
		
		txtNacimiento = new JTextField();
		txtNacimiento.addMouseListener(new EventTextFiel(txtNacimiento));
		txtNacimiento.setBounds(191, 150, 153, 20);
		panel.add(txtNacimiento);
		txtNacimiento.setColumns(10);
		
		JLabel lblNacimiento = new JLabel("Fecha Nac");
		lblNacimiento.setBounds(95, 153, 66, 14);
		panel.add(lblNacimiento);
		
		JButton btnMostrar = new JButton("Mostrar");
		
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnMostrar.setBounds(255, 207, 89, 23);
		panel.add(btnMostrar);
		
		lblDatos = new JLabel("");
		lblDatos.setBounds(10, 241, 361, 37);
		panel.add(lblDatos);
				
	}
	
	public void validar()
	{
		if(txtNombre.getText().isEmpty())
		{
			txtNombre.setBackground(Color.red);
		}
		else
		{
			txtNombre.setBackground(Color.white);
		}
		
		if(txtApellido.getText().isEmpty())
		{
			txtApellido.setBackground(Color.red);
		}		
		else 
		{
			txtApellido.setBackground(Color.white);
		}
		
		if(txtTelefono.getText().isEmpty())
		{
			txtTelefono.setBackground(Color.red);
		}		
		else 
		{
			txtTelefono.setBackground(Color.white);
		}
		
		if(txtNacimiento.getText().isEmpty())
		{
			txtNacimiento.setBackground(Color.red);
		}
		else
		{
			txtNacimiento.setBackground(Color.white);
		}
		
		if(!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtTelefono.getText().isEmpty() && !txtNacimiento.getText().isEmpty()) 
		{
			lblDatos.setText("Los datos ingresados fueron: " + txtNombre.getText()+" , " + txtApellido.getText()+" , " + txtTelefono.getText() +" , "+ txtNacimiento.getText());
			limpiar();
		}
	}
	
	void limpiar()
	{
		txtNombre.setBackground(Color.white);
		txtNombre.setText("");
		txtApellido.setBackground(Color.white);
		txtApellido.setText("");
		txtTelefono.setBackground(Color.white);
		txtTelefono.setText("");
		txtNacimiento.setBackground(Color.white);
		txtNacimiento.setText("");
	}
	
	
	public void cambiarVisible(Boolean estado) 
	{	
		setVisible(estado);
	}
}
