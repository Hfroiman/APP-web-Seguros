<%@page import="dominio.Tiposeguro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="servletSeguros?param=1">Agregar seguro</a>
	<a href="servletSeguros?parametrolistar=1">Listar seguros</a>
	
	<form method="get" action="servlets">
	
		<h2>Agregar Seguros</h2>
		
		<table>
		<tr>
			<th>Id seguro </th>
			<td><%int nuevoid=0;
					if(request.getAttribute("valorid")!=null){
						nuevoid=(int)request.getAttribute("valorid");%>
						<%= nuevoid %>
					<%}%>
			</td>
		</tr>
		<tr><th>Descripcion</th> <td><input type="text" name="txtdescripcion"></td></tr>
		
		
		<tr>
			<th>Tipos de seguros</th>
			<th>
				<select name="Seguros">
					<%ArrayList<Tiposeguro> lista= null;
					if(request.getAttribute("valorTipo")!=null){
						lista=(ArrayList<Tiposeguro>)request.getAttribute("valorTipo");
					}
					if(lista!=null){
						for(Tiposeguro tpseguro: lista){%>
							<option value="<%=tpseguro.getID()%>"> <%=tpseguro.getDescripcion()%> </option>						
					  <%}
					}%>					
				</select>
			</th>
		</tr>
		<tr> <th>Costo de contratacion</th> <td><input type="text" name="txtcostocontratacion"></td></tr>
		<tr> <th>Costo maximo asegurado</th> <td><input type="text" name="txtcostomaximo"></td></tr>
		<tr> <th></th> <td><input type="submit" name="btnaceptar" value="Aceptar"></td></tr>
		</table> 
	</form>
</body>
</html>