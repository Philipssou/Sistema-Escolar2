<%@page import="beans.AdmBean"%>
<%@page import="dao.AdmDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    //Obter o Usuario e a senha
    String nomeAdmin = request.getParameter("nomeLogin");
    String senhaAdmin = request.getParameter("senhaLogin");
    
    //Validar nome e senha
    AdmDao admD = new AdmDao();
    int contador = admD.validarLogin(nomeAdmin, senhaAdmin);
    
    //Condicional
    if(contador == 0){
    	response.sendRedirect("../index.jsp?mensagem=login");
    }else{
    	AdmBean ab = admD.obterDados(nomeAdmin, senhaAdmin);
    	session.setAttribute("adm", ab);
    	response.sendRedirect("../principal.jsp");
    }
    
    %>