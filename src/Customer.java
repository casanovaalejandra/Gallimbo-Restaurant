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

	public Customer() {
		arrivalTime=0;
		ID=0;
		timeToPrepare=0;
		costOfOrder=0;
		levelOfPatience=0;
		customers = new Customer[INITCAP];

	}

	//public void readFile(File file) {
//		try {
//			in = new Scanner(file);
//
//			while(in.hasNext()) {
//				doneJobs++;
//				String data = in.nextLine();
//				String[] jobs = data.split(",");
//				int arrivalTime = Integer.parseInt(jobs[0]);
//				int serviceTime = Integer.parseInt(jobs[1]);
//				Job theCurrentJob = new Job(arrivalTime,serviceTime,doneJobs);
//				inputQueue.enqueue(theCurrentJob);
//			}	
//			in.close();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

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
