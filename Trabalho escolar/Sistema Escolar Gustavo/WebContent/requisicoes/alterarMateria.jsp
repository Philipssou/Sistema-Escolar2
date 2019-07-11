<%@ page import= "dao.MateriaDao"%>
<%@ page import= "beans.MateriaBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	// OBTER DADOS DA MATÉRIA
	int idMateria = Integer.parseInt(request.getParameter("idMateria"));
	String cpfProfessor = request.getParameter("cpfProfessor");
	String nomeMateria = request.getParameter("pussy1000grau");
	
	// CRIAR UM OBJETO
	MateriaBean mb = new MateriaBean();
	mb.setIdMateria(idMateria);
	mb.setCpfPrefessor(cpfProfessor);
	mb.setNomeMateria(nomeMateria);
	
	// EXECUTAR ALTERAÇÃO
	MateriaDao md = new MateriaDao();
	boolean valida = md.alterarMateria(mb);
	
	// REDIRECIONAMENTO
	if(valida == true){
		response.sendRedirect("../materias.jsp?mensagem=alterarMateriaOk");
	}else {
		response.sendRedirect("../materias.jsp?mensagem=alterarMateriaFalha");
	}

%>