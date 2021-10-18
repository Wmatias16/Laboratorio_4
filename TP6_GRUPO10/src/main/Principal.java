package main;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
		IPersonaNegocio pNegocio = new PersonaNegocioImpl();		
		Controlador controlador = new Controlador(principal,pNegocio);		
		controlador.inicializar(true);;		
	}

}
