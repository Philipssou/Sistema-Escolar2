<%@ page import="dao.MateriaDao"%>
<%

	// OBTER ID DA MAT�RIA
	int idMateria = Integer.parseInt(request.getParameter("idMateria"));

	// EXECUTAR EXCLUS�O MAT�RIA
	MateriaDao md = new MateriaDao();
	boolean valida = md.excluirMateria(idMateria);

	// REDIRECIONAMENTO
	if(valida == true){
		response.sendRedirect("../materias.jsp?mensagem=excluirMateriaOk");
	}else{
		response.sendRedirect("../materias.jsp?mensagem=excluirMateriaFalha");
	}
%>