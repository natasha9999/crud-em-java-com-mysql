package com.crudjava.conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
	
	
//Conexao com banco
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "mysql";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";
	
	public static Connection createConnectionBD() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		return connection;
	}
	
	public static Object main() throws Exception {
		
		Connection con = createConnectionBD();
		
		if (con != null) {
			System.out.print("Conexão obtida!");
			con.close();
		} else {
			System.out.print("Não foi possível obter a conexão");
		}
		return con;
		
	
	}
	public static Connection getConnection() {
		return null;
		
	}

}
