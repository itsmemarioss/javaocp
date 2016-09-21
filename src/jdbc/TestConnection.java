package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection con = DriverManager.getConnection("jdbc:derby:test;create=true");
		System.out.println(con);
	}

}
