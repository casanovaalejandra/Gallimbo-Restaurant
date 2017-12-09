package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.ArrayIndexList;

public class Restaurant {
	private ArrayIndexList<Customer> listOfCustomers = new ArrayIndexList<Customer>();
	
	public Restaurant() {
		
	}
	
	public static void main(String[] args) {
		Restaurant gallimbo = new Restaurant();
		File file = new File("input4.csv");
		gallimbo.readFile(file);
		

		PatApproach pat = new PatApproach(gallimbo.getListOfCustomers());
		pat.processCustomers();
		
		//MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
		//mat.proccesOrders();
		
		MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
		//max.processCustomers();
		
		System.out.printf("Pat's approach profit: $%.2f\n", pat.getProfit());
		System.out.println("Pat's approach number of disappointed customers: " + pat.getNumberOfDisappointedCustomers());
		
//		System.out.println("Max approach disappointed customers: " + max.getNumberOfDisappointedCustomers());
//		System.out.printf("Max approach profit: $%.2f", max.getProfit());
	}
	

	public void readFile(File file) {
		try {
			Scanner in = new Scanner(file);

			while(in.hasNext()) {
				String data = in.nextLine();
				String[] separatedData = data.split(",");
				separatedData[3] = separatedData[3].substring(1, separatedData[3].length());
				Customer currentCustomer = new Customer(Integer.parseInt(separatedData[0]),Integer.parseInt(separatedData[1]),
						Integer.parseInt(separatedData[2]), 
						Double.parseDouble(separatedData[3]),
						Integer.parseInt(separatedData[4])) ;
				listOfCustomers.add(currentCustomer);
			}	
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayIndexList<Customer> getListOfCustomers(){
		return listOfCustomers;
	}
}
