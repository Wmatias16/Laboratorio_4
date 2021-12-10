package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoDaoImpl;
import dominio.Alumno;
import negocio.IAlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;


@WebServlet("/servletAlumnos")
public class servletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IAlumnoNegocio alumNegocio = new AlumnoNegocioImpl();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAlumno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("listar")!=null) {
			actualizarAlumnos(request,response);
		}
		
		if(request.getParameter("edit")!=null) {
			obtenerDatosAlumno(request, response);	
		}
				
		if(request.getParameter("delete")!=null) {
			bajaAlumno(request, response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		if(request.getParameter("altaAlumno")!=null) {
			altaAlumno(request, response);	
		}
		
		if(request.getParameter("mdAlumnos")!=null) {	
			modificarAlumno(request, response);	
		}
		
		doGet(request, response);
	}	
	
	public void altaAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Alumno alumno = new Alumno();
					
		alumno.setDni(request.getParameter("dni"));
		alumno.setNombre(request.getParameter("nombre"));
		alumno.setApellido(request.getParameter("apellido"));
		alumno.setEmail(request.getParameter("email"));
		alumno.setFechaNacimiento("2017-06-15");
		alumno.setDireccion(request.getParameter("direccion"));
		alumno.setLocalidad(request.getParameter("localidad"));
		alumno.setNacionalidad(request.getParameter("nacionalidad"));
		alumno.setTelefono(request.getParameter("telefono"));
		
		int num = alumNegocio.altaAlumnos(alumno);
				
		String MensajeAlta = "";
		Boolean ErorAlta= false;
				
		if(num == 1) {
			MensajeAlta = "¡Se Agrego el usuario exitosamente!";
		}else {
			MensajeAlta = "¡Error! No se Agrego el usuario";
			ErorAlta = true;
		}
		
		request.setAttribute("error",MensajeAlta);
		request.setAttribute("mensaje",ErorAlta);
		
		actualizarAlumnos(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/Alumnos.jsp");   
        rd.forward(request, response);	
	}
		
	public void obtenerDatosAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String legajo = request.getParameter("legajo");
				
		request.setAttribute("AlumnoEditar", alumNegocio.obtenerAlumno(legajo));
		RequestDispatcher rd = request.getRequestDispatcher("/AlumnosAgregar.jsp");   
        rd.forward(request, response);
	}

	public void modificarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno alumno = new Alumno();
		
		alumno.setLegajo(Integer.parseInt(request.getParameter("legajo")));
		alumno.setDni(request.getParameter("dni"));
		alumno.setNombre(request.getParameter("nombre"));
		alumno.setApellido(request.getParameter("apellido"));
		alumno.setEmail(request.getParameter("email"));
		alumno.setFechaNacimiento("2017-06-15");
		alumno.setDireccion(request.getParameter("direccion"));
		alumno.setLocalidad(request.getParameter("localidad"));
		alumno.setNacionalidad(request.getParameter("nacionalidad"));
		alumno.setTelefono(request.getParameter("telefono"));
		
		int Validar = alumNegocio.modificarAlumno(alumno);
		
		String mensajeMdf = "";
		Boolean ErrorMdf= false;
		
		if(Validar == 1) {
			mensajeMdf = "¡Se Modifico el usuario exitosamente!";
		}else {
			mensajeMdf = "¡Error! No se Modifico el usuario";
			ErrorMdf = true;
		}
		
		
		request.setAttribute("error",mensajeMdf);
		request.setAttribute("mensaje",ErrorMdf);
		
		actualizarAlumnos(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/Alumnos.jsp");   
        rd.forward(request, response);		
	}
	
	public void actualizarAlumnos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaAlumnos", alumNegocio.listarAlumnos());
		
		RequestDispatcher rd = request.getRequestDispatcher("/Alumnos.jsp");   
        rd.forward(request, response);		
	}
	
	public void bajaAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] legajos = request.getParameter("legajos").split(",");
		
		int Validar = 0;
		
		for(int i=0;i<legajos.length;i++) {
			Validar = alumNegocio.bajaAlumnos((Integer.parseInt(legajos[i])));
		}
		
		String mensajeDel = "";
		Boolean ErrorDel= false;
		
		if(Validar == 1) {
			mensajeDel = "¡Se Elimino el usuario exitosamente!";
		}else {
			mensajeDel = "¡Error! No se Elimino el usuario";
			ErrorDel = true;
		}
		
		
		request.setAttribute("error",mensajeDel);
		request.setAttribute("mensaje",ErrorDel);
		
		
		actualizarAlumnos(request,response);
	}
	
	
}
