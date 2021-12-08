package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnoDao;
import dao.CursoDao;
import dao.MateriaDao;
import dao.ProfesorDao;
import dominio.Alumno;
import dominio.Curso;
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
		
		if(request.getParameter("curso") != null){
			crearCurso(request,response);
		}
		
		if(request.getParameter("listar") != null) {
			getCursoByLegajoDocente(request, response, Integer.parseInt(request.getParameter("legajoDocente")));
			
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
	
	private void getCursoByLegajoDocente(HttpServletRequest request, HttpServletResponse response, int legajo) throws ServletException, IOException {
		CursoDao cursoDao = new CursoDao();
		List<Curso> cursos = cursoDao.getCursosDelDocente(legajo);
		request.setAttribute("listaCursos", cursos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VistaCursos.jsp");
		requestDispatcher.forward(request, response);
		
		
	}
	
	public void crearCurso(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Curso curso = new Curso();
		
		// PARAMETROS DEL FRONT
		curso.setProfesor(new Profesor(Integer.parseInt(request.getParameter("legajoProfesor"))));
		curso.setMateria(new Materia(Integer.parseInt(request.getParameter("idMateria"))));
		curso.setAnio("2021");
		curso.setSemestre("Primer semestre");
		String[] legajos = request.getParameter("legajos").split(",");
		
		CursoDao cdao = new CursoDao();
		// SI CREO EL CURSO PASO A AGREGAR LOS ALUMNOS EN ALUMNOSXCURSO
		int fila = cdao.altaCurso(curso);		
		if(fila == 1) {
			
			// ID DEL CURSO RECIEN CREADO
			int idCurso = cdao.buscarMaxId();
			
			// RECORRE LOS LEGAJOS
			for(int i = 0;i < legajos.length; i++) {
				cdao.altaCursoXalumno(idCurso,legajos[i]);
			}		
			
		}
		
	}
	
	
}
