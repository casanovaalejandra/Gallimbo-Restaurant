package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.ArrayIndexList;

public class Restaurant {
	private int numCustomers = 0;
	private ArrayIndexList<Customer> listOfCustomers = new ArrayIndexList<Customer>();
	
	public Restaurant() {
		
	}
	
	public static void main(String[] args) {
		Restaurant gallimbo = new Restaurant();
		File file = new File("another.csv");
		gallimbo.readFile(file);
		
		PatApproach<Customer> pat = new PatApproach<Customer>(gallimbo.getListOfCustomers());
		pat.processCustomer();
		
		System.out.println("Pat approach disappointed customers: " + pat.getNumberOfDisappointedCustomers());
		System.out.println("Pat approach profit: $" + pat.getProfit());
	}

	public void readFile(File file) {
		try {
			Scanner in = new Scanner(file);

			while(in.hasNext()) {
				numCustomers++;
				String data = in.nextLine();
				String[] separatedData = data.split(",");
				separatedData[3] = separatedData[3].substring(1, separatedData[3].length()-1);
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
