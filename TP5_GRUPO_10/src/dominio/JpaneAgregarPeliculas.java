package dominio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;



import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JpaneAgregarPeliculas extends JPanel {
	
	private JTextField TxtNombre;
	private DefaultListModel<Peliculas> listModel;
	private Categorias categoria = new Categorias();
	private Peliculas peliculas ;
	/**
	 * Create the panel.
	 */
	public JpaneAgregarPeliculas() {
		setLayout(null);
		
		peliculas =  new Peliculas();
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, 40, 45, 13);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = 	new JLabel(Integer. toString(peliculas.getcontId()));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(251, 40, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(88, 86, 71, 13);
		add(lblNewLabel_2);
		
		TxtNombre = new JTextField();
		TxtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtNombre.setBounds(251, 83, 151, 19);
		add(TxtNombre);
		TxtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Genero");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(88, 136, 71, 13);
		add(lblNewLabel_3);
		
		JComboBox<String> comboBoxGenero = new JComboBox<String>();
		comboBoxGenero.setBounds(251, 134, 151, 21);
		add(comboBoxGenero);
		comboBoxGenero.addItem("Seleccione un Genero");
		comboBoxGenero.addItem("Terror");
		comboBoxGenero.addItem("Accion");
		comboBoxGenero.addItem("Suspenso");
		comboBoxGenero.addItem("Romantica");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Registrar list model
				
				
				
				
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBounds(173, 173, 85, 21);
		add(btnAceptar);
		
	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
	
	
}
