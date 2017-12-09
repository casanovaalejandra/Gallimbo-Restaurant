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
<<<<<<< HEAD
		File file = new File("input4.csv");
=======
		File file = new File("inputExample.csv");
>>>>>>> branch 'master' of https://github.com/casanovaalejandra/Gallimbo-Restaurant.git
		gallimbo.readFile(file);


	//	PatApproach pat = new PatApproach(gallimbo.getListOfCustomers());
		//pat.processCustomers();

	//	MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
	//	mat.proccesOrders();


	//	MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
	//	max.processCustomers();

		PacApproach pac = new PacApproach(gallimbo.getListOfCustomers());
		pac.processOrder();
		System.out.println("Pac approach disappointed customers: " + pac.getNumberOfDisappointedCustomers());
		System.out.printf("Pac approach profit: $%.2f", pac.getProfit());
		
<<<<<<< HEAD
		//MatApproach<Customer> mat = new MatApproach<Customer>(gallimbo.getListOfCustomers());
		//mat.proccesOrders();
		
		MaxApproach max = new MaxApproach(gallimbo.getListOfCustomers());
		//max.processCustomers();
		
		System.out.printf("Pat's approach profit: $%.2f\n", pat.getProfit());
		System.out.println("Pat's approach number of disappointed customers: " + pat.getNumberOfDisappointedCustomers());
		
//		System.out.println("Max approach disappointed customers: " + max.getNumberOfDisappointedCustomers());
//		System.out.printf("Max approach profit: $%.2f", max.getProfit());
	}
=======
	//	System.out.println("Pat approach disappointed customers: " + pat.getNumberOfDisappointedCustomers());
	//	System.out.printf("Pat approach profit: $%.2f", pat.getProfit());

	//	System.out.println("Max approach disappointed customers: " + max.getNumberOfDisappointedCustomers());
	//	System.out.printf("Max approach profit: $%.2f", max.getProfit());

//		System.out.println("Mat approach dissapointed customers: " + mat.getNumberOfDissapointedCustomers());
//		System.out.println("Mat approach profit: " + mat.getProfit());
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
