<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
</head>

<body>
	<h1>Listar Usuários</h1>
	<br>
	<br>
	<spring:url value="/usuario/cadastro" var="cadastro"/>
	<a class="btn btn-info" href="${cadastro }">Novo Usuário</a> 
	<br>
	<br>
	<span>${message == null ? '&nbsp;' : message }</span>
	<br>
	<table class="table table-striped table-condensed">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>AÇÃO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios }">
				<tr>
					<td>${usuario.id }</td>
					<td>${usuario.nome }&nbsp; ${usuario.sobrenome }</td>
					<td>
						<a class="btn btn-info" href="#">Editar</a> 
						<a class="btn btn-danger" href="#">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>