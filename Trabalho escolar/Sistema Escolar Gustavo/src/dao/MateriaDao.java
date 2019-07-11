package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.MateriaBean;
import conexao.Conexao;

public class MateriaDao {

	// CADASTRO MATÉRIA
	public boolean cadastrarMateria(String cpfProfessor, String nomeMateria) {
		
		// VALIDAÇÃO
		boolean valida = false;
		
		// ABRIR CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "INSERT INTO materias (cpfProfessor, nomeMateria) VALUES (?,?)";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, cpfProfessor);
			pstmt.setString(2, nomeMateria);
			
			// EXECUTAR COMANDO SQL
			pstmt.execute();
			
			// FECHAR CONEXÕES
			pstmt.close();
			conexao.close();
			
			// ATRIBUIR VALOR DE VALIDAÇÃO
			valida = true;
			
		}catch(Exception erro) {
			System.out.println("Falha ao cadastrar matéria "+erro.getMessage());
		}
		
		//Retorno
		return valida;
	}

	//Selecionar
	public String selecionar() {
		
		// ESTRUTURA
		String estrutura = "<table id='tabelaMateria' class='table table-striped table-secondary'>";
					estrutura += "<tr>";
						estrutura += "<td>Id</td>";
						estrutura += "<td>Cpf Professor</td>";
						estrutura += "<td>Matéria</td>";
						estrutura += "<td>Alterar</td>";
						estrutura += "<td>Excluir</td>";
					estrutura += "</tr>";
		
		//Conexão
		Connection conexao = Conexao.obterConexao();

		//tentativa
		try {
			
			// COMANDO SQL
			String sql = "SELECT * FROM materias";
			
			// PREPARAR ENVIO PARA O Query
			Statement stmt = conexao.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				estrutura += "<tr>";
					estrutura += "<td>"+rs.getInt(1)+"</td>";
					estrutura += "<td>"+rs.getString(2)+"</td>";
					estrutura += "<td>"+rs.getString(3)+"</td>";
					estrutura += "<td><a href='materias.jsp?idMateria="+rs.getInt(1)+"'>Alterar</a></td>";
					estrutura += "<td><a href='requisicoes/excluirMaterias.jsp?idMateria="+rs.getInt(1)+"'>Excluir</a></td>";
				estrutura += "</tr>";
			}
			
			stmt.close();
			conexao.close();
		
	}catch(Exception e) {}
	
	//Finalizar estrutura
	estrutura += "</table>";
	
	//Retorno
	return estrutura;
	}

	// EXCLUIR MATÉRIA
	public boolean excluirMateria(int idMateria) {
		
		// VALIDAÇÃO
		boolean valida = false;
		
		// ABRIR CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
		String sql = "DELETE FROM materias WHERE idMateria = ?";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
		
			// PASSAR PARÂMETROS
			pstmt.setInt(1, idMateria);
			
			// EXECUTAR COMANDO SQL
			pstmt.execute();
			
			// FECHAR CONEXÕES
			pstmt.close();
			conexao.close();
			
			// ATRIBUIR VALOR A VARIÁVEL DE VALIDAÇÃO
			valida= true;
			
		}catch(Exception erro) {}
		
		// RETORNO
		return valida;
	}

	// OBTER DADOS DA MATÉRIA
	public MateriaBean obterDados(String cpfProfessor) {
		
	//Objeto ProdutoBean
     MateriaBean obj = new MateriaBean();
				
	//Conexão
    Connection conexao = Conexao.obterConexao();
			
	//tentativa
    try {
    	
    	// COMANDO SQL
    	String sql = "SELECT * FROM materias WHERE idMateria = ?";
		
    	// PREPARAR ENVIO PARA O Query
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		// PARÂMETROS
		pstmt.setString(1, cpfProfessor);
		
		// EXECUTAR COMANDO 
		ResultSet rs = pstmt.executeQuery();
		
		rs.last();
		
		obj.setIdMateria(rs.getInt(1));
		obj.setCpfPrefessor(rs.getString(2));
		obj.setNomeMateria(rs.getString(3));
		
		pstmt.close();
		conexao.close();
    }catch(Exception erro) {}
    
    //retorno
    return obj;
    		
	}

	// ALTERAR MATÉRIA
	public boolean alterarMateria(MateriaBean obj) {
		
		// VALIDAÇÃO
		boolean valida = false;
		
		// CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try {
			
			// COMANDO SQL
			String sql = "UPDATE materias SET cpfProfessor = ?, nomeMateria = ? WHERE idMateria = ?";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, obj.getCpfPrefessor());
			pstmt.setString(2, obj.getNomeMateria());
			pstmt.setInt(4, obj.getIdMateria());
			
			// EXECUTAR COMANDO SQL
			pstmt.execute();
			
			// FECHAR CONEXÕES
			pstmt.close();
			conexao.close();
			
			// ATRIBUIR VALOR A VARIÁVEL DE VALIDAÇÃO
			valida = true;
			
		}catch(Exception erro) {}
		
		// RETORNO
		return valida;
	}
}	
