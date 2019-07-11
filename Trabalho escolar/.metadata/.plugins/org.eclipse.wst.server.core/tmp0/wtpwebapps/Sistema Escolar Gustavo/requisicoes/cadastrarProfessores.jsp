<%@ page import="dao.ProfessorDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	// TENTATIVA
	try{
		
		// OBTER DADOS PROFESSOR
		String cpfProfessor = request.getParameter("cpfProfessor");
		String nomeProfessor = request.getParameter("nome");
		String telefoneProfessor = request.getParameter("telefone");
		String dataNascimentoProfessor = request.getParameter("data");
		String enderecoProfessor = request.getParameter("endereco");
		String emailProfessor = request.getParameter("email");
		String senhaProfessor = request.getParameter("senha");
		
		// EXECUTAR CADASTRO
		ProfessorDao pd = new ProfessorDao();
		boolean valida = pd.cadastrarProfessor(cpfProfessor, nomeProfessor, telefoneProfessor, dataNascimentoProfessor, enderecoProfessor, emailProfessor, senhaProfessor);
	
		// REDIRECIONAMENTO
		if(valida == true){
			response.sendRedirect("../professores.jsp?mensagem=cadastroProfessorOk");
		}else {
			response.sendRedirect("../professores.jsp?mensagem=cadastroProfessorFalha");
		}
		
	}catch(Exception erro){
		response.sendRedirect("../professores.jsp?mensagem=cadastroProfessorFalha");
	}

%>
