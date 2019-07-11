<%@page import="beans.AdmBean"%>
<%@page import="dao.AdmDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coordenação</title>

	<!-- CSS  -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
	
	<script>
	
		function limparAlerta(){
			
			document.getElementById("mensagem").style.display = "none";
		}
	
	</script>

</head>
<body>

	<h1 class="logoLogin">Colégio Ralf Lima</h1>
	
	<!-- MENSAGEM -->
	<%@ include file="mensagem.jsp" %>
	
	<form class="formularioLogin" action="requisicoes/logar.jsp" method="post">
		<input type="text" placeholder="Nome" name="nomeLogin" onclick="limparAlerta()">
		<input type="password" placeholder="Senha" name="senhaLogin" onclick="limparAlerta()">
		<input type="submit" class="btn btn-outline-primary">
	</form>

</body>
</html>