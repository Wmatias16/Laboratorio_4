package dominio;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Ventana()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(350,350);
		setTitle("Ventana");
		getContentPane().setLayout(null);
		
		JButton btnEjercicio = new JButton("Ejercicio 1");
		
		btnEjercicio.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio1 principal = new VentanaEjercicio1();
				principal.cambiarVisible(true);				
			}
		});	
		
		btnEjercicio.setBounds(193, 110, 126, 23);
		getContentPane().add(btnEjercicio);
		
	}
	
	public void cambiarVisible(Boolean estado)
	{
		setVisible(estado);
	}
}
