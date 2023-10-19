package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoSegurodao;
import dominio.Tiposeguro;

/**
 * Servlet implementation class servletTippoSeguro
 */
@WebServlet("/servletTippoSeguro")
public class servletTippoSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoSegurodao segdao;
	private ArrayList<Tiposeguro> lista;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletTippoSeguro() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("param2")!= null) {
			segdao= new TipoSegurodao();
			lista= new ArrayList<Tiposeguro>();
			lista=segdao.ListarTiposdeSeguros();
			
			
			request.setAttribute("valorTipo", lista);
			RequestDispatcher rd1= request.getRequestDispatcher("AgregarSeguro.jsp");
			rd1.forward(request, response);	
		}
		if (request.getParameter("parametrolistar2")!= null) {
			segdao= new TipoSegurodao();
			lista= new ArrayList<Tiposeguro>();
			lista=segdao.ListarTiposdeSeguros();
			
			
			request.setAttribute("ValorlistaTipo", lista);
			RequestDispatcher rd1= request.getRequestDispatcher("ListarSeguros.jsp");
			rd1.forward(request, response);	
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
