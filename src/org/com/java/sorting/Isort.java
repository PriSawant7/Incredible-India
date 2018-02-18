package org.com.java.sorting; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Isort {

	public void insertionSort(int inputData[], int size) {
		for (int i = 1; i <= size - 1; i++) {
			int value = inputData[i]; //storing the value to be compared with
			int tempValueHolder = i; 
			while (tempValueHolder > 0 && inputData[tempValueHolder - 1] > value) {  //performing the insertion sort
				inputData[tempValueHolder] = inputData[tempValueHolder - 1];
				tempValueHolder = tempValueHolder - 1;
			}
			inputData[tempValueHolder] = value;
		}
	}

	private static int[] readFiles(String file) {

		String input;

		int[] intValues = null;
				try (FileReader fileReader = new FileReader(file);    // using try with resources
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {

			input = bufferedReader.readLine();
			String[] split = input.split("\\s*;\\s*"); //using the split function to seperate the integers from the ;
			intValues = new int[split.length]; 
			
			for (int i = 0; i < split.length; i++) {
				intValues[i] = Integer.parseInt(split[i]); // converting the string values to integer and 
															//assigning it to new array

			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return intValues; //returning array of integers to be sorted.
	}

	public static void main(String args[]) throws IOException {
		
		int[] inputData = readFiles(args[0]); //calling the readfiles fuction to read the input file and return array of int
		Isort sort = new Isort(); //creating object of class Isort.
		int n = inputData.length;
		sort.insertionSort(inputData, n); //running the insertion sort on the input data
		System.out.println("The emements after applying insertion sort are in the answer file");
		
		File file = new File("answer.txt"); //creating new answer.txt file
		FileWriter fileWriter = new FileWriter(file); 
		PrintWriter printWriter = new PrintWriter(fileWriter); 
		

		for (int i = 0; i < inputData.length; i++)   //writing to the text file
			printWriter.print(inputData[i] + "; "); //using the constants class
			printWriter.close();

	}

}
