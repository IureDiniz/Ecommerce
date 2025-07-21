package br.com.eccomerce.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	// Nome do usuário do mysql
	private static final String USERNAME = "root";
	
	// Senha do banco
	private static final String PASSWORD = "2006";
			
	// Caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/DB_ECCOMERCE";
	
	// Conexão com o banco de dados
	public static Connection createConnectionToMySQL() {
		
		// Faz com que a classe seja carregada pela JVM
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar classe na JVM: " + e);
		}
		
		// Cria a conexão com o banco de dados
		Connection connection;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			System.out.println("Erro ao criar conexão com banco de dados: " + e);
		}
		
		return null;
	}
	
	public static void main(String args) {
		// Recuperar uma conexão com o banco de dados caso exita
		Connection con = createConnectionToMySQL();
		if(con != null) {
			System.out.println("Conexão obtida com sucesso!");
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar a conexão: " + e);
			}
		}
	}
}
