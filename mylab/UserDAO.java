package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	public void addUser(String name,String email) {
		String sql = "insert into user(name,email) values(?,?)";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, email);
			ps.executeUpdate();
			System.out.println("User Add Sucessfully.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void viewUsers() {
		String sql = "select * from user";
		try(Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while(rs.next()) {
				System.out.println(rs.getInt("user_id")+" | "+rs.getString("name")+" | "+rs.getString("email"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
