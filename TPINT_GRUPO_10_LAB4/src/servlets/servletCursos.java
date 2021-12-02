package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnoDao;
import dao.MateriaDao;
import dao.ProfesorDao;
import dominio.Alumno;
import dominio.Materia;
import dominio.Profesor;

/**
 * Servlet implementation class servletCursos
 */
@WebServlet("/servletCursos")
public class servletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("getDatos") != null) {
			getDatosBD(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public void getDatosBD(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		AlumnoDao adao = new AlumnoDao();
		ArrayList<Alumno> lista= adao.getAlumnos();
		request.setAttribute("listaAlumnos", lista);
		
		
		ProfesorDao pdao = new ProfesorDao();
		ArrayList<Profesor> listaP= pdao.ListarProfesores();
		
		request.setAttribute("listaProfesor", listaP);
		
		
		MateriaDao mdao = new MateriaDao();
		ArrayList<Materia> listaM = mdao.getMaterias();
		
		request.setAttribute("listaMateria", listaM);
		
		RequestDispatcher rd = request.getRequestDispatcher("/CursosAgregar.jsp");   
        rd.forward(request, response);		
		
	}
	
}
