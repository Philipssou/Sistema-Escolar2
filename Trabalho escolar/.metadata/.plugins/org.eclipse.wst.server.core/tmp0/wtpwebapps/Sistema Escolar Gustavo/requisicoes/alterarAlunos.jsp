<%@ page import= "dao.AlunoDao" %>
<%@ page import= "beans.AlunoBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

	//OBTER OS DADOS
	String cpfAluno = request.getParameter("cpfAluno");
	String nomeAluno = request.getParameter("nome");
	String senhaAluno = request.getParameter("senha");
	String telefoneAluno = request.getParameter("telefone");
	String dataNascimentoAluno = request.getParameter("data");
	String enderecoAluno = request.getParameter("endereco");
	String nomeResponsavel = request.getParameter("responsavel");
	String telefoneResponsavel = request.getParameter("responsavelT");
	String observacao = request.getParameter("obs");
	
	// CRIAR UM OBJETO
	AlunoBean ab = new AlunoBean();
	ab.setCpfAluno(cpfAluno);
	ab.setNomeAluno(nomeAluno);
	ab.setSenhaAluno(senhaAluno);
	ab.setTelefoneAluno(telefoneAluno);
	ab.setDataNascimentoAluno(dataNascimentoAluno);
	ab.setEnderecoAluno(enderecoAluno);
	ab.setNomeResponsavel(nomeResponsavel);
	ab.setTelefoneResponsavel(telefoneResponsavel);
	ab.setObservacao(observacao);
	
	// EXECUTAR A ALTERAÇÃO
	AlunoDao ad = new AlunoDao();
	boolean valida = ad.alterarAluno(ab);
	
	// REDIRECIONAMENTO
	if(valida == true){
		response.sendRedirect("../alunos.jsp?mensagem=alterarAlunoOk");
	}else {
		response.sendRedirect("../alunos.jsp?mensagem=alterarAlunoFalha");
	}

%>