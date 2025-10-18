package com.mylab;

import java.util.Scanner;

public class LibraryManagementSystem {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();
        TransactionDAO transDAO = new TransactionDAO();

        while (true) {
            System.out.println("\n Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. View Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    bookDAO.addBook(title, author);
                    break;
                case 2:
                    bookDAO.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    userDAO.addUser(name, email);
                    break;
                case 4:
                    userDAO.viewUsers();
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    transDAO.borrowBook(userId, bookId);
                    break;
                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = sc.nextInt();
                    transDAO.returnBook(returnBookId);
                    break;
                case 7:
                    System.out.println("Exiting System...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
	}
}
