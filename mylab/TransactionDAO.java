package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {
	public void borrowBook(int user_id,int book_id) {
		String borrowsql = "insert into transactions(user_id,book_id,action) values(?,?,'borrow')";
		String updateBookSQL = "update book set available = false where book_id = ?";
		
		try( Connection con = DBConnection.getConnection();
				PreparedStatement ps1 = con.prepareStatement(borrowsql);
				PreparedStatement ps2 = con.prepareStatement(updateBookSQL)) {
			
			ps1.setInt(1, user_id);
			ps1.setInt(2, book_id);
			ps1.executeUpdate();
			
			ps2.setInt(1, book_id);
			ps2.executeUpdate();
			System.out.println("Book Borrow Sucessfully.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void returnBook(int book_id) {
		String returnSQL = "update transactions set return_date =now() where book_id = ? and return_date IS null";
		String updateBookSQL = "update book set available = true where book_id = ?";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps1 = con.prepareStatement(returnSQL);
				PreparedStatement ps2 = con.prepareStatement(updateBookSQL)) {
			
			ps1.setInt(1, book_id);
			ps1.executeUpdate();
			
			ps2.setInt(1, book_id);
			ps2.executeUpdate();
			
			System.out.println("Book Return Sucessfully.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
