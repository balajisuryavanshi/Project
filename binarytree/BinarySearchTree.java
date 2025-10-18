package com.binarytree;

import java.util.Scanner;

class treeNode {
	int data;
	treeNode left,right;
	
	public treeNode(int data) {
		this.data=data;
		left = right = null;
	}
}
public class BinarySearchTree {
treeNode root;
	
	void insert(int data) {
		root = insertRec(root,data);
	}

	private treeNode insertRec(treeNode root, int data) {
		if(root == null) {
			root = new treeNode(data);
			return root;
		}
		if(data < root.data) 
			root.left = insertRec(root.left,data);
		else if(data > root.data)
			root.right = insertRec(root.right,data);
		return root;
	}
	boolean search(int key) {
		return searchRec(root,key);
	}

	private boolean searchRec(treeNode root, int key) {
		if(root == null)
			return false;
		if(root.data == key)
			return true;
		return key < root.data ? searchRec(root.left,key) : searchRec(root.right,key);
	}
	void delete(int key) {
		root = deleteRec(root,key);
	}

	private treeNode deleteRec(treeNode root, int key) {
		if(root == null)
			return root;
		if(key <root.data)
			root.left = deleteRec(root.left,key);
		else if(key > root.data)
			root.right = deleteRec(root.right,key);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			root.data = minValue(root.right);
			root.right = deleteRec(root.right,root.data);
		}
		return root;
	}

	private int minValue(treeNode root) {
		int minv = root.data;
		while(root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}
	void inorder() {
		System.out.println("In-Order Traversal : ");
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(treeNode root) {
		if(root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}
	void preorder() {
		System.out.println("Pre-Order Traversal : ");
		preorderRec(root);
		System.out.println();
	}

	private void preorderRec(treeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}
	void postorder() {
		System.out.println("post-Order Traversal : ");
		postorderRec(root);
		System.out.println();
	}

	private void postorderRec(treeNode root) {
		if(root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		
		while(true) {
			System.out.println("\n Binary Search Tree");
			System.out.println("1.Insert");
			System.out.println("2.Delete");
			System.out.println("3.Search");
			System.out.println("4.In-order Traversal");
			System.out.println("5.Pre-order Traversal");
			System.out.println("6.Post-order Traversal");
			System.out.println("7.Exit");
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Value to insert : ");
				int val = sc.nextInt();
				bst.insert(val);
				System.out.println(val +" inserted sucessfully.");
				break;
				
			case 2:
				System.out.println("Enter Value to delete : ");
				int del = sc.nextInt();
				bst.delete(del);
				System.out.println(del +" deleted sucessfully.");
				break;
				
			case 3:
				System.out.println("Enter Value to search : ");
				int key = sc.nextInt();
				System.out.println(bst.search(key) ? key + " found in the tree." : key + " not found.");
				break;
			
			case 4:
				bst.inorder();
				break;
				
			case 5:
				bst.preorder();
				break;
				
			case 6:
				bst.postorder();
				break;
				
			case 7:
				System.out.println("Exiting...");
				sc.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice. ! Try Again.");
			}
		}
				
	}
}
