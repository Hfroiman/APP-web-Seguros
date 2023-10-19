package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SegurosDao;
import dominio.Seguros;
import dominio.Tiposeguro;

/**
 * Servlet implementation class servlets
 */
@WebServlet("/servlets")
public class servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SegurosDao segurosDao;
	public Tiposeguro tiposeguro;
	public Seguros seguros;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlets() {
        super();
        this.segurosDao= new SegurosDao();
        this.seguros= new Seguros();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnaceptar")!= null) {
			seguros.setDescripcion(request.getParameter("txtdescripcion"));				
			seguros.setCostoContratacion(Float.parseFloat(request.getParameter("txtdescripcion")));				
			seguros.setCostoMaxAsegurado(Float.parseFloat(request.getParameter("txtcostocontratacion")));							
			seguros.setTipoSeguro(segurosDao.TipoSeguro(Integer.parseInt(request.getParameter("Seguros"))));
			
				int fila = segurosDao.agregarSeguro(seguros);
				
				request.setAttribute("Seguro", fila);
				RequestDispatcher rd= request.getRequestDispatcher("AgregarSeguro.jsp");
				rd.forward(request, response);				
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("txtfiltrar")!= null) {
			segurosDao = new SegurosDao();
			ArrayList<Seguros> lista= new ArrayList<Seguros>();
			tiposeguro= new Tiposeguro();
			lista= segurosDao.ListaSegurosFiltrada(Integer.parseInt(request.getParameter("Seguros")));
			
			request.setAttribute("Valorlista", lista);
			RequestDispatcher rd= request.getRequestDispatcher("servletTippoSeguro?parametrolistar2=1");
			rd.forward(request, response);
		}
	}

}
