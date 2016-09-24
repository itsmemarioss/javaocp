package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:derby:test;create=true");
		con = DriverManager.getConnection("jdbc:postgresql://localhost/el_tenant_per_table","postgres","postgres");
		return con;
	}

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection con = getConnection();
		System.out.println(con);
		
		Statement stt = con.createStatement();
		//stt.executeUpdate("insert into employee values (-1,'100','angiosperma')");
		
		ResultSet rs = stt.executeQuery("select version()");
		
		//can run either a query or an update 
		//returns boolean if there is a ResultSet
		boolean isResultSet = stt.execute("");
		if (isResultSet) {
			rs = stt.getResultSet();
		}else {
			int count = stt.getUpdateCount();
		}
		
		// in real life you should use PreparedStatement
		PreparedStatement ps = con.prepareStatement("delete from employee where nome =?");
		ps.setString(1, "joao do caminhao");
		
		
	}

}
