<!-- MENSAGEM -->
<%

	// TENTATIVA
	try{
		
		String mensagem = request.getParameter("mensagem");

		switch(mensagem){
		
		// ALUNOS
		case "cadastroAlunoOk":
			out.print("<div id='mensagem' class='alert alert-success'>Aluno cadastrado com sucesso!</div>");
		break;	
		
		case "cadastroAlunoFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao cadastrar o aluno</div>");
		break;	
		
		case "excluirAlunoOk":
			out.print("<div id='mensagem' class='alert alert-success'>Produto excluido com sucesso!</div>");
		break;	
		
		case "excluirAlunoFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao excluir o aluno</div>");
		break;	
		
		case "alterarAlunoOk":
			out.print("<div id='mensagem' class='alert alert-success'>Aluno alterado com sucesso!</div>");
		break;	
		
		case "alterarAlunoFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao alterar o aluno</div>");
		break;	
		
		// PROFESSORES
		case "cadastroProfessorOk":
			out.print("<div id='mensagem' class='alert alert-success'>Professor cadastrado com sucesso!</div>");
		break;	
		
		case "cadastroProfessorFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao cadastrar o professor</div>");
		break;	
		
		case "excluirProfessorOk":
			out.print("<div id='mensagem' class='alert alert-success'>Professor excluido com sucesso!</div>");
		break;	
		
		case "excluirProfessorFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao excluir o professor</div>");
		break;	
		
		case "alterarProfessorOk":
			out.print("<div id='mensagem' class='alert alert-success'>Professor alterado com sucesso!</div>");
		break;	
		
		case "alterarProfessorFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao alterar o professor</div>");
		break;
		
		// LOGIN, SESSÃO E SAIR
		case "login":
			out.print("<div id='mensagem' class='alert alert-danger'>Usuário ou senha incorretos</div>");
		break;
		
		case "sessao":
			out.print("<div id='mensagem' class='alert alert-danger'>Sessão expirada, faça o login novamente</div>");
		break;
		
		case "sair":
			out.print("<div id='mensagem' class='alert alert-primary'>Você saiu do sistema</div>");
		break;	
		
		// DADOS PESSOAIS
		case "alterarDadosOk":
			out.print("<div id='mensagem' class='alert alert-success'>Dados alterados com sucesso</div>");
		break;
		
		case "alterarDadosFalha":
			out.print("<div id='mensagem' class='alert alert-danger'>Falha ao alterar dados</div>");
		break;
		}
	
	}catch(Exception erro){}

%>