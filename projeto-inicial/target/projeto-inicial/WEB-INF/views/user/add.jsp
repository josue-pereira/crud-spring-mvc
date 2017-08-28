<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadatrar Usuario</title>
</head>

<body>
	<h1>Cadastrar Usuário</h1>
	<br>
	<br>
	<spring:url value="/usuario/todos" var="inicio"/>
	<a class="btn btn-info" href="${inicio }">Inicio</a>
	<br>
	<br>
	<spring:url value="/usuario/save" var="save"/>
	<form:form modelAttribute="usuario" action="${save }" method="post">
		<div class="form-group">
			<label for="nome">Nome: </label>
			<form:input path="nome" class="form-control" />
		</div>
		<div class="form-group">
			<label for="sobrenome">Sobrenome: </label>
			<form:input path="sobrenome" class="form-control" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Confirmar</button>
		</div>
	</form:form>
</body>
</html>