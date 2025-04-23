package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.segurosDao;
import daoImpl.segurosDaoImpl;
import dominio.Seguro;
import dominio.TipoSeguro;

@WebServlet("/servletListarSeguros")
public class servletListarSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoSeguro tipo;
	private segurosDao sd = new segurosDaoImpl();
       
    public servletListarSeguros() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Cuando se acciona el btnFiltrar
				if(request.getParameter("btnFiltrar") != null) {
					
					ArrayList<Seguro> listaPorTipo = new ArrayList<Seguro>();
					tipo = new TipoSeguro();
					tipo.setIdTipo(Integer.parseInt(request.getParameter("tiposSeguros").toString()));
					listaPorTipo = sd.listarPorTipo(tipo);
					
					request.setAttribute("listaPorTipo", listaPorTipo);
					RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			        rd.forward(request, response);
				}
				
				if(request.getParameter("btnMostrarTodos") != null) {
					request.setAttribute("listaPorTipo", null);
					RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
					rd.forward(request, response);
				}
		
	}

}
