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

/**
 * Servlet implementation class servletSeguros
 */
@WebServlet("/servletSeguros")
public class servletSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SegurosDao segurosDao;
	public Seguros seguros;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguros() {
        super();
        this.segurosDao= new SegurosDao();
        this.seguros= new Seguros();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("param")!= null) {
			int idnuevo=0;
			idnuevo=(segurosDao.UltimoID())+1;
			
			request.setAttribute("valorid", idnuevo);
			RequestDispatcher rd= request.getRequestDispatcher("servletTippoSeguro?param2=1");
			rd.forward(request, response);
		}
		if(request.getParameter("parametrolistar")!=null) {
			segurosDao = new SegurosDao();
			ArrayList<Seguros> lista = new ArrayList<Seguros>();
			lista=segurosDao.ListaSeguros();
			
			
			request.setAttribute("Valorlista", lista);
			RequestDispatcher rd= request.getRequestDispatcher("servletTippoSeguro?parametrolistar2=1");
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
