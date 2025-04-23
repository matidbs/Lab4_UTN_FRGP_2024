<%@page import="java.util.ArrayList"%>
<%@page import="dao.TipoSeguroDao"%>
<%@page import="daoImpl.TipoSeguroDaoImpl"%>
<%@page import="dominio.TipoSeguro" %>
<%@page import="dao.segurosDao"%>
<%@page import="daoImpl.segurosDaoImpl"%>
<%@page import="dominio.Seguro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Seguros</title>
<style>
        table,
        td,
        th {
            border: 1px solid;
            padding: 10px;
        }
 
        table {
            text-align: center;
            width: 100%;
        }
    </style>
</head>
<body>
	<div>
		<a href="Inicio.jsp">Inicio</a>
		<a href="AgregarSeguros.jsp">Agregar Seguros</a>
		<a href="ListarSeguros.jsp">Listar Seguros</a>
	</div>
	
	<h1>"Tipo de seguros en la base de datos"</h1>
	
<form method="post" action="servletListarSeguros">
Busqueda por tipo de Seguros:
	
				<select name="tiposSeguros">
  				<% 
  					TipoSeguroDao tsDao = new TipoSeguroDaoImpl();
  					ArrayList<TipoSeguro> listaTipoSeg = (ArrayList<TipoSeguro>)tsDao.listar();
  					for(TipoSeguro seg : listaTipoSeg) {
  				%>		
  						<option value="<%= seg.getIdTipo() %>"><%= seg.getDescripcion() %></option>
				<% } %>
  				</select> 				
					<input type="submit" name="btnFiltrar" value="Filtrar"/>
					<input type="submit" name="btnMostrarTodos" value="Mostrar todos"/>
				</form>

<%
segurosDao segurosDao = new segurosDaoImpl();
ArrayList <Seguro> listaSeguros;

if(request.getAttribute("listaPorTipo") != null){

	listaSeguros = null;
	listaSeguros = (ArrayList<Seguro>)request.getAttribute("listaPorTipo");
	

}else{

	listaSeguros = null;
	listaSeguros = (ArrayList <Seguro>)segurosDao.obtenerSeguros();

}
%>
<br>
<table border = "1" >
  <tr>
    <th>ID<br>SEGURO</th>
    <th>Descripcíon Seguro</th>
    <th>Descripcíon<br> Tipo Seguro</th>
    <th>Costo<br>Contratacion</th>
    <th>Costo Maximo<br>Asegurado</th>
  </tr>		
			<tr>		
			<%if(listaSeguros != null)
	  {  
	  for(Seguro seguro : listaSeguros) 
		{%>
			
			<tr>		
				<td><%=seguro.getIdSeguro() %></td> 
				<td><%=seguro.getDescripcion() %></td>
				<td><%=seguro.getIdTipo().getDescripcion()%></td> 
				<td><%=seguro.getCostoContratacion()%></td>
				<td><%=seguro.getCostoAsegurado()%></td>	
			</tr>		
			 	
		<%}	  
	  }%>
			
			
			</tr> 		
  </table> 	
	
	
</body>
</html>