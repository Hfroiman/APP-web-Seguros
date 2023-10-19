<%@page import="dominio.Tiposeguro"%>
<%@page import="dominio.Seguros"%>
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
	
	<h3>"Tipo de seguros de la base de datos"</h3>
	<form method="post" action="servlets">
		Busqueda por tipo de Seguro:
			<select name="Seguros">
				<%ArrayList<Tiposeguro> lista= null;
					if(request.getAttribute("ValorlistaTipo")!=null){
						lista=(ArrayList<Tiposeguro>)request.getAttribute("ValorlistaTipo");
					}
					if(lista!=null){
						for(Tiposeguro tpseguro: lista){%>
							<option value="<%=tpseguro.getID()%>"> <%=tpseguro.getDescripcion()%> </option>					
					 <%}
				}%>					
			</select>
			<input type="submit" name="txtfiltrar" value="Filtrar"></br>
	</form>
		
	<table border="1">
	<%ArrayList<Seguros> listaSeguros = null;
	if(request.getAttribute("Valorlista")!=null){
		listaSeguros=(ArrayList<Seguros>)request.getAttribute("Valorlista");
	}%>
	<tr><th>Id seguro</th> <th>Descripcion seguro</th><th>Descripcion tipo de seguro</th><th>Costo de contratacion</th><th>Costo maximo asegurado</th></tr>
		<%if(listaSeguros!=null){
			for(Seguros seguros:listaSeguros){%>
			<tr>
				<th><%=seguros.getID()%></th>
				<th><%=seguros.getDescripcion() %></th>
				<th><%=seguros.getTipoSeguro().getDescripcion() %></th>
				<th><%=seguros.getCostoContratacion() %></th>
				<th><%=seguros.getCostoMaxAsegurado() %></th>			
			</tr></br>
			<%}
		}%>
	</table>

</body>
</html>