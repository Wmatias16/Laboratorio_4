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

import daoImpl.AlumnoDaoImpl;
import daoImpl.CursoDaoImpl;
import daoImpl.MateriaDaoImpl;
import daoImpl.ProfesorDaoImpl;
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
		AlumnoDaoImpl adao = new AlumnoDaoImpl();
		ArrayList<Alumno> lista= adao.getAlumnos();
		request.setAttribute("listaAlumnos", lista);
		
		
		ProfesorDaoImpl pdao = new ProfesorDaoImpl();
		ArrayList<Profesor> listaP= pdao.ListarProfesores();
		
		request.setAttribute("listaProfesor", listaP);
		
		
		MateriaDaoImpl mdao = new MateriaDaoImpl();
		ArrayList<Materia> listaM = mdao.getMaterias();
		
		request.setAttribute("listaMateria", listaM);
		
		RequestDispatcher rd = request.getRequestDispatcher("/CursosAgregar.jsp");   
        rd.forward(request, response);		
		
	}
	
	public void getCursoByLegajoDocente(HttpServletRequest request, HttpServletResponse response, int legajo) throws ServletException, IOException {
		CursoDaoImpl cursoDaoImpl = new CursoDaoImpl();
		List<Curso> cursos = cursoDaoImpl.getCursosDelDocente(legajo);
		request.setAttribute("listaCursos", cursos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VistaCursos.jsp");
		requestDispatcher.forward(request, response);
		
		
	}
	
	public void crearCurso(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Curso curso = new Curso();
		
		// PARAMETROS DEL FRONT
		curso.setProfesor(new Profesor(Integer.parseInt(request.getParameter("legajoProfesor"))));
		curso.setMateria(new Materia(Integer.parseInt(request.getParameter("idMateria"))));
		curso.setAnio(request.getParameter("selectAnnio"));
		curso.setSemestre(request.getParameter("SelecSemestre"));
		
		
		String[] legajos = request.getParameter("legajos").split(",");
		
		CursoDaoImpl cdao = new CursoDaoImpl();
		// SI CREO EL CURSO PASO A AGREGAR LOS ALUMNOS EN ALUMNOSXCURSO
		int fila = cdao.altaCurso(curso);	
		int validar = 0;
		if(fila == 1) {
			
			// ID DEL CURSO RECIEN CREADO
			int idCurso = cdao.buscarMaxId();
			
			// RECORRE LOS LEGAJOS
			for(int i = 0;i < legajos.length; i++) {
				validar = cdao.altaCursoXalumno(idCurso,legajos[i]);
			}		
			
			
		}
		
		//Validacion
		String mensajeAlta = "";
		Boolean errorAlta = false;
		
		if(validar == 1) {
			mensajeAlta = "�Se Agrego el alumno exitosamente!";
		}else {
			mensajeAlta = "�Error! No se agrego el alumno";
			errorAlta = true;
		}
		
		request.setAttribute("error", errorAlta);
		request.setAttribute("mensaje",mensajeAlta);
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VistaAdministrador.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
}
