package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoXCursoDaoImpl;
import dominio.AlumnoXCurso;
import negocio.IAlumnoXcursoNegocio;
import negocioImpl.AlumnoXcursoNegocioImpl;

@WebServlet("/servletAlumnosXCurso")
public class servletAlumnoXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public servletAlumnoXCurso() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("listar") != null) {
			getAlumnosXCursoByIdCurso(request, response, Integer.parseInt(request.getParameter("idCurso")));
		}
		if (request.getParameter("actualizarNotas") != null) {
			String[] notas = request.getParameter("actualizarNotas").split(",");
			
			IAlumnoXcursoNegocio alumXcurso = new AlumnoXcursoNegocioImpl();
			
			List<AlumnoXCurso> listaAlumnosXCurso = alumXcurso.actualizarNotas(notas);
			request.setAttribute("listaAlumnosXCurso", listaAlumnosXCurso);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VerCurso.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	public void getAlumnosXCursoByIdCurso(HttpServletRequest request, HttpServletResponse response, int idCurso) throws ServletException, IOException {
		IAlumnoXcursoNegocio alumXcurso = new AlumnoXcursoNegocioImpl();
		
		request.setAttribute("listaAlumnosXCurso", alumXcurso.getAlumnosXcursoDelCurso(idCurso));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VerCurso.jsp");
		requestDispatcher.forward(request, response);
	}

}
