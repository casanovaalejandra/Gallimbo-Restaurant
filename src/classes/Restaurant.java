package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import tools.ArrayIndexList;

public class Restaurant {
	private ArrayIndexList<Customer> listOfCustomers = new ArrayIndexList<Customer>();
	private static double maxProfit = 0;
	private static int maxCustomersServed = 0;

	public Restaurant() {

	}

	public static void main(String[] args) {
		Restaurant gallimbo = new Restaurant();
		File file = new File("input7.csv");
		
		gallimbo.readFile(file);
		PatApproach pat = new PatApproach(gallimbo.getListOfCustomers());
		pat.processCustomers();	
		
		gallimbo.readFile(file);
		MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
		mat.proccesOrders();
		
		gallimbo.readFile(file);
		MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
		max.processCustomers();	
		
		gallimbo.readFile(file);
		PacApproach pac = new PacApproach(gallimbo.getListOfCustomers());
		pac.processOrder();
		//      System.out.printf("Pat's approach profit: $%.2f\n", pat.getProfit());
		//      System.out.println("Pat's approach number of disappointed customers: " + pat.getNumberOfDisappointedCustomers());

		//      System.out.printf("Mat's approach profit: $%.2f\n", mat.getProfit());
		//      System.out.println("Mat's approach number of disappointed customers: " + mat.getNumberOfDissapointedCustomers());

		//		System.out.println("Max approach disappointed customers: " + max.getNumberOfDisappointedCustomers());
		//		System.out.printf("Max approach profit: $%.2f", max.getProfit());

		//		System.out.println("Pac approach disappointed customers: " + pac.getNumberOfDisappointedCustomers());
		//		System.out.printf("Pac approach profit: $%.2f", pac.getProfit());
		String fileName = "input7.out";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

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

	public static double getMaxProfit() {
		return maxProfit/4;
	}

	public void setMaxProfit(double maxProfit) {
		this.maxProfit = maxProfit;
	}

	public static int getMaxCustomersServed() {
		return maxCustomersServed/4;
	}

	public void setMaxCustomersServed(int maxCustomersServed) {
		this.maxCustomersServed = maxCustomersServed;
	}

	public ArrayIndexList<Customer> getListOfCustomers(){
		return listOfCustomers;
	}
}
