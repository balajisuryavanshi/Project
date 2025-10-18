package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {
	public void addBook(String title,String author) {
		String sql = "insert into book(title,author) values(?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, title);
			ps.setString(2, author);
			ps.executeUpdate();
			System.out.println("Book Added Sucessfully");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void viewBooks() {
		String sql = "select * from book";
		try(Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while(rs.next()) {
				System.out.println(rs.getInt("book_id")+" | "+rs.getString("title")+" | "+
			rs.getString("author")+" | "+(rs.getBoolean("available") ? "Available" : "Borrowed"));	
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateBookAvailable(int bookID,boolean available) {
		String sql = "update book set available = ? where book_id = ?";
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setBoolean(1, available);
				ps.setInt(2, bookID);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
