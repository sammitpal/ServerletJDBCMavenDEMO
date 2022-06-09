package com.sammit.dao;

import com.sammit.model.Student;
import java.sql.*;

public class StudentDao {

	private String url = "jdbc:mysql://localhost/student";
	private String username = "root";
	private String password = "";
	
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	public Student getStudent(int id) {
		Student s = new Student();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			st = con.createStatement();
			
			String sql = "select * from student_details where id = "+id;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				s.setId(rs.getInt("id"));
				s.setFirst_name(rs.getString("first_name"));
				s.setLast_name(rs.getString("last_name"));
				s.setEmail(rs.getString("email"));
				
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occured");
		}

		return s;
	}

}
