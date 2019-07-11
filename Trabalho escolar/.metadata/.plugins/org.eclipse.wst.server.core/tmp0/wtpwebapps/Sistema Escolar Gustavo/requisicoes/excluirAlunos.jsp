<%@ page import= "dao.AlunoDao" %>
<% 

	// OBTER CPF DO ALUNO
	String cpfAluno = request.getParameter("cpfAluno");

	// EXCLUIR ALUNO
	AlunoDao ad = new AlunoDao();
	boolean valida = ad.excluirAluno(cpfAluno);
	
	// REDIRECIONAMENTO
	if(valida == true){
		response.sendRedirect("../alunos.jsp?mensagem=excluirAlunoOk");
	}else{
		response.sendRedirect("../alunos.jsp?mensagem=excluirAlunoFalha");
	}

%>