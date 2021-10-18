package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	
	private JMenu menuPersona;	
	private JMenuItem menuAgregar;	
	private JMenuItem menuModificar;
	private JMenuItem menuEliminar;
	private JMenuItem menuListar;
	
	public VentanaPrincipal()
	{
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 494);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuPersona = new JMenu("Persona");
		menuBar.add(menuPersona);
		
		menuAgregar = new JMenuItem("Agregar");
		menuPersona.add(menuAgregar);
		
		menuModificar = new JMenuItem("Modificar");
		menuPersona.add(menuModificar);
		
		menuEliminar = new JMenuItem("Eliminar");
		menuPersona.add(menuEliminar);
		
		menuListar = new JMenuItem("Listar");
		menuPersona.add(menuListar);
	}	
	
	public JMenu getMenuPersona() {
		return menuPersona;
	}

	public void setMenuPersona(JMenu menuPersona) {
		this.menuPersona = menuPersona;
	}

	public JMenuItem getMenuAgregar() {
		return menuAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.menuAgregar = menuAgregar;
	}

	public JMenuItem getMenuModificar() {
		return menuModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.menuModificar = menuModificar;
	}

	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}

	public JMenuItem getMenuListar() {
		return menuListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.menuListar = menuListar;
	}

}
