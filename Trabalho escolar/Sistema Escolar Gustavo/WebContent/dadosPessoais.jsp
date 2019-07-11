<!-- Incluir topo -->
<%@page import="beans.AdmBean"%>
<%@page import="dao.AdmDao"%>
<%@include file="topo.jsp" %>
<%@include file="rodapé.jsp" %>

	<!-- CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">
	
	<!-- Mascara -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="css/jquery.mask.min.js"></script>
	
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
		
		// VARIÁVEL DO cpfAluno
		String nomeAdm = "";
		String senhaAdm = "";
	
		// TENTATIVA DE OBTER ALUNO VIA URL
		try{
			
			nomeAdm = request.getParameter("nomeLogin");
			senhaAdm = request.getParameter("senhaLogin");
			
		}catch(Exception erro){}
		
		// CONDICIONAL 
		if(nomeAdm == null && senhaAdm == null) {
	%>
	
	<form class="dadosPessoais" action="" method="post">
	
		<div class="icone">
		<img class="icone" src="icone/icone.png">
		<h2>Meus dados</h2>
		</div>
		<div class="dadoLabel">
		<label>CPF</label>
		<input type="text" class="cpf" placeholder="CPF" name ="cpfAdmin">
		<br>
		<label>Nome</label>
		<input type="text" placeholder="Nome" name ="nome">
		<br>
		<label>Senha</label>
		<input type="text" placeholder="Senha" name ="senha">
		<br>
		<label>Telefone</label>
		<input type="text" class="tel" placeholder="Telefone" name ="telefone">
		<br>
		<label>Data</label>
		<input type="text" class="data" placeholder="Data de Nascimento" name ="data">
		<br>
		<label>Email</label>
		<input type="email" placeholder="E-mail" name ="email">
		<br>
		<label>Endereço</label>
		<input type="text" placeholder="Endereço" name ="endereco">
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-outline-warning">
	</form>
	
	<% 
	
		}else{
	
		// OBTER ADM LOGADO
		AdmDao admD = new AdmDao();
		AdmBean admB = admD.obterDados(nomeAdm, senhaAdm);
	
	%>
	
	<form class="dadosPessoais" action="requisicoes/alterarDados.jsp" method="post">
	
	<input type="hidden" name="nomeAdm" value="<% out.print(nomeAdm); %>">
	<input type="hidden" name="senhaAdm" value="<% out.print(senhaAdm); %>">
	
		<div class="icone">
		<img class="icone" src="icone/icone.png">
		<h2>Meus dados</h2>
		</div>
		<div class="dadoLabel">
		<label>CPF</label>
		<input type="text" class="cpf" placeholder="CPF" name ="cpfAdmin" value="<% out.print(admB.getCpfAdmin()); %>">
		<br>
		<label>Nome</label>
		<input type="text" placeholder="Nome" name ="nome" value="<% out.print(admB.getNomeAdmin()); %>" disabled >
		<br>
		<label>Senha</label>
		<input type="text" placeholder="Senha" name ="senha" value="<% out.print(admB.getSenhaAdmin()); %>" disabled>
		<br>
		<label>Telefone</label>
		<input type="text" class="tel" placeholder="Telefone" name ="telefone" value="<% out.print(admB.getTelefoneAdmin()); %>">
		<br>
		<label>Data</label>
		<input type="text" class="data" placeholder="Data de Nascimento" name ="data" value="<% out.print(admB.getDataNascimentoAdmin()); %>">
		<br>
		<label>Email</label>
		<input type="email" placeholder="E-mail" name ="email" value="<% out.print(admB.getEmailAdmin()); %>">
		<br>
		<label>Endereço</label>
		<input type="text" placeholder="Endereço" name ="endereco" value="<% out.print(admB.getEnderecoAdmin()); %>">
		</div>
		<input type="submit" value="Alterar" class="btn btn-outline-warning">
	</form>
	
	<% } %>
	
</body>
</html>