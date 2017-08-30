<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadatrar Usuario</title>
<spring:url var="css" value="/static/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="${css }" />
</head>

<body>
	<div class="container">
		<h1>Cadastrar Usuário</h1>
		<br> <br>
		<spring:url value="/usuario/todos" var="inicio" />
		<a class="btn btn-info" href="${inicio }">Inicio</a> <br> <br>
		<spring:url
			value="${usuario.id == null ?  '/usuario/save' : '/usuario/update'}"
			var="save" />
		<form:form modelAttribute="usuario" action="${save }" method="post">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="nome">Nome: </label>
				<form:input path="nome" class="form-control" />
				<form:errors path="nome" cssClass="label label-danger" />
			</div>
			<div class="form-group">
				<label for="sobrenome">Sobrenome: </label>
				<form:input path="sobrenome" class="form-control" />
				<form:errors path="sobrenome" cssClass="label label-danger" />
			</div>
			<div class="form-group">
				<label for="data_nacimento">Data Nascimento: </label>
				<form:input path="data_nascimento" class="form-control" type="date" />
				<form:errors path="data_nascimento" cssClass="label label-danger" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Confirmar</button>
			</div>
		</form:form>
	</div>
</body>
</html>