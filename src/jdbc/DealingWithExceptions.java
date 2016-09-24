package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DealingWithExceptions {

public static final String SQL = "select not_a_column from employee";
	
	public static void main(String[] args) {
		
		try(Connection c = TestConnection.getConnection();
			Statement stt = c.createStatement();
			ResultSet rs = stt.executeQuery(SQL)){
			while (rs.next()) {
				System.out.println(rs.getString(3));				
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
		}
	}

}
