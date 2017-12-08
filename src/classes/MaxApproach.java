package classes;

import tools.ArrayIndexList;
import tools.SLLQueue;

public class MaxApproach {
	private int time;
	private int orderNumber = 0;
	private double profit = 0;
	private int numberOfDisappointedCustomers = 0;
	ArrayIndexList<Customer> inputCustomers;
	Customer processCustomer;
	ArrayIndexList<Customer> waitingLine = new ArrayIndexList<Customer>();

	public MaxApproach(ArrayIndexList<Customer> inputCustomers) {
		this.inputCustomers  = inputCustomers;
	}

	public void processCustomers() {
		time=0;
		while(!inputCustomers.isEmpty() || processCustomer != null) {
			System.out.println("Time: " + time);
			if(processCustomer != null) {
				processCustomer.setTimeToPrepare(processCustomer.getTimeToPrepare()-1);
				System.out.println("Remaining time to prepare order: " + processCustomer.getTimeToPrepare());

				if(processCustomer.getTimeToPrepare()==0) {
					orderNumber++;
					profit+=processCustomer.getCostOfOrder();
					System.out.println("Order " + orderNumber+  " finished!\n");
					processCustomer = null;

					while(!waitingLine.isEmpty() && time - waitingLine.get(0).getArrivalTime()> waitingLine.get(0).getLevelOfPatience()) {
						orderNumber++;
						waitingLine.remove(0);	
						numberOfDisappointedCustomers++;
						System.out.println("Order " + orderNumber + " dissapointed\n");
					}
				}

			}
			
			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {
				waitingLine.add(inputCustomers.remove(0));
			}
			
			if(!waitingLine.isEmpty()){
				waitingLine = sortByProfit(waitingLine);
			}
			if(processCustomer == null && !waitingLine.isEmpty()){
				processCustomer = waitingLine.remove(0);
			}
			
			time++;
		}
	}
	
	//a binary sort for organizing waiting customers in order by profit. 
	public ArrayIndexList<Customer> sortByProfit(ArrayIndexList<Customer> arr) {
		ArrayIndexList<Customer> organizedCustomers = arr;
		if(arr.size() == 1){
			return arr;
		}
		for(int i = 0; i<arr.size();i++) {
			Customer temp;
			for(int j = i+1; j<arr.size(); j++) {
				if(arr.get(j).getCostOfOrder() > arr.get(i).getCostOfOrder()){
					temp = arr.get(j);
					arr.set(j, arr.get(i));
					arr.set(i,temp);
			}
			
			}
		}
		return organizedCustomers;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getNumberOfDisappointedCustomers() {
		return numberOfDisappointedCustomers;
	}

	public void setNumberOfDisappointedCustomers(int numberOfDisappointedCustomers) {
		this.numberOfDisappointedCustomers = numberOfDisappointedCustomers;
	}
}
