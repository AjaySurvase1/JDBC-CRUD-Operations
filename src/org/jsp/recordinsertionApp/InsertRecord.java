package org.jsp.recordinsertionApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub

		Connection con=null;
		Statement stmt=null;
		String qry1="insert into btm.student values(3,'Poonam','Finance',45.5)";
		String qry2="insert into btm.student values(6,'Ravindra','Account',76.3)";
		String qry3="insert into btm.student values(7,'Ajay','IT',68.9)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load and registered driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");//established connection between java app & db server
			stmt=con.createStatement();//platform created
			stmt.executeUpdate(qry1);//query insertion
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("Records inserted!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
