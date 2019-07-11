<%@ page import="dao.MateriaDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

		// OBTER DADOS DA MATÉRIA
		String cpfProfessor = request.getParameter("cpfProfessor");
		String nomeMateria = request.getParameter("pussy1000grau");
		
		// EXECUTAR CADASTRO MATÉRIA
		MateriaDao md = new MateriaDao();
		boolean valida = md.cadastrarMateria(cpfProfessor, nomeMateria);
		
		// REDIRECIONAMENTO
		if(valida == true){
			response.sendRedirect("../materias.jsp?mensagem=cadastroMateriaOk");
		}else {
			response.sendRedirect("../materias.jsp?mensagem=cadastroMateriaFalha");
		}
	
%>