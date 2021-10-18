package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidad.Persona;
import presentacion.vista.JPanelAgregarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private JPanelAgregarPersona panelAgregar;
	
	public Controlador(VentanaPrincipal principal)
	{
		this.ventanaPrincipal = principal;
		
		this.panelAgregar = new JPanelAgregarPersona();
		
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoAbrirVentanaAgregar(a));
		
		this.panelAgregar.getBtnAceptar().addActionListener(a->EventoBtnAgregarUsuario(a));
	}
	
	
	public void EventoAbrirVentanaAgregar(ActionEvent a)
	{
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(panelAgregar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	
	
	public void EventoBtnAgregarUsuario(ActionEvent a) 
	{
		String nombre = "";
		String apellido = "";
		String dni = "";
		
		Persona persona = new Persona(dni,nombre,apellido);
		
		persona.toString();
		
	}
	
	
	public void inicializar(Boolean estado)
	{
		this.ventanaPrincipal.setVisible(estado);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
