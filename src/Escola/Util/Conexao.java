package Escola.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	public static Connection conectar;
	public static String status = "Não conectou...";

	public static Connection getConnection(int sistema) throws SQLException {
		String conexao = "";
		String usuario = "";
		String senha = "";
		if (sistema == Database.ORACLE) {
			conexao = "jdbc:oracle:thin:@localhost:1521:XE";
			usuario = "system";
			senha = "123@qwe";

		} else {
			throw new IllegalArgumentException("Tipo de banco não suportado");
		}

		if (conectar == null) {
			conectar = DriverManager.getConnection(conexao, usuario, senha);
		}
		

		return conectar;
		
	}
  
	public static void close() throws Exception {
		
		conectar.close();
		
	}
}