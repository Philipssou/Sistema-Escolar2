<%@ page import="dao.ProfessorDao"%> 
<%

	// OBTER O CPF DO PROFESSOR
	String cpfProfessor = request.getParameter("cpfProfessor");

	// EXCLUIR PROFESSOR
	ProfessorDao pd = new ProfessorDao();
	boolean valida = pd.excluirProfessor(cpfProfessor);
	
	// REDIRECIONAMENTO
	if(valida == true){
		response.sendRedirect("../professores.jsp?mensagem=excluirProfessorOk");
	}else{
		response.sendRedirect("../professores.jsp?mensagem=excluirProfessorFalha");
	}

%>