package com.empmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class employee {
	private int id;
	private String name;
	private double sal;

	public employee(int id, String name, double sal) {
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	// Getter Setter
	public int getID() {
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName() {
		return name; 
	}
    public void setName(String name) {
    	this.name = name; 
    }
    public double getSal() {
    	return sal; 
    }
    public void setSalary(double sal) {
    	this.sal = sal; 
    }

    public void displayEmployee() {
        System.out.println("ID: " + id + " | Name: " + name + " | Salary: " + sal);
    }
}

class employeeManager {
	private ArrayList<employee> emp = new ArrayList<>();
	
	public void addEmployee(employee emp1){
		emp.add(emp1);
		System.out.println("employee added sucessfully.");
	}
	public void viewAllEmployee() {
		if(emp.isEmpty()) {
			System.out.println("Empty of Employee.");
		} else {
			System.out.println("list of employee");
			for(employee emp1 : emp) {
				emp1.displayEmployee();
			}
		}
	}
	public void updateEmployee(int id,String NewName,double newSal) {
		boolean found = false;
		for(employee emp1 : emp) {
			if(emp1.getID() == id) {
				emp1.setName(NewName);
				emp1.setSalary(newSal);
				
				System.out.println("employee updated sucessfully!!");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("employee id " + id +" not found");
		}
	}
	public void deleteEmployee(int id) {
		Iterator<employee> iterator = emp.iterator();
		boolean found = false;
		while(iterator.hasNext()) {
			employee emp1 = iterator.next();
			if(emp1.getID() == id) {
				iterator.remove();
				System.out.println("delete employee details!!");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("employee id " + id + "not found");
		}
	}
}

public class employeeManagementSystem {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		employeeManager manager = new employeeManager();
		int choice;
		
		do {
			 System.out.println("\n=== Employee Management System ===");
	            System.out.println("\n 1. Add Employee ");
	            System.out.println("2. View All Employees");
	            System.out.println("3. Update Employee");
	            System.out.println("4. Delete Employee");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            while(!sc.hasNextInt()) {
	            	System.out.println("Please enter valid data");
	            	sc.next();
	            }
	            choice = sc.nextInt();
	            
	            switch(choice) {
	            case 1:
	            	System.out.println("enter employee id :");
	            	int id = sc.nextInt();
	            	sc.nextLine();
	            	System.out.println("enter employee name :");
	            	String name = sc.nextLine();
	            	System.out.println("enter employee salary :");
	            	double sal = sc.nextDouble();
	            	manager.addEmployee(new employee(id,name,sal));
	            	break;
	            	
	            case 2:
	            	manager.viewAllEmployee();
	            	break;
	            	
	            case 3:
	            	System.out.println("enter new employee id :");
	            	int newId = sc.nextInt();
	            	sc.nextLine();
	            	System.out.println("enter new employee name :");
	            	String newName = sc.nextLine();
	            	System.out.println("enter new employee salary :");
	            	double newSal = sc.nextDouble();
	            	manager.updateEmployee(newId, newName, newSal);
	            	break;
	            	
	            case 4:
	            	System.out.println("enter employee id to delete :");
	            	int deleteId = sc.nextInt();
	            	manager.deleteEmployee(deleteId);
	            	break;
	            	
	            case 5:
	            	System.out.println("exiting...Thank You!!");
	            	break;
	            	
	            default:
	            	System.out.println("Invalaid choice!!");
	            }
	            
		}while (choice != 5);
		sc.close();
	}
}
