package org.com.java.sorting;




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Qsort {

	public void quickSort(double arrayOfElements[], int start, int end) {

		if (start < end) { //exit statement when we reach to sort only 1 element

			int pIndex = partition(arrayOfElements, start, end); // calling the partition function select the partition index.
			quickSort(arrayOfElements, start, pIndex - 1); //recursively calling quick sort to sort elements less than partition index
			quickSort(arrayOfElements, pIndex + 1, end); //recursively calling quick sort to sort elements greater than partition index
		}

	}

	public int partition(double arrayOfElements[], int start, int end) {

		double pivot = arrayOfElements[end]; //we select the pivot as the last element of the array for each iteration

		int partitionIndex = start;
		for (int i = start; i < end; i++) {

			if (arrayOfElements[i] <= pivot) { // if element is less than pivot we swap such that we have all elements less than 
													//pivot to the start of the array and greater than pivot to the end of the array
				double temp = arrayOfElements[i];
				arrayOfElements[i] = arrayOfElements[partitionIndex];
				arrayOfElements[partitionIndex] = temp;

				partitionIndex++; // going to next element

			}
		}
		//swapping the partition index and the pivot to get the correct partition index in its proper place
		double temp1 = arrayOfElements[end];
		arrayOfElements[end] = arrayOfElements[partitionIndex];
		arrayOfElements[partitionIndex] = temp1;

		return partitionIndex;
	}

	private static double[] readFiles(String file) {
		String input = "";

		double[] doubleValues = null;

		try (Scanner sc = new Scanner(new File(file))) {

			while (sc.hasNextLine()) { //to scan each line
				input = input + sc.next(); //append the input string and gather input in one string
				String[] split = input.split("\\s*;\\s*");
				// using the split function to seperate the elements from the ';'
				doubleValues = new double[split.length];

				for (int i = 0; i < split.length; i++) {
					doubleValues[i] = Double.parseDouble(split[i]); // converting the string values to integer and
					// assigning it to new array

				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return doubleValues; // returning array of integers to be sorted.
	}

	public static void main(String args[]) throws IOException {

		double[] inputData = readFiles(args[0]);

		// calling the readfiles fuction to read the input file and return array of int
		Qsort sort = new Qsort(); // creating object of class Isort.

		int n = inputData.length;
		long starttime = System.currentTimeMillis();// time before the quick sort algorithm starts
		sort.quickSort(inputData, 0, n - 1); // running the insertion sort on the input data
		long stoptime = System.currentTimeMillis(); // time just after the algorithm is complete.

		long time = stoptime - starttime;
		System.out.println(time);

		System.out.println("The elements after applying quick sort are in the answer file");

		File file = new File("answer.txt"); // creating new answer.txt file
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("The sorting result is: \n" + args[0] + " sorted ");

		for (int i = 0; i < inputData.length; i++) // writing to the text file
			printWriter.print(inputData[i] + "; "); // using the constants class

		printWriter.print("\n Performance: \n" + "\n analysis: Input file              Sorting time (in milliseconds)");
		printWriter.print("\n    " + args[0] + "                           " + time);

		printWriter.close();

	}
}
