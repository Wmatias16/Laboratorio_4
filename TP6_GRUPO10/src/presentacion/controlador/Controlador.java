package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.JPanelAgregarPersona;
import entidad.Persona;
import negocio.IPersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private IPersonaNegocio pNeg;
	private JPanelAgregarPersona panelAgregar;
	
	public Controlador(VentanaPrincipal principal,IPersonaNegocio personaNegocio)
	{
		this.ventanaPrincipal = principal;
		this.pNeg = personaNegocio;		
		this.panelAgregar = new JPanelAgregarPersona();
		
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoAbrirVentanaAgregar(a));
		
		this.panelAgregar.getBtnAceptar().addActionListener(s->EventoBtnAgregarUsuario(s));
	}
	
	
	public void EventoAbrirVentanaAgregar(ActionEvent a)
	{
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(panelAgregar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	
	
	public void EventoBtnAgregarUsuario(ActionEvent s) 
	{
		String nombre = this.panelAgregar.getTxtNombre().getText();
		String apellido = this.panelAgregar.getTxtApellido().getText();
		String dni = this.panelAgregar.getTxtDni().getText();
		
		Persona persona = new Persona(dni,nombre,apellido);
		
		Boolean estado = pNeg.insert(persona);
		String mensaje = "";
		
		if(estado)
		{
			mensaje = "Persona agregada corractamente";
			this.panelAgregar.getTxtDni().setText("");
			this.panelAgregar.getTxtNombre().setText("");
			this.panelAgregar.getTxtApellido().setText("");
		}
		else
		{
			mensaje = "Error en agregar usuario";
		}
		
		this.panelAgregar.mostrarMensaje(mensaje);
		
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
