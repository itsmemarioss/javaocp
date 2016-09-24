package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingResultSet {
	
	public static final String SQL = "select * from employee";

	public static void main(String[] args) throws SQLException {
		Connection con = TestConnection.getConnection();
		ResultSet rs = con.createStatement().executeQuery(SQL);
		System.out.println(rs.next());
		while (rs.next()) {
			System.out.print(rs.getObject(1)+"|");//number of columns start with 1
			System.out.print(rs.getObject(2)+"|");
			System.out.print(rs.getObject(3));
			System.out.println();
		}
		
		rs = con.createStatement().executeQuery("select count(*) from employee");
		if (rs.next()) {
			System.out.println(rs.getInt("count"));
		}
		
		//scrollable ResultSet
		Statement stt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stt.executeQuery(SQL);
		
		rs.afterLast();//move to the final position returns void
		rs.beforeFirst();//move to the start position returns void
		
		System.out.println("next: "+rs.next());
		System.out.println("previous: "+rs.previous());
		System.out.println("isBeforeFirst: "+rs.isBeforeFirst());
		System.out.println("isAfterLast: "+rs.isAfterLast());
		System.out.println("first: "+rs.first());
		System.out.println("last: "+rs.last());
		/*
		 absolute(int) Returns:
			true if the cursor is moved to a position in this ResultSet object; 
			false if the cursor is before the first row or after the last row
		*/
		System.out.println("absolute: "+rs.absolute(0));//equals to rs.beforeFirst();
		System.out.println("absolute: "+rs.absolute(1));//equals to rs.first();
		System.out.println("absolute: "+rs.absolute(1000));//does not exist 1000 rows in the table
		
		//relative(int) moves the cursor forward or backward the specified number of rows
		rs.relative(-1);//the last row because absolute(1000) will put the cursor at the end (after last)
		rs.first();
		rs.relative(2);//go to 2 rows after firs
	}

}
