package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	private static String status = "STATUS: Não conectado";
	private static Connection con = null;

	public ConexaoMySQL(){
		
	}
	
	public static Connection getConexao(){
		
		String servername = "localhost";
		String database = "mydb";
		String user = "root";
		String password = "123456";
		String url = "jdbc:mysql://"+servername+":3306/"+database+"?useSSL=false";
		
		try {
			con=DriverManager.getConnection(url, user, password);
			if(con!=null){
				status="STATUS: Conectado.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static boolean fecharConexao(){
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
