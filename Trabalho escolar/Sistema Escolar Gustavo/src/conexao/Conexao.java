package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// MÉTODO DE CONEXÃO
	public static Connection obterConexao() {
		
		// OBJETO DE CONEXÃO
		Connection conection = null;
		
		// TENTATIVA
		try {
			
			// OBTENDO CONEXÃO DA BIBLIOTECA
			Class.forName("com.mysql.jdbc.Driver");
			
			// ABRINDO CONEXÃO COM O BANCO DE DADOS
			conection = DriverManager.getConnection("jdbc:mysql://localhost/sistema_escolar","root","");
			
		}catch(Exception erro) {
			System.out.println("Falha ao conectar: "+erro.getMessage());
		}
		
		// RETORNO
		return conection;
	}
}
