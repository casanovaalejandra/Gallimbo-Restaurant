import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Customer {
	private int arrivalTime;
	private int ID;
	private int timeToPrepare;
	private double costOfOrder;
	private int levelOfPatience;
	private Customer[] customers;
	private int INITCAP = 100;

	public Customer(int arr, int ID, int TTprep, double cost,int levelP ) {
		arrivalTime=arr;
		this.ID=ID;
		timeToPrepare=TTprep;
		costOfOrder=cost;
		levelOfPatience=levelP;
		customers = new Customer[INITCAP];
	}

	public int getLevelOfPatience() {
		return levelOfPatience;
	}
	public void setLevelOfPatience(int levelOfPatience) {
		this.levelOfPatience = levelOfPatience;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTimeToPrepare() {
		return timeToPrepare;
	}
	public void setTimeToPrepare(int timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}
	public double getCostOfOrder() {
		return costOfOrder;
	}
	public void setCostOfOrder(double costOfOrder) {
		this.costOfOrder = costOfOrder;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void changeCapacity(Customer[] custmers) {
		int initialCapacity = custmers.length;
	
		Customer[] newArrayOfCustomers = new Customer[initialCapacity*2];
	
		if(customers[initialCapacity-1]!=null) {
			for(int i =0;i<=initialCapacity;i++) {
				newArrayOfCustomers[i]=customers[i];
			}
			customers= newArrayOfCustomers;
		}
		else {
			Customer[] arrayOfCustomers2 = new Customer[initialCapacity/2];
			for(int i=0;i<=initialCapacity;i++) {
				arrayOfCustomers2[i] = customers[i];
			}
			customers=arrayOfCustomers2;
		}
	}

}
