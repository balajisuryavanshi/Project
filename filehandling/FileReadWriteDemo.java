package com.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWriteDemo {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("File Handling : Read & Write");
		System.out.println("Enter input file name(e.g.input.txt) : ");
		String inputFile = sc.nextLine();
		
		System.out.println("Enter output file name(e.g.output.txt) : ");
		String outputFile = sc.nextLine();
		
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line;
			
			while((line = reader.readLine()) !=null) {
				lineCount++;
				charCount += line.length();
				
				String[] words = line.trim().split("\\s+");
				if(!line.trim().isEmpty()) {
					wordCount += words.length;
				}
			}
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write("File Processing Result :\n");
			writer.write("Number of line :"+lineCount +"\n");
			writer.write("Number of Words :"+ wordCount +"\n");
			writer.write("Number of Characters :" +charCount +"\n");
			writer.close();
			
			System.out.println("Data processed sucessfully!");
			System.out.println("Lines counted : "+lineCount);
			System.out.println("Words counted : "+wordCount);
			System.out.println("Characteres counted : "+charCount);
			System.out.println("Result Writen to : " +outputFile);
			
		} catch(FileNotFoundException e) {
			System.out.println("Error : Input file not found!");
		} catch(IOException e) {
			System.out.println("error : an i/o error occurred while processing the file.");
		} finally {
			System.out.println("Program End");
			sc.close();
		}
	}

}
