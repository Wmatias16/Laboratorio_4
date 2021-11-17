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
				AlumnoDao adao = new AlumnoDao();
				ArrayList<Alumno> lista= adao.getAlumnos();
				
				request.setAttribute("listaAlumnos", lista);
				System.out.print(lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/Alumnos.jsp");   
		        rd.forward(request, response);		
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
