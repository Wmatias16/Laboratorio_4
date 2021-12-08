package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnoXCursoDao;
import dominio.AlumnoXCurso;

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
		
	}

	public void getAlumnosXCursoByIdCurso(HttpServletRequest request, HttpServletResponse response, int idCurso) throws ServletException, IOException {
		AlumnoXCursoDao alumnoXCursoDao = new AlumnoXCursoDao();
		List<AlumnoXCurso> listaAlumnosXCurso = alumnoXCursoDao.getAlumnosXCursoDelCurso(idCurso);
		request.setAttribute("listaAlumnosXCurso", listaAlumnosXCurso);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VerCurso.jsp");
		requestDispatcher.forward(request, response);
	}

}
