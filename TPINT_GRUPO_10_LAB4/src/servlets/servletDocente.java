package servlets;

import java.io.IOException;  


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfesorDao;
import dominio.Profesor;

/**
 * Servlet implementation class servletDocente
 */
@WebServlet("/servletDocente")
public class servletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("btnAceptar")!= null )
		{
			
			Profesor profesor = new Profesor();
			
			profesor.setEmail(request.getParameter("email"));
			profesor.setDni(request.getParameter("dni"));
			profesor.setLocalidad(request.getParameter("localidad"));
			profesor.setNacionalidad(request.getParameter("nacionalidad"));
			profesor.setNombre(request.getParameter("nombre"));
			profesor.setApellido(request.getParameter("apellido"));
			profesor.setFechaNacimiento(request.getParameter("fechaNacimiento"));
			profesor.setDireccion(request.getParameter("direccion"));
			profesor.setTelefono(request.getParameter("telefono"));
			
			ProfesorDao profdao = new ProfesorDao();
			
			profdao.AgregarDocente(profesor);
			
			//Request
			RequestDispatcher rd=request.getRequestDispatcher("/Docentes.jsp"); 
			rd.forward(request, response);
			
			
		}
		
		doGet(request, response);
	}
	
	
	
	
}
