package dominio;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



import java.awt.event.ActionListener;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class VentanaPrincipal {
	
	
	private JFrame frame;
	private JPanel contentPane;
	private static DefaultListModel<Peliculas> listModel;
	
	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Programa");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Peliculas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				JpaneAgregarPeliculas panel = new JpaneAgregarPeliculas();
				panel.setDefaultListModel(listModel);
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
			
			}
		});
		mnNewMenu.add(mntmAgregar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnNewMenu.add(mntmListar);
		
		
	}
	
	public void setVisible(Boolean estado) {
		frame.setVisible(estado);
	}
	
	

}
