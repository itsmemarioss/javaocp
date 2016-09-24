package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosingResources {

	public static final String SQL = "select * from employee";
	
	public static void main(String[] args) throws SQLException{
		
		try(Connection c = TestConnection.getConnection();
			Statement stt = c.createStatement();
			ResultSet rs = stt.executeQuery(SQL)){
			while (rs.next()) {
				System.out.println(rs.getString(3));				
			}
		}
	}
}
