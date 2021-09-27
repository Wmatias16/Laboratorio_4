package dominio;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Ventana()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(350,350);
		setTitle("TP4");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(107, 105, 240, 198);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEjercicio = new JButton("Ejercicio 1");
		btnEjercicio.setBounds(68, 59, 115, 29);
		panel.add(btnEjercicio);
		
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.setBounds(68, 95, 115, 29);
		panel.add(btnEjercicio2);
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.setBounds(68, 130, 115, 29);
		panel.add(btnEjercicio3);
		
		JLabel lblGrupo = new JLabel("GRUPO NRO: 10");
		lblGrupo.setBounds(15, 16, 145, 20);
		panel.add(lblGrupo);
		
		
		
		btnEjercicio.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio1 principal = new VentanaEjercicio1();
				principal.cambiarVisible(true);				
			}
		});
		
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio2 Secundaria = new VentanaEjercicio2();
				Secundaria.cambiarVisible(true);
			}
		});
		
		btnEjercicio3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio3 nuevaVentana = new VentanaEjercicio3();
				nuevaVentana.cambiarVisible(true);				
			}
		});		
		
		
		
	}
	
	public void cambiarVisible(Boolean estado)
	{
		setVisible(estado);
	}
}
