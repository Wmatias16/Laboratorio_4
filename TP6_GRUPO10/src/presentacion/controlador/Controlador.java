package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import presentacion.vista.JPanelAgregarPersona;
import presentacion.vista.JPanelEliminarPersona;
import presentacion.vista.JPanelModificarPersona;
import presentacion.vista.JpanelListarPersona;
import entidad.Persona;
import negocio.IPersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private IPersonaNegocio pNeg;
	private JPanelAgregarPersona panelAgregar;
	private JPanelEliminarPersona panelEliminar;
	private JPanelModificarPersona panelModificar;
	private JpanelListarPersona panelListar;
	private List<Persona> listaDePersonas;
	
	public Controlador(VentanaPrincipal principal, IPersonaNegocio personaNegocio)
	{
		this.ventanaPrincipal = principal;
		this.pNeg = personaNegocio;		
		this.panelAgregar = new JPanelAgregarPersona();
		this.panelEliminar = new JPanelEliminarPersona();
		this.panelModificar = new JPanelModificarPersona();	
		this.panelListar = new JpanelListarPersona();
		
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoAbrirVentanaAgregar(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoAbrirVentanaEliminar(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a -> EventoAbrirVentanaModificar(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a -> EventoAbrirVentanaListar(a));
		
		this.panelAgregar.getBtnAceptar().addActionListener(s->EventoBtnAgregarUsuario(s));
		this.panelEliminar.getBtnEliminar().addActionListener(s -> EventoBtnEliminarUsuario(s));
		this.panelModificar.getBtnModificar().addActionListener(s -> EventoBtnModificarUsuario(s));
		this.panelModificar.getJListPersonas().addListSelectionListener(s -> EventoItemJListSeleccionado(s));
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
		
		if(pNeg.VerificarDni(dni) > 0) {
			this.panelAgregar.mostrarMensaje("El Dni  se encuentra Registrado");
		}else {
			
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
		
		
		
	}
	
	public void EventoAbrirVentanaEliminar(ActionEvent a)
	{
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(panelEliminar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
		this.panelEliminar.setDefaultListModelPersonas(obtenerDefaultListModelDeListaDePersonas());
	}
	
	public void EventoBtnEliminarUsuario(ActionEvent s) {
		Persona usuario = this.panelEliminar.getJListPersonas().getSelectedValue();
		if (usuario == null) {
			this.panelEliminar.mostrarMensaje("Debe seleccionar un usuario a eliminar");
		} else if (pNeg.delete(usuario)) {
			this.panelEliminar.mostrarMensaje("Usuario eliminado exitosamente");
			this.panelEliminar.setDefaultListModelPersonas(obtenerDefaultListModelDeListaDePersonas());
		}
	}
	
	public void EventoAbrirVentanaModificar(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(panelModificar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
		this.panelModificar.setDefaultListModelPersonas(obtenerDefaultListModelDeListaDePersonas());
	}
	
	public void EventoAbrirVentanaListar(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(panelListar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
		this.panelListar.setDefaultTableModel(obtenerDefaultTableModelDeListaDePersonas());
	}
	
	public void EventoItemJListSeleccionado(ListSelectionEvent s) {
		Persona usuario = this.panelModificar.getJListPersonas().getSelectedValue();
		if (usuario != null) {
			this.panelModificar.getTxtNombre().setText(usuario.getNombre());
			this.panelModificar.getTxtApellido().setText(usuario.getApellido());
			this.panelModificar.getTxtDni().setText(usuario.getDni());
		}
	}
	
	public void EventoBtnModificarUsuario(ActionEvent s) {
		String nombre = this.panelModificar.getTxtNombre().getText();
		String apellido = this.panelModificar.getTxtApellido().getText();
		String dni = this.panelModificar.getTxtDni().getText();
		if (nombre.trim().length() == 0 || apellido.trim().length() == 0 || dni.trim().length() == 0) {
			this.panelModificar.mostrarMensaje("Debe seleccionar un usuario a modificar");
		} else if (pNeg.update(new Persona(dni, nombre, apellido))) {
			this.panelModificar.mostrarMensaje("El usuario fue modificado exitosamente");
			this.panelModificar.setDefaultListModelPersonas(obtenerDefaultListModelDeListaDePersonas());
			this.panelModificar.getTxtNombre().setText("");
			this.panelModificar.getTxtApellido().setText("");
			this.panelModificar.getTxtDni().setText("");
		}
	}
	
	public void inicializar(Boolean estado)
	{
		this.ventanaPrincipal.setVisible(estado);
	}
	
	
	public DefaultListModel<Persona> obtenerDefaultListModelDeListaDePersonas() {
		this.listaDePersonas = pNeg.getAll();
		DefaultListModel<Persona> defaultListModel = new DefaultListModel<>();
		for (Persona persona : listaDePersonas) {
			defaultListModel.addElement(persona);
		}
		return defaultListModel;
	}
	
	public DefaultTableModel obtenerDefaultTableModelDeListaDePersonas() {
		this.listaDePersonas = pNeg.getAll();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		defaultTableModel.addColumn("Dni");
		defaultTableModel.addColumn("Nombre");
		defaultTableModel.addColumn("Apellido");
		
		String[] dato = new String[3];
		
		for (Persona persona : listaDePersonas) {
			
			dato[0]=persona.getDni();
			dato[1]=persona.getNombre();
			dato[2]=persona.getApellido();
			
			defaultTableModel.addRow(dato);
		}
		return defaultTableModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
