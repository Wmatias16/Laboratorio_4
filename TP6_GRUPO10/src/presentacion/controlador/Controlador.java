package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import presentacion.vista.JPanelAgregarPersona;
import presentacion.vista.JPanelEliminarPersona;
import entidad.Persona;
import negocio.IPersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private IPersonaNegocio pNeg;
	private JPanelAgregarPersona panelAgregar;
	private JPanelEliminarPersona panelEliminar;
	private List<Persona> listaDePersonas;
	
	public Controlador(VentanaPrincipal principal,IPersonaNegocio personaNegocio)
	{
		this.ventanaPrincipal = principal;
		this.pNeg = personaNegocio;		
		this.panelAgregar = new JPanelAgregarPersona();
		this.panelEliminar = new JPanelEliminarPersona();
		
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoAbrirVentanaAgregar(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoAbrirVentanaEliminar(a));
		
		this.panelAgregar.getBtnAceptar().addActionListener(s->EventoBtnAgregarUsuario(s));
		this.panelEliminar.getBtnEliminar().addActionListener(s -> EventoBtnEliminarUsuario(s));
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
			mensaje = "Persona agregada correctamente";
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
	
	public void EventoAbrirVentanaEliminar(ActionEvent a)
	{
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(panelEliminar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
		this.actualizarJListPersonas();
	}
	
	public void EventoBtnEliminarUsuario(ActionEvent s) {
		Persona usuario = this.panelEliminar.getJListPersonas().getSelectedValue();
		if (usuario == null) {
			this.panelEliminar.mostrarMensaje("Debe seleccionar un usuario a eliminar");
		} else if (pNeg.delete(usuario)) {
			this.panelEliminar.mostrarMensaje("Usuario eliminado exitosamente");
			actualizarJListPersonas();
		}
	}
	
	public void inicializar(Boolean estado)
	{
		this.ventanaPrincipal.setVisible(estado);
	}
	
	public void actualizarJListPersonas() {
		this.listaDePersonas = pNeg.getAll();
		DefaultListModel<Persona> defaultListModel = new DefaultListModel<>();
		for (Persona persona : listaDePersonas) {
			defaultListModel.addElement(persona);
		}
		this.panelEliminar.setDefaultListModelPersonas(defaultListModel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
