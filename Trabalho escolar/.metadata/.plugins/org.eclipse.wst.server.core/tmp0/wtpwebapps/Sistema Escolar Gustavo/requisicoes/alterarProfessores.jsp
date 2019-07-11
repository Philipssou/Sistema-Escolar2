<%@ page import="dao.ProfessorDao" %>
<%@ page import="beans.ProfessorBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%    

	// OBTER DADOS
	String cpfProfessor = request.getParameter("cpfProfessor");
	String nomeProfessor = request.getParameter("nome");
	String telefoneProfessor = request.getParameter("telefone");
	String dataNascimentoProfessor = request.getParameter("data");
	String enderecoProfessor = request.getParameter("endereco");
	String emailProfessor = request.getParameter("email");
	String senhaProfessor = request.getParameter("senha");
	
	// CRIAR UM OBJETO
	ProfessorBean pb = new ProfessorBean();
	pb.setCpfProfessor(cpfProfessor);
	pb.setNomeProfessor(nomeProfessor);
	pb.setTelefoneProfessor(telefoneProfessor);
	pb.setDataNascimentoProfessor(dataNascimentoProfessor);
	pb.setEnderecoProfessor(enderecoProfessor);
	pb.setEmailProfessor(emailProfessor);
	pb.setSenhaProfessor(senhaProfessor);
	
	// EXECUTAR ALTERAÇÃO
	ProfessorDao pd = new ProfessorDao();
	boolean valida = pd.alterarProfessor(pb);
	
	// REDIRECIONAMENTO
	if(valida == true){
		response.sendRedirect("../professores.jsp?mensagem=alterarProfessorOk");
	}else {
		response.sendRedirect("../professores.jsp?mensagem=alterarProfessorFalha");
	}

%>