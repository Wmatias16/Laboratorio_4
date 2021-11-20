package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnoDao;
import dominio.Alumno;

/**
 * Servlet implementation class servletAlumno
 */
@WebServlet("/servletAlumnos")
public class servletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Alumno nuevoALumno = new Alumno();		
		
		if(request.getParameter("altaAlumno")!=null) {
			
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
			AlumnoDao adao = new AlumnoDao();
			
			int num = adao.agregarAlumno(alumno);
			actualizarAlumnos(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("/Alumnos.jsp");   
	        rd.forward(request, response);		
		}
		
		doGet(request, response);
	}
	
	
	public void actualizarAlumnos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AlumnoDao adao = new AlumnoDao();
			ArrayList<Alumno> lista= adao.getAlumnos();
			
			request.setAttribute("listaAlumnos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Alumnos.jsp");   
	        rd.forward(request, response);		
		
	}
	
	
}
