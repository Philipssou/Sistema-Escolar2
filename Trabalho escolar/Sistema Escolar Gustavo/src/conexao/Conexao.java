package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// M�TODO DE CONEX�O
	public static Connection obterConexao() {
		
		// OBJETO DE CONEX�O
		Connection conection = null;
		
		// TENTATIVA
		try {
			
			// OBTENDO CONEX�O DA BIBLIOTECA
			Class.forName("com.mysql.jdbc.Driver");
			
			// ABRINDO CONEX�O COM O BANCO DE DADOS
			conection = DriverManager.getConnection("jdbc:mysql://localhost/sistema_escolar","root","");
			
		}catch(Exception erro) {
			System.out.println("Falha ao conectar: "+erro.getMessage());
		}
		
		// RETORNO
		return conection;
	}
}
