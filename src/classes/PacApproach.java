package classes;

import tools.ArrayIndexList;

public class PacApproach {
	private int time;
	private double profit=0;
	private int orderedNumber=0;
	private int numberOfDisappointedCustomers;

	ArrayIndexList<Customer> inputCustomers;
	Customer processCustomer;
	ArrayIndexList<Customer> waitingLine = new ArrayIndexList<Customer>();

	public PacApproach(ArrayIndexList<Customer> theList) {
		inputCustomers = theList;
	}
	public void processOrder() {
		time=0;
		while(!inputCustomers.isEmpty() || processCustomer != null) {
			System.out.println("Time: " + time);
			if(processCustomer != null) {
				processCustomer.setTimeToPrepare(processCustomer.getTimeToPrepare()-1);
				System.out.println("Remaining time to prepare order: " + processCustomer.getTimeToPrepare());

				if(processCustomer.getTimeToPrepare()==0) {
					orderedNumber++;
					profit+=processCustomer.getCostOfOrder();
					System.out.println("Order " + orderedNumber+  " finished!\n");
					processCustomer = null;

					while(!waitingLine.isEmpty() && time - waitingLine.get(0).getArrivalTime()> waitingLine.get(0).getLevelOfPatience()) {
						orderedNumber++;
						waitingLine.remove(0);	
						numberOfDisappointedCustomers++;
						System.out.println("Order " + orderedNumber + " dissapointed\n");
					}
				}

			}

			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {
				waitingLine.add(inputCustomers.remove(0));
			}

			if(!waitingLine.isEmpty()){
				waitingLine = sortByTimeToPrepare(waitingLine);
			}
			if(processCustomer == null && !waitingLine.isEmpty()){
				processCustomer = waitingLine.remove(0);
			}

			time++;
		}

	}
	public int getNumberOfDisappointedCustomers() {
		return numberOfDisappointedCustomers;
	}
	public void setNumberOfDisappointedCustomers(int numberOfDisappointedCustomers) {
		this.numberOfDisappointedCustomers = numberOfDisappointedCustomers;
	}

	public double getProfit() {
		return profit;
	}
	// binarySort to arrange the IndexList by the short job time
	public ArrayIndexList<Customer> sortByTimeToPrepare(ArrayIndexList<Customer> arr) {
		ArrayIndexList<Customer> organizedCustomers = arr;
		if(arr.size() == 1){
			return arr;
		}
		for(int i = 0; i<arr.size();i++) {
			Customer temp;
			for(int j = i+1; j<arr.size(); j++) {
				if(arr.get(j).getTimeToPrepare() < arr.get(i).getTimeToPrepare()){
					temp = arr.get(j);
					arr.set(j, arr.get(i));
					arr.set(i,temp);
				
				}

			}
		}
		return organizedCustomers;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getOrderedNumber() {
		return orderedNumber;
	}

	public void setOrderedNumber(int orderedNumber) {
		this.orderedNumber = orderedNumber;
	}

}
