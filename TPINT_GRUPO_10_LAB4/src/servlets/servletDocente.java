package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		
		//listar Profesor
		if(request.getParameter("listar")!=null) {
			ListarProfesores(request, response);
		}
		
		if(request.getParameter("edit")!=null) {
			ObetenerDatosProfesor(request, response);	
		}
		
		if(request.getParameter("delete")!=null) {
			bajaDocente(request, response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//alta alumno
		if(request.getParameter("Alta")!= null )
		{
			altaDocente(request,response);
		}
		
		
		if(request.getParameter("EditProfesor")!=null) {
			System.out.println("entro al edit profe  ");
			modificarProfesor(request, response);	
		}
		
		
		
		
		
		doGet(request, response);
	}
	
	// funciones
	
	public void altaDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Profesor profesor = new Profesor();
		
		profesor.setEmail(request.getParameter("email"));
		profesor.setContrasenia(request.getParameter("contraseña"));
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
		
		
		ActualizarProfesores(request, response);
		//Request
		RequestDispatcher rd=request.getRequestDispatcher("/Docentes.jsp"); 
		rd.forward(request, response);		
	
	
	}
	
	
	
	
	public void ListarProfesores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfesorDao dao = new ProfesorDao();
		ArrayList<Profesor> lista = dao.ListarProfesores();
			
        request.setAttribute("listaProfesor", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Docentes.jsp");   
        rd.forward(request, response);	
	}
	
	//buscamos los datos del profesor mediante el legajo
	public void ObetenerDatosProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String legajo = request.getParameter("legajo");
		ProfesorDao ProfeDao = new ProfesorDao();
		Profesor profe = ProfeDao.getProfesorLegajo(legajo);
		
		request.setAttribute("ProfesorEditar", profe);
		RequestDispatcher rd = request.getRequestDispatcher("/DocentesAgregar.jsp");   
        rd.forward(request, response);
	}

	public void modificarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profesor profesor = new Profesor();
		
		profesor.setEmail(request.getParameter("email"));
		profesor.setContrasenia(request.getParameter("contraseña"));
		profesor.setDni(request.getParameter("dni"));
		profesor.setLocalidad(request.getParameter("localidad"));
		profesor.setNacionalidad(request.getParameter("nacionalidad"));
		profesor.setNombre(request.getParameter("nombre"));
		profesor.setApellido(request.getParameter("apellido"));
		profesor.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		profesor.setDireccion(request.getParameter("direccion"));
		profesor.setTelefono(request.getParameter("telefono"));
		profesor.setLegajo(Integer.parseInt(request.getParameter("legajo")));
		ProfesorDao adao = new ProfesorDao();
		

		adao.ModificarProfesor(profesor);
		
		ActualizarProfesores(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/Docentes.jsp");   
        rd.forward(request, response);		
	}
	
	public void ActualizarProfesores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfesorDao adao = new ProfesorDao();
		ArrayList<Profesor> lista= adao.ListarProfesores();
		request.setAttribute("listaProfesor", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Docentes.jsp");   
        rd.forward(request, response);		
	}
	
	public void bajaDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfesorDao profesorDao = new ProfesorDao();
		String[] legajos = request.getParameter("legajos").split(",");

		for(int i=0;i<legajos.length;i++) {
			profesorDao.CambiarEstadoProfesor(Integer.parseInt(legajos[i]));
		}
		ActualizarProfesores(request,response);
	}
	
	
}
