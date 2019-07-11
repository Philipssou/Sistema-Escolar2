package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.standard.PresentationDirection;
import javax.swing.JOptionPane;

import beans.AlunoBean;
import conexao.Conexao;

public class AlunoDao {

	// CADASTRAR ALUNO
	public boolean cadastrarAluno(String cpfAluno, String nomeAluno, String senhaAluno,
	String telefoneAluno, String dataNascimentoAluno, String enderecoAluno,
	String nomeResponsavel, String telefoneResponsavel, String observacao) {
		
		// VARIÁVEL DE VALIDAÇÃO
		boolean valida = false;
		
		// OBJETO DE CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "INSERT INTO alunos (cpfAluno, nomeAluno, senhaAluno, telefoneAluno, dataNascimentoAluno, enderecoAluno, nomeResponsavel, telefoneResponsavel, observacao) VALUES (?,?,?,?,?,?,?,?,?)";
			
			// 	PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, cpfAluno);
			pstmt.setString(2, nomeAluno);
			pstmt.setString(3, senhaAluno);
			pstmt.setString(4, telefoneAluno);
			pstmt.setString(5, dataNascimentoAluno);
			pstmt.setString(6, enderecoAluno);
			pstmt.setString(7, nomeResponsavel);
			pstmt.setString(8, telefoneResponsavel);
			pstmt.setString(9, observacao);
			
			// EXECUTAR COMANDO SQL
			pstmt.execute();
			
			// FINALIZAR CONEXÕES
			pstmt.close();
			conexao.close();
			
			// ATRIBUIR VALOR A VARIÁVEL DE VALIDAÇÃO
			valida = true;
			
		}catch(Exception erro) {
			System.out.println("Falha ao cadastrar "+erro.getMessage());
		}
		
		// RETORNO
		return valida;
	}

	// EXCLUIR ALUNO
	public boolean excluirAluno(String cpfAluno) {
		
		// VARIÁVEL DE VALIDAÇÃO
		boolean valida = false;
		
		// CONAXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "DELETE FROM alunos WHERE cpfAluno = ?";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, cpfAluno);
			
			// EXECUTAR COMANDO
			pstmt.execute();
			
			// FINALIZAR CONEXÕES
			pstmt.close();
			conexao.close();
			
			// ATRIBUIR VALOR A VARIÁVEL DE VALIDAÇÃO
			valida = true;
			
		}catch(Exception erro) {
			System.out.println("Falha ao excluir aluno "+erro.getMessage());
		}
		
		//RETORNO
		return valida;
	}

	// AlTERAR ALUNO
	public boolean alterarAluno(AlunoBean obj) {
		
		// VARIÁVEL DE VALIDAÇÃO
		boolean valida = false;
		
		// CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "UPDATE alunos SET nomeAluno = ?, senhaAluno = ?, telefoneAluno = ?, dataNascimentoAluno = ?, enderecoAluno = ?, nomeResponsavel = ?, telefoneResponsavel = ?, observacao = ? WHERE cpfAluno = ?";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, obj.getNomeAluno());
			pstmt.setString(2, obj.getSenhaAluno());
			pstmt.setString(3, obj.getTelefoneAluno());
			pstmt.setString(4, obj.getDataNascimentoAluno());
			pstmt.setString(5, obj.getEnderecoAluno());
			pstmt.setString(6, obj.getNomeResponsavel());
			pstmt.setString(7, obj.getTelefoneResponsavel());
			pstmt.setString(8, obj.getObservacao());
			pstmt.setString(9, obj.getCpfAluno());
			
			// EXECUTAR COMANDO SQL
			pstmt.execute();
			
			// FINALIZAR CONEXÕES
			pstmt.close();
			conexao.close();
			
			// ATRIBUIR VALOR A VARIÁVEL DE VALIDAÇÃO
			valida = true;
			
		}catch(Exception erro) {
			System.out.println("Falha ao alterar aluno "+erro.getMessage());
		}
		
		// RETORNO
		return valida;
	}

	// SELECIONAR
	public String selecionar() {
		
		// ESTRUTURA
		String estrutura = "<table id='tabelaAluno' class='table table-striped table-secondary'>";
					estrutura+= "<tr>";
						estrutura+= "<td>CPF</td>";
						estrutura+= "<td>Nome</td>";
						estrutura+= "<td>Senha</td>";
						estrutura+= "<td>Telefone</td>";
						estrutura+= "<td>Nascimento</td>";
						estrutura+= "<td>Endereço</td>";
						estrutura+= "<td>Responsável</td>";
						estrutura+= "<td>Telefone Responsável</td>";
						estrutura+= "<td>Observação</td>";
						estrutura+= "<td>Alterar</td>";
						estrutura+= "<td>Excluir</td>";
					estrutura+= "</tr>";
					
		// CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "SELECT * FROM alunos";
			
			// PREPARAR ENVIO PARA O Query
			Statement stmt = conexao.createStatement();
			
			// EXECUTAR COMANDO SQL
			ResultSet rs = stmt.executeQuery(sql);
			
			// 
			while(rs.next()) {
				
				estrutura+= "<tr>";
					estrutura+= "<td>"+rs.getString(1)+"</td>";
					estrutura+= "<td>"+rs.getString(2)+"</td>";
					estrutura+= "<td>"+rs.getString(3)+"</td>";
					estrutura+= "<td>"+rs.getString(4)+"</td>";
					estrutura+= "<td>"+rs.getString(5)+"</td>";
					estrutura+= "<td>"+rs.getString(6)+"</td>";
					estrutura+= "<td>"+rs.getString(7)+"</td>";
					estrutura+= "<td>"+rs.getString(8)+"</td>";
					estrutura+= "<td>"+rs.getString(9)+"</td>";
					estrutura+= "<td><a href='alunos.jsp?cpfAluno="+rs.getString(1)+"'>Alterar</a></td>";
					estrutura+= "<td><a href='requisicoes/excluirAlunos.jsp?cpfAluno="+rs.getString(1)+"'>Excluir</a></td>";
				estrutura+= "</tr>";
			}
			
			// FINALIZAR CONEXÕES
			stmt.close();
			conexao.close();
			
		}catch(Exception erro) {
			System.out.println("Falha ao selecionar aluno "+erro.getMessage());
		}
		
		// FINALIZAR ESTRUTURA
		estrutura+= "</table>";
		
		// RETORNO
		return estrutura;
		
	}

	// OBTER DADOS
	public AlunoBean obterDados(String cpfAluno) {
		
		// OBJETO AlunoBean
		AlunoBean obj = new AlunoBean();
		
		// CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "SELECT * FROM alunos WHERE cpfAluno = ?";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, cpfAluno);
			
			// EXECUTAR COMANDO SQL
			ResultSet rs = pstmt.executeQuery();
			
			//
			rs.last();
			
			//
			obj.setCpfAluno(rs.getString(1));
			obj.setNomeAluno(rs.getString(2));
			obj.setSenhaAluno(rs.getString(3));
			obj.setTelefoneAluno(rs.getString(4));
			obj.setDataNascimentoAluno(rs.getString(5));
			obj.setEnderecoAluno(rs.getString(6));
			obj.setNomeResponsavel(rs.getString(7));
			obj.setTelefoneResponsavel(rs.getString(8));
			obj.setObservacao(rs.getString(9));
			
			// FINALIZAR CONEXÕES
			pstmt.close();
			conexao.close();
			
		}catch(Exception erro) {
			System.out.println("Falha ao obter dados do aluno "+erro.getMessage());
		}
		
		// RETORNO
		return obj;
	}
}
