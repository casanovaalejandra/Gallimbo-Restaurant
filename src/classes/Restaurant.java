/**********************************************************************************************************
 	Authors: Jose A. Melendez Moreles and Alejandra Casanova Sepulveda
  	Course: ICOM4035
  	University of Puerto Rico at Mayaguez
  	Fall Semester 2017
  	Sec:110

  	Review: This project simulates a restaurant which is going to be run by 4 approaches:
  		1)	Pat suggested serving customers based on their arrival time, 
  			(i.e., selecting the customer who arrives earliest). He argued 
  			that this is a fair way of doing it. This approach is usually 
  			referred to as First-Come-First-Served (FCFS).
		2)	Mat thinks that it will be easier to just select the last person 
			who arrives. This approach is usually referred to as Last-Come-First-Served (LCFS).
		3)	Max only thinks about money, so he suggested selecting the customer
		 	who can bring the highest profit. This approach is usually referred
		  	to as Max-Profit-First (MPF). 
		4)	Pac thinks food should come fast, so he suggested selecting
		 	the customer whom can be served in the shortest time. This approach 
		 	is usually referred to as Shortest-Job-First (SJF). 
 *
 ***********************************************************************************************************/
package classes;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import tools.ArrayIndexList;

public class Restaurant {
	private ArrayIndexList<Customer> listOfCustomers = new ArrayIndexList<Customer>();
	private static int maxCustomersServed;
	private static double maxProfit;

	public Restaurant() {

	}

	public static void main(String[] args) {

		Restaurant gallimbo = new Restaurant();

		File fileText = new File(System.getProperty("user.dir")+ "/input.txt");

		ArrayIndexList<File> theFiles = new ArrayIndexList<File>();

		try {
			Scanner in = new Scanner(fileText);
			while(in.hasNextLine()) {

				String filename = in.nextLine();
				File newFile = new File(filename);
				theFiles.add(newFile);

			}
			for(int i =0;i<theFiles.size();i++) {
				//System.out.println(theFiles.get(i).toString());
			}

		}catch (FileNotFoundException e) {
			e.printStackTrace();{

			}
		}

		for(int i =0; i<theFiles.size();i++) {
			System.out.println(theFiles.size());
			gallimbo.readFile(theFiles.get(i));
			PatApproach pat = new PatApproach(gallimbo.getListOfCustomers());
			pat.processCustomers();	

			gallimbo.readFile(theFiles.get(i));
			MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
			mat.proccesOrders();

			gallimbo.readFile(theFiles.get(i));
			MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
			max.processCustomers();	

			gallimbo.readFile(theFiles.get(i));
			PacApproach pac = new PacApproach(gallimbo.getListOfCustomers());
			pac.processOrder();

			System.out.println("Pac approach eneded\n");

			//Real hasta la muerte
			try {
				String fileName = theFiles.get(i).getName();
				String baseName = fileName.substring(0, fileName.length()-4);
				String outputName = baseName + ".out";
				PrintWriter outputStream = new PrintWriter(outputName);
				outputStream.printf("Maximum profit possible: $%.2f", getMaxProfit());
				outputStream.println("");
				outputStream.println("Maximum number of customers served possible: " + getMaxCustomersServed());
				outputStream.printf("Pat's approach profit: $%.2f", pat.getProfit());
				outputStream.println("");
				outputStream.println("Pat's approach number of disappointed customers: " + pat.getNumberOfDisappointedCustomers());
				outputStream.printf("Mat's approach profit: $%.2f\n", mat.getProfit());
				outputStream.println("");
				outputStream.println("Mat's approach number of disappointed customers: " + mat.getNumberOfDissapointedCustomers());
				outputStream.printf("Max's approach profit: $%.2f\n", max.getProfit());
				outputStream.println("");
				outputStream.println("Max's approach number of disappointed customers: " + max.getNumberOfDisappointedCustomers());
				outputStream.printf("Pac's approach profit: $%.2f\n", pac.getProfit());
				outputStream.println("");
				outputStream.println("Pac's approach number of disappointed customers: " + pac.getNumberOfDisappointedCustomers());
				outputStream.close();
				System.out.println("Done");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			maxCustomersServed = 0;
			maxProfit = 0;
		}
	}

	/**
	 * 
	 * @param file: File that contains the data to be processed 
	 */
	public void readFile(File file) {
		try {
			Scanner in = new Scanner(file);

			while(in.hasNext()) {
				maxCustomersServed++;
				String data = in.nextLine();
				String[] separatedData = data.split(",");
				separatedData[3] = separatedData[3].substring(1, separatedData[3].length());
				Customer currentCustomer = new Customer(Integer.parseInt(separatedData[0]),Integer.parseInt(separatedData[1]),
						Integer.parseInt(separatedData[2]), 
						Double.parseDouble(separatedData[3]),
						Integer.parseInt(separatedData[4])) ;
				listOfCustomers.add(currentCustomer);
				maxProfit+= currentCustomer.getCostOfOrder();
			}	
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return the maxProfit
	 */
	public static double getMaxProfit() {
		return maxProfit/4;
	}

	/**
	 * 
	 * @return the Maximum of customers that have been attended
	 */
	public static int getMaxCustomersServed() {
		return maxCustomersServed/4;
	}
	/**
	 * 
	 * @return the array index list that contains the customers read from the file
	 */

	public ArrayIndexList<Customer> getListOfCustomers(){
		return listOfCustomers;
	}
}
