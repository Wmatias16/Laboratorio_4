package servlets;

import java.io.IOException;

import javax.imageio.IIOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministradorDao;
import dominio.Administrador;

@WebServlet("/servletAdministrador")
public class servletAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletAdministrador() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("loguearAdmin") != null) {
			obtenerDatosAdministrador(request, response);			
		}
	}

	public void obtenerDatosAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");
		AdministradorDao administradorDao = new AdministradorDao();
		Administrador administrador = administradorDao.getAdministradorByEmailAndContrasenia(email, contrasenia);
		if (administrador.getId() > 0) {
			request.setAttribute("AdministradorLogin", administrador);
		} else {
			request.setAttribute("AdministradorLogin", null);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginAdministrador.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	
	

}
