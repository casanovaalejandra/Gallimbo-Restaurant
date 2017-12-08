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
		File file = new File("input0.csv");
		gallimbo.readFile(file);
		

		PatApproach pat = new PatApproach(gallimbo.getListOfCustomers());
		pat.processCustomers();
		
		//MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
		//mat.proccesOrders();
		
<<<<<<< HEAD
//		MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
//		max.processCustomers();
=======
		MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
		//max.processCustomers();
>>>>>>> branch 'master' of https://github.com/casanovaalejandra/Gallimbo-Restaurant.git
		
		System.out.println("Pat approach disappointed customers: " + pat.getNumberOfDisappointedCustomers());
		System.out.printf("Pat approach profit: $%.2f", pat.getProfit());
		
//		System.out.println("Max approach disappointed customers: " + max.getNumberOfDisappointedCustomers());
//		System.out.printf("Max approach profit: $%.2f", max.getProfit());
<<<<<<< HEAD
		
		System.out.println("Mat approach dissapointed customers: " + mat.getNumberOfDissapointedCustomers());
		System.out.println("Mat approach profit: " + mat.getProfit());
=======
>>>>>>> branch 'master' of https://github.com/casanovaalejandra/Gallimbo-Restaurant.git
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
