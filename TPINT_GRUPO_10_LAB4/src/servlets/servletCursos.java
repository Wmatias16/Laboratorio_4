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
import negocio.IAlumnoNegocio;
import negocio.ICursoNegocio;
import negocio.IMateriaNegocio;
import negocio.IprofesorNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.MateriaNegocioImpl;
import negocioImpl.ProfesorNegocioImpl;

@WebServlet("/servletCursos")
public class servletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletCursos() {
        super();
    }
    
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public void getDatosBD(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		IAlumnoNegocio aNegocio = new AlumnoNegocioImpl();
		IprofesorNegocio pNegocio = new ProfesorNegocioImpl();
		IMateriaNegocio mNegocio = new MateriaNegocioImpl();
		
		request.setAttribute("listaAlumnos", aNegocio.listarAlumnos());
		request.setAttribute("listaProfesor", pNegocio.ListarProfesor());
		request.setAttribute("listaMateria", mNegocio.listarMaterias());
		
		RequestDispatcher rd = request.getRequestDispatcher("/CursosAgregar.jsp");   
        rd.forward(request, response);		
		
	}
	
	public void getCursoByLegajoDocente(HttpServletRequest request, HttpServletResponse response, int legajo) throws ServletException, IOException {
		ICursoNegocio cNegocio = new CursoNegocioImpl();
				
		request.setAttribute("listaCursos", cNegocio.getCursosDocente(legajo));
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
		
		ICursoNegocio cNegocio = new CursoNegocioImpl();
		
		// SI CREO EL CURSO PASO A AGREGAR LOS ALUMNOS EN ALUMNOSXCURSO
		int fila = cNegocio.crearCurso(curso);	
		int validar = 0;
		if(fila == 1) {
			
			// ID DEL CURSO RECIEN CREADO
			int idCurso = cNegocio.buscarMax();
			
			// RECORRE LOS LEGAJOS
			for(int i = 0;i < legajos.length; i++) {
				validar = cNegocio.altaAlumnoXcurso(idCurso,legajos[i]);
			}		
			
		}
		
		//Validacion
		String mensajeAlta = "";
		Boolean errorAlta = false;
		
		if(validar == 1) {
			mensajeAlta = "¡Se agregó el alumno exitosamente!";
		}else {
			mensajeAlta = "¡Error! No se agregó el alumno";
			errorAlta = true;
		}
		
		request.setAttribute("error", errorAlta);
		request.setAttribute("mensaje",mensajeAlta);
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/VistaAdministrador.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
}
