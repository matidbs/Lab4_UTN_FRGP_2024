<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dao.TipoSeguroDao"%>
<%@page import="daoImpl.TipoSeguroDaoImpl"%>
<%@page import="dao.segurosDao"%>
<%@page import="daoImpl.segurosDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Seguro</title>
</head>

<%
segurosDao seguros = new segurosDaoImpl();
TipoSeguroDao tiposDao = new TipoSeguroDaoImpl(); 
%>

<body>
	<div>
		<a href="Inicio.jsp">Inicio</a>
		<a href="AgregarSeguros.jsp">Agregar Seguros</a>
		<a href="ListarSeguros.jsp">Listar Seguros</a>
	</div>
	
	<h1>Agregar Seguros</h1>
	
	<form method="post" action="servletAgregarSeguro">
		<table border="0">
			<tr>
				<td style="width:230px;">Id Seguro:</td>
				<td><%=seguros.proximoID()%></td>
			</tr>
			<tr>
				<td>Descripción:</td>
				<td><input type="text" name="txtDescripcion" required/></td>
			</tr>
			<tr>
				<td>Tipo de Seguro:</td>
				<td>
					<select name="tipo">
						<% ArrayList <TipoSeguro> lista = (ArrayList <TipoSeguro>)tiposDao.listar(); 
  				
  						for(TipoSeguro tipo : lista) {%>
  							<option value=<%=tipo.getIdTipo()%>><%=tipo.getDescripcion() %> </option>
  						<%} %>  
					</select>
				</td>
			</tr>
			<tr>
				<td>Costo contratación:</td>
				<td><input type="text" name="txtCostoContratacion" pattern="^\d+(\.\d+)?$" title = "solo numeros y punto" required /></td>
			</tr>
			<tr>
				<td>Costo Máximo Asegurado:</td>
				<td><input type="text" name="txtCostoMaximo" pattern="^\d+(\.\d+)?$" title = "solo numeros y punto" required /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="btnAceptar" value="Aceptar" />
				</td>
			</tr>
		</table>
	</form>
	
<%
boolean estado = false;
if(request.getAttribute("agregado") != null){
	estado = Boolean.parseBoolean(request.getAttribute("agregado").toString());
}
%>

<%
if(estado){%>
<b>SEGURO AGREGADO CON ÉXITO AL SISTEMA</b>
<%}%>



	
</body>
</html>