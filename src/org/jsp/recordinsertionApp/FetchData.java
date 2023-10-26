package org.jsp.recordinsertionApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchData {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement("select * from btm.student");
			//Execute
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String nm=rs.getString("name");
				String dp=rs.getString("dept");
				double pr=rs.getDouble("perc");
				
				System.out.print(id +" ");
				System.out.print(nm +" ");
				System.out.print(dp +" ");
				System.out.print(pr +" ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
