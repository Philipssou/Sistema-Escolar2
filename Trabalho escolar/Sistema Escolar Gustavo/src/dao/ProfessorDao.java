package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.ProfessorBean;
import conexao.Conexao;

public class ProfessorDao {
	
		// CADASTRAR PROFESSOR
		public boolean cadastrarProfessor(String cpfProfessor, String nomeProfessor, String telefoneProfessor, String dataNascimentoProfessor, String enderecoProfessor, String emailProfessor, String senhaProfessor) {
			
			// VALIDA��O
			boolean valida = false;
			
			// ABRIR CONEX�O
			Connection conexao = Conexao.obterConexao();
			
			// TENTATIVA
			try {
				
				// COMANDO SQL
				String sql = "INSERT INTO professores (cpfProfessor, nomeProfessor, telefoneProfessor, dataNascimentoProfessor, enderecoProfessor, emailProfessor, senhaProfessor) VALUES(?,?,?,?,?,?,?)";
				
				// PREPARA ENVIO PARA O Query
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				
				// PASSAR PAR�METROS
				pstmt.setString(1, cpfProfessor);
				pstmt.setString(2, nomeProfessor);
				pstmt.setString(3, telefoneProfessor);
				pstmt.setString(4, dataNascimentoProfessor);
				pstmt.setString(5, enderecoProfessor);
				pstmt.setString(6, emailProfessor);
				pstmt.setString(7, senhaProfessor);
				
				// EXECUTAR COMANDO SQL
				pstmt.execute();
				
				// FECHAR CONEX�ES
				pstmt.close();
				conexao.close();
				
				// VALOR DA VARI�VEL DE VALIDA��O
				valida=true;
				
			}catch(Exception erro) {
				System.out.println("Falha ao cadastrar Professor "+erro.getMessage());
			}
			
			// RETORNO
			return valida;
		}
		
		// SELECIONAR
		public String selecionar() {
			
			// ESTRUTURA
			String estrutura = "<table id='tabelaProfessor' class='table table-striped table-secondary'>";
						estrutura +="<tr>";
							estrutura +="<td>CPF</td>";
							estrutura +="<td>Nome</td>";
							estrutura +="<td>Telefone</td>";
							estrutura +="<td>Nascimento</td>";
							estrutura +="<td>Endereco</td>";
							estrutura +="<td>Email</td>";
							estrutura +="<td>Senha</td>";
							estrutura +="<td>Alterar</td>";
							estrutura +="<td>Excluir</td>";
							estrutura +="<td>Mat�ria</td>";
						estrutura +="</tr>";
					
				//Conexao
				Connection conexao = Conexao.obterConexao();
			
				//tentativa
				try {
					
				// COMANDO SQL	
				String sql = "SELECT * FROM professores";
				
				// PREPARAR ENVIO PARA O Query
				Statement stmt = conexao.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					estrutura +="<tr>";
						estrutura +="<td>"+rs.getString(1)+"</td>";
						estrutura +="<td>"+rs.getString(2)+"</td>";
						estrutura +="<td>"+rs.getString(3)+"</td>";
						estrutura +="<td>"+rs.getString(4)+"</td>";
						estrutura +="<td>"+rs.getString(5)+"</td>";
						estrutura +="<td>"+rs.getString(6)+"</td>";
						estrutura +="<td>"+rs.getString(7)+"</td>";
						estrutura +="<td><a href='professores.jsp?cpfProfessor="+rs.getString(1)+"'>Alterar</a></td>";
						estrutura +="<td><a href='requisicoes/excluirProfessores.jsp?cpfProfessor="+rs.getString(1)+"'>Excluir</a></td>";
						estrutura +="<td><a href='materias.jsp?cpfProfessor="+rs.getString(1)+"&nomeProfessor="+rs.getString(2)+"'>Atribuir Mat�ria</a></td>";
					estrutura +="</tr>";
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
		public boolean excluirProfessor(String cpfProfessor) {
			
			//Valida
			boolean valida = false;
			
			//Conex�o
			Connection conexao = Conexao.obterConexao();
			
			//Tentativa
			try {
				
				// COMANDO SQL
				String sql = "DELETE FROM professores WHERE	cpfProfessor = ?";
				
				// PREPARAR ENVIO PARA O Query
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				
				// PAR�METROS
				pstmt.setString(1, cpfProfessor);

				// EXECUTAR COMANDO SQL
				pstmt.execute();
				
				// FACHAR CONEX�ES
				pstmt.close();
				conexao.close();
				
				// VALOR DA VARI�VEL DE VALIDA��O
				valida = true;
				
			}catch(Exception erro) {}
			
			// RETORNO
			return valida;
		}

		//Obter dados
		public ProfessorBean obterDados(String cpfProfessor) {
				
			//Objeto Professor Bean
			ProfessorBean obj = new ProfessorBean();
			
			//Conex�o
			Connection conexao = Conexao.obterConexao();
			
			//Tentativa
			try {
				
				// COMANDO SQL
				String sql = "SELECT * FROM professores WHERE cpfProfessor = ?";
				
				// PREPARAR ENVIO PARA O Query
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				
				// PAR�METROS
				pstmt.setString(1, cpfProfessor);
				
				// EXECUTAR COMANDO SQL
				ResultSet rs = pstmt.executeQuery();
				
				//
				rs.last();
				
				//
				obj.setCpfProfessor(rs.getString(1));
				obj.setNomeProfessor(rs.getString(2));
				obj.setTelefoneProfessor(rs.getString(3));
				obj.setDataNascimentoProfessor(rs.getString(4));
				obj.setEnderecoProfessor(rs.getString(5));
				obj.setEmailProfessor(rs.getString(6));
				obj.setSenhaProfessor(rs.getString(7));
				
				// FECHAR CONEX�ES
				pstmt.close();
				conexao.close();
				
			}catch(Exception erro) {}
		 
			//Return
			return obj;
			
			}

		//Alterar
		public boolean alterarProfessor(ProfessorBean obj) {
				
		//Valida
		boolean valida = false;
				
		//Conex�o
		Connection conexao = Conexao.obterConexao();
				
		//Tentativa
		try {
			
			// COMANDO SQL
			String sql = "UPDATE professores SET nomeProfessor = ?, telefoneProfessor = ?, dataNascimentoProfessor = ?, enderecoProfessor = ?, emailProfessor = ?, senhaProfessor = ? WHERE cpfProfessor = ?";
				
			// PREPARA ENVIO PARA O Query
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			// PAR�METROS
			pstmt.setString(1, obj.getNomeProfessor());
			pstmt.setString(2, obj.getTelefoneProfessor());
			pstmt.setString(3, obj.getDataNascimentoProfessor());
			pstmt.setString(4, obj.getEnderecoProfessor());
			pstmt.setString(5, obj.getEmailProfessor());
			pstmt.setString(6, obj.getSenhaProfessor());
			pstmt.setString(7, obj.getCpfProfessor());
			
			// EXECUTAR COMANDO
			pstmt.execute();
					
			// FECHAR CONEX�O
			pstmt.close();
			conexao.close();
				
			// VALOR DA VALIDA��O
			valida = true;
					
			}catch(Exception erro) {}
				
			//Retorno
			return valida;
		}
}
