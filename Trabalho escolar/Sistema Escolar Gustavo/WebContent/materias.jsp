<!-- Incluir topo -->
<%@page import="beans.MateriaBean"%>
<%@page import="dao.MateriaDao"%>
<%@include file="topo.jsp" %>

	<!-- CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
	
	<!-- MENSAGEM -->
	<%@ include file="mensagem.jsp" %>
	
	<script>
	
		function limparAlerta(){
			
			document.getElementById("mensagem").style.display = "none";
		}
	
	</script>
	
	<!-- Script -->
	<script>
	
		function matematica(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Matemática";
		}
		
		function quimica(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Química";
		}
		
		function fisica(){
	
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Física";
		}

		function portugues(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Português";
		}

		function biologia(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Biologia";
		}
		
		function ingles(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Inglês";
		}
		
		function literatura(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Literatura";
		}
		
		function historia(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "História";
		}
		
		function geografia(){
			
			var campo = document.getElementById("pussy01").value;
			
			campo.innerText = "Geografia";
		}
	
	</script>
	
	<!-- FORMULARIO -->
	<%
		
		// VARIÁVEL DO cpfProfessor
		String cpfProfessor = "";
	
		// TENTATIVA DE OBTER ALUNO VIA URL
		try{
			
			cpfProfessor = request.getParameter("cpfProfessor");
			
		}catch(Exception erro){}
		
		// CONDICIONAL 
		if(cpfProfessor == null) {
			
	%>
	
	<h1 class="materia">Cadastrar Materia</h1>
	
	<form class="formularioMateria" action="requisicoes/alterarMaterias.jsp" method="get">
		
		<input type="hidden" name="cpfProfessor" value="<% out.print(request.getParameter("cpfProfessor"));%>" onclick="limparAlerta()">
		<input type="text" value="<% out.print(request.getParameter("nomeProfessor")); %>" name="nomeProfessor" disabled >
		
		<input type="submit" value="Matemática" class="btn btn-outline-primary" onclick="matematica()">
		<input type="submit" value="Química" class="btn btn-outline-primary" onclick="quimica()">
		<input type="submit" value="Física" class="btn btn-outline-primary" onclick="fisica()">
		<input type="submit" value="Português" class="btn btn-outline-primary" onclick="portugues()">
		<input type="submit" value="Biologia" class="btn btn-outline-primary" onclick="biologia()">
		<input type="submit" value="Inglês" class="btn btn-outline-primary" onclick="ingles()">
		<input type="submit" value="Literatura" class="btn btn-outline-primary" onclick="literatura()">
		<input type="submit" value="História" class="btn btn-outline-primary" onclick="historia()">
		<input type="submit" value="Geografia" class="btn btn-outline-primary" onclick="geografia()">
		
		<input type="text" id="pussy01" name="pussy1000grau" disabled>
		
		<input type="submit" value="Cadastrar" class="btn btn-outline-danger">
	</form>
	
	<%
	
	}else{
	
	%>
	
	<h1 class="materia">Cadastrar Materia</h1>
	
	<form class="formularioMateria" action="requisicoes/cadastrarMaterias.jsp" method="get">
		
		<input type="hidden" name="cpfProfessor" value="<% out.print(request.getParameter("cpfProfessor"));%>" onclick="limparAlerta()">
		<input type="text" value="<% out.print(request.getParameter("nomeProfessor")); %>" name="nomeProfessor" disabled >
		
		<input type="submit" value="Matemática" class="btn btn-outline-primary" onclick="matematica()">
		<input type="submit" value="Química" class="btn btn-outline-primary" onclick="quimica()">
		<input type="submit" value="Física" class="btn btn-outline-primary" onclick="fisica()">
		<input type="submit" value="Português" class="btn btn-outline-primary" onclick="portugues()">
		<input type="submit" value="Biologia" class="btn btn-outline-primary" onclick="biologia()">
		<input type="submit" value="Inglês" class="btn btn-outline-primary" onclick="ingles()">
		<input type="submit" value="Literatura" class="btn btn-outline-primary" onclick="literatura()">
		<input type="submit" value="História" class="btn btn-outline-primary" onclick="historia()">
		<input type="submit" value="Geografia" class="btn btn-outline-primary" onclick="geografia()">
		
		<input type="text" id="pussy01" name="pussy1000grau" disabled>
		
		<input type="submit" value="Cadastrar" class="btn btn-outline-danger">
	</form>
	
	<% } %>
	
	<!-- TABELA -->
	<%
	
		MateriaDao md = new MateriaDao();
		out.print(md.selecionar());
	
	%>
<%@include file="rodapé.jsp" %>