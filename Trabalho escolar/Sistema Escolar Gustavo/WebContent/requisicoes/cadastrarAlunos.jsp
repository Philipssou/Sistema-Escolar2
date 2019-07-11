<%@ page import="dao.AlunoDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
		
		// OBTER DADOS DO ALUNO
		String cpfAluno = request.getParameter("cpfAluno");
		String nomeAluno = request.getParameter("nome");
		String senhaAluno = request.getParameter("senha");
		String telefoneAluno = request.getParameter("telefone");
		String dataNascimentoAluno = request.getParameter("data");
		String enderecoAluno = request.getParameter("endereco");
		String nomeResponsavel = request.getParameter("responsavel");
		String telefoneResponsavel = request.getParameter("responsavelT");
		String observacao = request.getParameter("obs");
		
		// EXECUTAR CADASTRO
		AlunoDao ad = new AlunoDao();
		boolean valida = ad.cadastrarAluno(cpfAluno, nomeAluno, senhaAluno, telefoneAluno, dataNascimentoAluno, enderecoAluno, nomeResponsavel, telefoneResponsavel, observacao);
		
		// REDIRECIONAMENTO
		if(valida == true){
			response.sendRedirect("../alunos.jsp?mensagem=cadastroAlunoOk");
		}else {
			response.sendRedirect("../alunos.jsp?mensagem=cadastroAlunoFalha");
		}
		
	
%>
