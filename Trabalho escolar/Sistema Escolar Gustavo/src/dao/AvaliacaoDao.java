package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.AvaliacaoBean;
import conexao.Conexao;

public class AvaliacaoDao {

	//Cadastro
	public boolean cadastrarAvalicao(int idAvaliacao, int idTurma, int idMateria, String nomeAvaliacao, String cpfProfessor, String dataAvaliacao) {
		
		//validação
		boolean valida = false;
		
		//conexao
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			
			//SQL
			String sql = "INSERT INTO avaliacoes (idAvaliacao, nomeAvaliacao, idTurma, cpfProfessor, dataAvaliacao, idMateria) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idAvaliacao);
			pstmt.setString(2, nomeAvaliacao);
			pstmt.setInt(3, idTurma);
			pstmt.setString(4, cpfProfessor);
			pstmt.setString(5, dataAvaliacao);
			pstmt.setInt(6, idMateria);
			
			//Executar Cadastro
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
			
			valida= true;
		}catch(Exception erro) {
			System.out.println("Falha ao cadastrar Avaliação"+erro.getMessage());
		}

		//retornar valida
		return valida;
	}

	//Selecionar
	public String selecionar() {
		String estrutura = "<table class='tabelaAvalicao'>";
					estrutura += "<tr>";
					estrutura += "<td>ID Avaliação</td>";		
					estrutura += "<td>Avaliação</td>";
					estrutura += "<td>ID Turma</td>";		
					estrutura += "<td>CPF Professor</td>";
					estrutura += "<td>Data</td>";
					estrutura += "<td>ID Materia</td>";
					estrutura += "<td>Alterar</td>";
					estrutura += "<td>Excluir</td>";
				estrutura += "</tr>";
		   
   //Conexão
   		Connection conexao = Conexao.obterConexao();
   		
   	//tentativa
   		try {
   			//sql
   			String sql = "SELECT * FROM avaliacoes";
   			
   			Statement stmt = conexao.createStatement();
   			ResultSet rs = stmt.executeQuery(sql);
   			
   			while(rs.next()) {
   				estrutura +="</tr>";
   				estrutura += "<td>"+rs.getInt(1)+"</td>";
				estrutura += "<td>"+rs.getString(2)+"</td>";
				estrutura += "<td>"+rs.getInt(3)+"</td>";
				estrutura += "<td>"+rs.getString(4)+"</td>";
				estrutura += "<td>"+rs.getString(5)+"</td>";
				estrutura += "<td>"+rs.getInt(6)+"</td>";
				estrutura += "<td><a href='avaliacoes.jsp?idAvaliacao="+rs.getInt(1)+"'>Alterar</a></td>";
				estrutura += "<td><a href='requisicoes/excluirAvaliacoes.jsp?idAvaliacao="+rs.getInt(1)+"'>Excluir</a></td>";
   			}
   			
   			stmt.close();
   			conexao.close();
   			
   		}catch(Exception e) {}
   		
   		//Finalizar estrutura
   		estrutura += "</table>";
   		
   		//Retorno
   		return estrutura;
		
	}

	//Excluir
	public boolean excluirAvaliacao(int idAvaliacao) {
		
		//valida
		boolean valida = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//sql
			String sql = "DELETE FROM avaliacoes WHERE idAvaliacao = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idAvaliacao);
			
			//Executar
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
			
			valida = true;
		}catch(Exception erro) {}
		
		//Retornar valida
		return valida;
	}

	//Obter Dados
	public AvaliacaoBean obterDados(int idAvaliacao) {
		
		//objeto avaliacao
		AvaliacaoBean obj = new AvaliacaoBean();
		
		//Conexao
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//sql
			String sql = "SELECT * FROM avaliacoes WHERE idAvaliacao = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idAvaliacao);
			
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			
			obj.setIdAvaliacao(rs.getInt(1));
			obj.setNomeAvaliacao(rs.getString(2));
			obj.setIdTurma(rs.getInt(3));
			obj.setCpfProfessor(rs.getString(4));
			obj.setDataAvaliacao(rs.getString(5));
			obj.setIdMateria(rs.getInt(6));
			
			//Executar
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		}catch(Exception erro) {}
		
		//retorno
		return obj;
	}

	//Alterar
	public boolean alterarAvaliacao(AvaliacaoBean obj) {
		
		//Valida
		boolean valida = false;
		
		//conexao
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//sql
			String sql = "UPDATE avaliacoes SET nomeAvaliacao = ?, idTurma = ?, cpfProfessor = ?, dataAvaliacao = ?, idMateria = ? WHERE idAvalicao = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeAvaliacao());
			pstmt.setInt(2, obj.getIdTurma());
			pstmt.setString(3, obj.getCpfProfessor());
			pstmt.setString(4, obj.getDataAvaliacao());
			pstmt.setInt(5, obj.getIdMateria());
			pstmt.setInt(6, obj.getIdAvaliacao());
			
			//Executar
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
			
			valida = true;
		}catch(Exception erro) {}
		
		//retorno
		return valida;
	}
}
