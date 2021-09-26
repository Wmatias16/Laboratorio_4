package dominio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaEjercicio2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JTextField TxtNota1;
	private JTextField TxtNota2;
	private JTextField TxtNota3;
	private JTextField TxtPromedio;
	private JTextField TxtCondicion;


	/**
	 * Create the frame.
	 */
	public VentanaEjercicio2() {
		setBounds(100, 100, 561, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(23, 39, 269, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Nota 1 : ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(39, 36, 45, 13);
		panel.add(lblNewLabel_2);
		
		TxtNota1 = new JTextField();
		TxtNota1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//declaramos la variable y le asignamos el evento 
				char caracter = e.getKeyChar();
				//Condicion
				if((caracter<'0' || caracter >'9') && TxtNota1.getText().contains(".") && (caracter!=(char)KeyEvent.VK_BACK_SPACE))
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"solo se adimten numeros");
				}
				else if ((caracter<'0' || caracter >'9') && (caracter!='.') && (caracter!=(char)KeyEvent.VK_BACK_SPACE)) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"solo se adimten numeros");
				}
		
			}
		});
		TxtNota1.setBounds(94, 33, 96, 19);
		panel.add(TxtNota1);
		TxtNota1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nota 2 :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(39, 71, 45, 13);
		panel.add(lblNewLabel_3);
		
		TxtNota2 = new JTextField();
		TxtNota2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//declaramos la variable y le asignamos el evento 
				char caracter = e.getKeyChar();
				//Condicion
				if((caracter<'0' || caracter >'9') && TxtNota2.getText().contains(".") && (caracter!=(char)KeyEvent.VK_BACK_SPACE))
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"solo se adimten numeros");
				}
				else if ((caracter<'0' || caracter >'9') && (caracter!='.') && (caracter!=(char)KeyEvent.VK_BACK_SPACE)) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"solo se adimten numeros");
				}
		
			}
		});
		TxtNota2.setBounds(94, 68, 96, 19);
		panel.add(TxtNota2);
		TxtNota2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nota 3 :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(39, 105, 45, 13);
		panel.add(lblNewLabel_4);
		
		TxtNota3 = new JTextField();
		TxtNota3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//declaramos la variable y le asignamos el evento 
				char caracter = e.getKeyChar();
				//Condicion
				if((caracter<'0' || caracter >'9') && TxtNota3.getText().contains(".") && (caracter!=(char)KeyEvent.VK_BACK_SPACE))
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"solo se adimten numeros");
				}
				else if ((caracter<'0' || caracter >'9') && (caracter!='.') && (caracter!=(char)KeyEvent.VK_BACK_SPACE)) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"solo se adimten numeros");
				}
		
			}
		});
		TxtNota3.setBounds(94, 102, 96, 19);
		panel.add(TxtNota3);
		TxtNota3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tps : ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(39, 140, 45, 13);
		panel.add(lblNewLabel_5);
		
		JComboBox<String> ComboBoxTps = new JComboBox<String>();
		ComboBoxTps.setFont(new Font("Arial", Font.PLAIN, 12));
		ComboBoxTps.setBounds(94, 136, 96, 21);
		ComboBoxTps.addItem("Aprobado");
		ComboBoxTps.addItem("Desaprobado");
		panel.add(ComboBoxTps);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(23, 240, 269, 139);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Promedio : ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(28, 29, 64, 20);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Condicion : ");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(28, 76, 64, 20);
		panel_1.add(lblNewLabel_7);
		
		TxtPromedio = new JTextField();
		TxtPromedio.setEditable(false);
		TxtPromedio.setBounds(102, 30, 96, 19);
		panel_1.add(TxtPromedio);
		TxtPromedio.setColumns(10);
		
		TxtCondicion = new JTextField();
		TxtCondicion.setEditable(false);
		TxtCondicion.setBounds(102, 77, 96, 19);
		panel_1.add(TxtCondicion);
		TxtCondicion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Notas del Estudiante");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 21, 145, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Notas del Estudiante ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 215, 145, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton BtnCalcular = new JButton("Calcular");
		BtnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
					
		
					//Verificamos que tengas las 3 notas cargadas
					if((TxtNota1.getText().length()!=0 ) && (TxtNota2.getText().length()!=0) && (TxtNota3.getText().length()!=0)) {
						
						
						double nota1 = Double.parseDouble(TxtNota1.getText());
						double nota2 = Double.parseDouble(TxtNota2.getText());
						double nota3 = Double.parseDouble(TxtNota3.getText());
						
						
						if((nota1>=1 && nota1<=10) && (nota2>=1 && nota2<=10) && (nota3>=1 && nota3<=10) )
						{
							
							double Promedio = (nota1+nota2+nota3) / 3;
							TxtPromedio.setText(""+ Promedio);
							
						if(ComboBoxTps.getSelectedItem() == "Desaprobado") 
						{
							TxtCondicion.setText("Libre");
						}					
						else {
							
								if( nota1<6 || nota2<6 || nota3<6 ) {
									TxtCondicion.setText("Libre");
								}
								else if ( Promedio>=6 && Promedio<=8 ) {
									TxtCondicion.setText("Regular");
								}
								else {
									TxtCondicion.setText("Promocionado");
								}
							
							}
						
						
						}
						else
						{
							JOptionPane.showMessageDialog(null,"las notas deben ser de 1 a 10 ");
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Debe Ingresar las notas");
					}
				}
				
				
			});
		BtnCalcular.setBounds(373, 51, 98, 33);
		contentPane.add(BtnCalcular);
		
		
		//Limpiamos la ventana 
		JButton BtnNuevo = new JButton("Nuevo");
		BtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxtNota1.setBackground(Color.white);
				TxtNota1.setText("");
				TxtNota2.setBackground(Color.white);
				TxtNota2.setText("");
				TxtNota3.setBackground(Color.white);
				TxtNota3.setText("");
				TxtPromedio.setBackground(Color.white);
				TxtPromedio.setText("");
				TxtCondicion.setBackground(Color.white);
				TxtCondicion.setText("");
			}
		});
		BtnNuevo.setBounds(373, 106, 98, 33);
		contentPane.add(BtnNuevo);
		
		JButton BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		BtnSalir.setBounds(373, 162, 98, 33);
		contentPane.add(BtnSalir);
		
		
		
	}
	
	
	
	
	
	
	public void cambiarVisible(Boolean estado) 
	{	
		setVisible(estado);
	}
	
}
