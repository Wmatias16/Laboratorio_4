package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servletSeguro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("btnFiltrar")!=null) {
			SeguroDao seguroDao = new SeguroDao();
			int id = Integer.parseInt(request.getParameter("tipoSeguro"));
			List<Seguro> lista= seguroDao.obtenerSegurosPorTipo(id);			
			request.setAttribute("listaSeguros", lista);			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
	        rd.forward(request, response);
			
		}
		
		
		
		if(request.getParameter("Param")!=null) {
			//Entra por haber echo click en el hyperlink listar seguros
			SeguroDao seguroDao = new SeguroDao();
			List<Seguro> lista= seguroDao.obtenerSeguros();
			
			request.setAttribute("listaSeguros", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
	        rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnEnviar")!=null) {
			
			Seguro seg = new Seguro();
			SeguroDao dao = new SeguroDao();
			TipoSeguro tipo = new TipoSeguro(1,"casa");// Prueba 
			
			seg.setDescripcion(request.getParameter("txtDescripcion"));
			//modificar
			seg.setTipoSeguro(tipo);
			seg.setCostoContratacion(Double.parseDouble(request.getParameter("txtContratacion")));
			seg.setCostoAsegurado(Double.parseDouble(request.getParameter("txtCostoMax")));
			
			int filas = dao.agregarSeguro(seg);
			
			
			request.setAttribute("CantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
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
