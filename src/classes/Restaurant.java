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
		File file = new File("inputExample.csv");
		gallimbo.readFile(file);
		
//		PatApproach<Customer> pat = new PatApproach<Customer>(gallimbo.getListOfCustomers());
//		pat.processCustomer();
//		
//		System.out.println("Pat approach disappointed customers: " + pat.getNumberOfDisappointedCustomers());
//		System.out.printf("Pat approach profit: $%.2f", pat.getProfit());
		MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
		mat.proccesOrders();
		System.out.println("Pat approach disappointed customers: " + mat.getNumberOfDissapointedCustomers());
		System.out.printf("Pat approach profit: $%.2f", mat.getProfit());
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
