<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <% 
    
    //Remover a sessão
    session.removeAttribute("adm");
    
    //Redirecionamento
    response.sendRedirect("index.jsp?mensagem=sair");
    %>