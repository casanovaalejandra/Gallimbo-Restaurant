package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.ArrayIndexList;

public class Restaurant {
	private int numCustomers = 0;
	private ArrayIndexList<Customer> listOfCustomers = new ArrayIndexList<Customer>();

	public void readFile(File file) {
		try {
			Scanner in = new Scanner(file);

			while(in.hasNext()) {
				numCustomers++;
				String data = in.nextLine();
				String[] separatedData = data.split(",");
				Customer currentCustomer = new Customer(Integer.parseInt(separatedData[0]),Integer.parseInt(separatedData[1]),
						Integer.parseInt(separatedData[2]), Integer.parseInt(separatedData[3]),Integer.parseInt(separatedData[4])) ;
				listOfCustomers.add(currentCustomer);
			}	
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
