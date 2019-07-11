package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.AdmBean;
import conexao.Conexao;

public class AdmDao {

	// Valida login
	public int validarLogin(String nomeAdmin, String senhaAdmin) {
		
		//Contador
		int contador = 0;
		
		//Obter conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT COUNT(*) FROM administradores WHERE nomeAdm = ? AND senhaAdm = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, nomeAdmin);
			pstmt.setString(2, senhaAdmin);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.last();
			
			contador = rs.getInt(1);
		
		}catch(Exception erro) {
			System.out.println("Falha ao validar Administrador "+erro.getMessage());
		}
		
		//Retorno
		return contador;
		
	}
	
	// Obter dados de usuario
	public AdmBean obterDados(String nomeAdmin, String senhaAdmin) {
		
		//Objeto AdmBean
		AdmBean admbean = new AdmBean();
		
		//Conexao
		Connection conexao = Conexao.obterConexao();
		
		//Tentantiva
		try {
			String sql = "SELECT * FROM administradores WHERE nomeAdm = ? AND senhaAdm = ?";
					
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, nomeAdmin);
			pstmt.setString(2, senhaAdmin);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.last();
			
			admbean.setCpfAdmin(rs.getString(1));
			admbean.setNomeAdmin(rs.getString(2));
			admbean.setSenhaAdmin(rs.getString(3));
			admbean.setTelefoneAdmin(rs.getString(4));
			admbean.setDataNascimentoAdmin(rs.getString(5));
			admbean.setEmailAdmin(rs.getString(6));
			admbean.setEnderecoAdmin(rs.getString(7));
					
		}catch(Exception erro) {
			System.out.println("Falha ao obter dados "+erro.getMessage());
		}
		
		//Retorno
		return admbean;
	}
	
	// OBTER DADOS DO ADM
	public AdmBean meusDados(String cpfAdmin) {
		
		// OBJETO AdmBean
		AdmBean obj = new AdmBean();
		
		// CONEXÃO
		Connection conexao = Conexao.obterConexao();
		
		// TENTATIVA
		try{
			
			// COMANDO SQL
			String sql = "SELECT * FROM administradores WHERE cpfAdm = ?";
			
			// PREPARAR ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PASSAR PARÂMETROS
			pstmt.setString(1, cpfAdmin);
			
			// EXECUTAR COMANDO
			ResultSet rs = pstmt.executeQuery();
			
			rs.last();
			
			obj.setCpfAdmin(rs.getString(1));
			obj.setNomeAdmin(rs.getString(2));
			obj.setSenhaAdmin(rs.getString(3));
			obj.setTelefoneAdmin(rs.getString(4));
			obj.setDataNascimentoAdmin(rs.getString(5));
			obj.setEmailAdmin(rs.getString(6));
			obj.setEnderecoAdmin(rs.getString(7));
			
			// FINALIZAR CONEXÕES
			pstmt.close();
			conexao.close();
			
		}catch(Exception erro) {
			System.out.println("Falha ao obter Dados no Banco"+erro.getMessage());
		}
		
		//Retorno
		return obj;
	}
}
