<%@page import="beans.ProfessorBean"%>
<%@page import="dao.ProfessorDao"%>
<%@include file="topo.jsp" %>
<%@include file="rodapé.jsp" %>

	<!-- CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
	
	<!-- Mascara -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="css/jquery.mask.min.js"></script>
	
	<script>
	
		function limparAlerta(){
			
			document.getElementById("mensagem").style.display = "none";
		}
	
	</script>
	
	<!-- MENSAGEM -->
	<%@ include file="mensagem.jsp" %>
	
	<script>
		$(document).ready(function(){
	   	 	$('.data').mask('00/00/0000');
	   		$('.cpf').mask('000.000.000-00');
	   		$('.tel').mask('00000-0000');
		});
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
	
	<form class="formularioProfessor" action="requisicoes/cadastrarProfessores.jsp" method="post">
		<input type="text" class="cpf" placeholder="CPF" name ="cpfProfessor" onclick="limparAlerta()">
		<input type="text" placeholder="Nome" name ="nome" onclick="limparAlerta()">
		<input type="text" placeholder="Senha" name ="senha" onclick="limparAlerta()">
		<input type="text" class="tel" placeholder="Telefone" name ="telefone" onclick="limparAlerta()">
		<input type="text" class="data" placeholder="Data de Nascimento" name ="data" onclick="limparAlerta()">
		<input type="text" placeholder="Endereço" name ="endereco" onclick="limparAlerta()">
		<input type="email" placeholder="E-mail" name="email" onclick="limparAlerta()">
		<input type="submit" value="Cadastrar" placeholder="Cadastrar" class="btn btn-outline-info">
	</form>
	
	<%
		}else{
			
			// OBTER OS DADOS DO ALUNO SELECIONADO
			ProfessorDao pd = new ProfessorDao();
			ProfessorBean pb = pd.obterDados(cpfProfessor);
	%>
	
	<form class="formularioProfessor" action="requisicoes/alterarProfessores.jsp" method="post">
		
		<input type="hidden" name="cpf" value="<% out.print(cpfProfessor); %>">
		
		<input type="text" class="cpf" placeholder="CPF" name ="cpfProfessor" value="<% out.print(pb.getCpfProfessor()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Nome" name ="nome" value="<% out.print(pb.getNomeProfessor()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Senha" name ="senha" value="<% out.print(pb.getSenhaProfessor()); %>" onclick="limparAlerta()">
		<input type="text" class="tel" placeholder="Telefone" name ="telefone" value="<% out.print(pb.getTelefoneProfessor()); %>" onclick="limparAlerta()">
		<input type="text" class="data" placeholder="Data de Nascimento" name ="data" value="<% out.print(pb.getDataNascimentoProfessor()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Endereço" name ="endereco" value="<% out.print(pb.getEnderecoProfessor()); %>" onclick="limparAlerta()">
		<input type="email" placeholder="E-mail" name="email" value="<% out.print(pb.getEmailProfessor()); %>" onclick="limparAlerta()">
		<input type="submit" value="Alterar" placeholder="Cadastrar" class="btn btn-outline-info">
	
		<a href="professores.jsp">Cancelar</a>
	
	</form>
	
	<% } %>
	
	<!-- TABELA -->
	<%
	
		ProfessorDao pd = new ProfessorDao();
		out.print(pd.selecionar());
	
	%>
	

</body>
</html>