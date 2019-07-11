<%@page import="beans.AlunoBean"%>
<%@page import="dao.AlunoDao"%>
<%@include file="topo.jsp" %>
<%@include file="rodapé.jsp" %>

	<!-- MENSAGEM -->
	<%@ include file="mensagem.jsp" %>

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
	
	<script>
		$(document).ready(function(){
	   	 	$('.data').mask('00/00/0000');
	   		$('.cpf').mask('000.000.000-00');
	   		$('.tel').mask('00000-0000');
		});
	</script>
	
	<!-- FORMULARIO -->
	<%
		
		// VARIÁVEL DO cpfAluno
		String cpfAluno = "";
	
		// TENTATIVA DE OBTER ALUNO VIA URL
		try{
			
			cpfAluno = request.getParameter("cpfAluno");
			
		}catch(Exception erro){}
		
		// CONDICIONAL 
		if(cpfAluno == null) {
	%>
	
	<form class="formularioAluno" action="requisicoes/cadastrarAlunos.jsp" method="post">
	
		<input type="text" class="cpf" placeholder="CPF" name ="cpfAluno" onclick="limparAlerta()">
		<input type="text" placeholder="Nome" name ="nome" onclick="limparAlerta()">
		<input type="text" placeholder="Senha" name ="senha" onclick="limparAlerta()">
		<input type="text" class="tel" placeholder="Telefone" name ="telefone" onclick="limparAlerta()">
		<input type="text" class="data" placeholder="Data de Nascimento" name ="data" onclick="limparAlerta()">
		<input type="text" placeholder="Endereço" name ="endereco" onclick="limparAlerta()">
		<input type="text" placeholder="Nome do Responsavel" name ="responsavel" onclick="limparAlerta()">
		<input type="text" class="tel" placeholder="Telefone do Responsavel" name ="responsavelT" onclick="limparAlerta()">
		<input type="text" placeholder="Observações" name ="obs" onclick="limparAlerta()">
		<input type="submit" value="Cadastrar" placeholder="Cadastrar" class="btn btn-outline-primary">
	</form>
	
	<%
		}else{
			
			// OBTER OS DADOS DO ALUNO SELECIONADO
			AlunoDao ad = new AlunoDao();
			AlunoBean ab = ad.obterDados(cpfAluno);
	%>
	
	<form class="formularioAluno" action="requisicoes/alterarAlunos.jsp" method="post">
	
		<input type="hidden" name="cpf" value="<% out.print(cpfAluno); %>">
	
		<input type="text" class="cpf" placeholder="CPF" name ="cpfAluno" value="<% out.print(ab.getCpfAluno()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Nome" name ="nome" value="<% out.print(ab.getNomeAluno()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Senha" name ="senha" value="<% out.print(ab.getSenhaAluno()); %>" onclick="limparAlerta()">
		<input type="text" class="tel" placeholder="Telefone" name ="telefone" value="<% out.print(ab.getTelefoneAluno()); %>" onclick="limparAlerta()">
		<input type="text" class="data" placeholder="Data de Nascimento" name ="data" value="<% out.print(ab.getDataNascimentoAluno()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Endereço" name ="endereco" value="<% out.print(ab.getEnderecoAluno()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Nome do Responsavel" name ="responsavel" value="<% out.print(ab.getNomeResponsavel()); %>" onclick="limparAlerta()">
		<input type="text" class="tel" placeholder="Telefone do Responsavel" name ="responsavelT" value="<% out.print(ab.getTelefoneResponsavel()); %>" onclick="limparAlerta()">
		<input type="text" placeholder="Observações" name ="obs" value="<% out.print(ab.getObservacao()); %>" onclick="limparAlerta()">
		<input type="submit" value="Alterar" placeholder="Cadastrar" class="btn btn-outline-primary">
	
		<a href="alunos.jsp">Cancelar</a>
	
	</form>
	
	<% } %>
	
	<!-- TABELA -->
	<%
	
		AlunoDao ad = new AlunoDao();
		out.print(ad.selecionar());
	
	%>

</body>
</html>
