package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dominio.Profesor;
import negocio.IprofesorNegocio;
import negocioImpl.ProfesorNegocioImpl;;

/**
 * Servlet implementation class servletDocente
 */
@WebServlet("/servletDocente")
public class servletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private IprofesorNegocio profeNegocio = new ProfesorNegocioImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletDocente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//listar Profesor
		if(request.getParameter("listar")!=null) {
			ListarProfesores(request, response);
		}
		
		if(request.getParameter("edit")!=null) {
			ObetenerDatosProfesor(request, response);	
		}
		
		if(request.getParameter("delete")!=null) {
			bajaDocente(request, response);
		}
		
		if (request.getParameter("loguearDocente")!=null) {
			ObetenerDatosProfesorByEmailAndContrasenia(request, response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//alta alumno
		if(request.getParameter("Alta")!= null )
		{	
			altaDocente(request,response);
		}
		
		
		if(request.getParameter("EditProfesor")!=null) {
			modificarProfesor(request, response);	
		}
		
		
		
		
		
		doGet(request, response);
	}
	
	// funciones
	
	public void altaDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Profesor profesor = new Profesor();
		
		profesor.setEmail(request.getParameter("email"));
		profesor.setContrasenia(request.getParameter("Contrasenia"));
		profesor.setDni(request.getParameter("dni"));
		profesor.setLocalidad(request.getParameter("localidad"));
		profesor.setNacionalidad(request.getParameter("nacionalidad"));
		profesor.setNombre(request.getParameter("nombre"));
		profesor.setApellido(request.getParameter("apellido"));
		profesor.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		profesor.setDireccion(request.getParameter("direccion"));
		profesor.setTelefono(request.getParameter("telefono"));
		
		
		int Validar =  profeNegocio.AltaProfesor(profesor);
		
		String mensaje = "";
		Boolean error = false;
		
		if(Validar == 1) {
			mensaje = "¡Se agregó el usuario exitosamente!";
		}else {
			mensaje = "¡Error! No se agregó el usuario";
			error = true;
		}
		
		
		request.setAttribute("error", error);
		request.setAttribute("mensaje",mensaje);
		
	
		
		ActualizarProfesores(request, response);
		//Request
		RequestDispatcher rd=request.getRequestDispatcher("/Docentes.jsp"); 
		rd.forward(request, response);		
		
		
	}
	
	
	
	
	public void ListarProfesores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Profesor> lista = profeNegocio.ListarProfesor();
			
        request.setAttribute("listaProfesor", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Docentes.jsp");   
        rd.forward(request, response);	
	}
	
	//buscamos los datos del profesor mediante el legajo
	public void ObetenerDatosProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String legajo = request.getParameter("legajo");
		
		Profesor profe = profeNegocio.getProfesorLegajo(legajo);
				
		request.setAttribute("ProfesorEditar", profe);
		RequestDispatcher rd = request.getRequestDispatcher("/DocentesAgregar.jsp");   
        rd.forward(request, response);
	}
	
	//buscamos los datos del profesor mediante el email y contraseña
	
	public void ObetenerDatosProfesorByEmailAndContrasenia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");
		
		Profesor profe = profeNegocio.getProfesorByEmailAndContrasenia(email, contrasenia);
		
		if (profe.getLegajo() > 0) {
			request.setAttribute("DocenteLogin", profe);
		} else {
			request.setAttribute("DocenteLogin", null);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/LoginDocente.jsp");   
        rd.forward(request, response);
	}

	public void modificarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profesor profesor = new Profesor();
		
		profesor.setEmail(request.getParameter("email"));
		profesor.setContrasenia(request.getParameter("Contrasenia"));
		
		System.out.println("Contraseña --> " + request.getParameter("Contrasenia"));
		
		profesor.setDni(request.getParameter("dni"));
		profesor.setLocalidad(request.getParameter("localidad"));
		profesor.setNacionalidad(request.getParameter("nacionalidad"));
		profesor.setNombre(request.getParameter("nombre"));
		profesor.setApellido(request.getParameter("apellido"));
		profesor.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		profesor.setDireccion(request.getParameter("direccion"));
		profesor.setTelefono(request.getParameter("telefono"));
		profesor.setLegajo(Integer.parseInt(request.getParameter("legajo")));
		
		

		int validar = profeNegocio.ModificarProfesor(profesor);
		
		
		String mensajeMdf = "";
		Boolean errorMdf = false;
		
		if(validar == 1) {
			mensajeMdf = "¡Se modificó el usuario exitosamente!";
		}else {
			mensajeMdf = "¡Error! No se modificó el usuario";
			errorMdf = true;
		}
		
		
		request.setAttribute("error", errorMdf);
		request.setAttribute("mensaje",mensajeMdf);
		

		
		ActualizarProfesores(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/Docentes.jsp");   
        rd.forward(request, response);		
	}
	
	public void ActualizarProfesores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Profesor> lista= profeNegocio.ListarProfesor();
		request.setAttribute("listaProfesor", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Docentes.jsp");   
        rd.forward(request, response);		
	}
	
	public void bajaDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] legajos = request.getParameter("legajos").split(",");
		
		int Validar = 0;
		
		for(int i=0;i<legajos.length;i++) {
			Validar = profeNegocio.BajaProfesor(Integer.parseInt(legajos[i]));
		}
		
		String mensajeElm = "";
		Boolean errorElm = false;
		
		if(Validar == 1) {
			mensajeElm = "¡Se eliminó el usuario exitosamente!";
		}else {
			mensajeElm = "¡Error! No se eliminó el usuario";
			errorElm = true;
		}
		
		
		
		request.setAttribute("error", errorElm);
		request.setAttribute("mensaje",mensajeElm);
		
		
		ActualizarProfesores(request,response);
	}
	
	
}
