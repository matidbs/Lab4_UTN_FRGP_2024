package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.TipoSeguro;
import dao.segurosDao;
import daoImpl.segurosDaoImpl;


@WebServlet("/servletAgregarSeguro")
public class servletAgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Seguro seguro;
	private TipoSeguro tipo;
	private segurosDao sd = new segurosDaoImpl();
   
    public servletAgregarSeguro() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar") != null) {
			
			seguro = new Seguro();
			seguro.setDescripcion(request.getParameter("txtDescripcion"));
			tipo = new TipoSeguro();
			tipo.setIdTipo(Integer.parseInt(request.getParameter("tipo").toString()));
			seguro.setIdTipo(tipo);
			seguro.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion").toString()));
			seguro.setCostoAsegurado(Float.parseFloat(request.getParameter("txtCostoMaximo").toString()));
			
			boolean agregado = sd.agregarSeguro(seguro);
			
			//REQUEST DISPATCHER
			request.setAttribute("agregado", agregado);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguros.jsp");
	        rd.forward(request, response);
		}
		
	}

}
