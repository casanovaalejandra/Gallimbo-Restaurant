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

			int count = 0;
			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {
				waitingLine.add(inputCustomers.remove(0));
				count++;
			}
			if(count > 0) {
				mergeSortByShortestJob(waitingLine);
			}
			if(processCustomer == null && !waitingLine.isEmpty()){
				processCustomer = waitingLine.remove(0);
			}

			time++;
		}

	}
	
	public void mergeSortByShortestJob(ArrayIndexList<Customer> arr) {
		Customer[] temp = new Customer[arr.size()];
		mergeSortByShortestJob(arr, temp, 0, arr.size()-1);
	}
	
	public void mergeSortByShortestJob(ArrayIndexList<Customer> arr, Customer[] temp, int left, int right){
		if (left<right) {
			int center = (left + right)/2;
			mergeSortByShortestJob(arr,temp,left,center);
			mergeSortByShortestJob(arr, temp, center+1, right);
			merge(arr, temp, left, center+1,right);
		}
	}
	
	public void merge(ArrayIndexList<Customer> arr, Customer[] temp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left; 
		int num = rightEnd - left + 1;
		
		while(left <= leftEnd && right <= rightEnd){
			if(compareJobs(arr.get(left),arr.get(right)) >= 0){
				temp[k++] = arr.get(left++);
			}
			else {
				temp[k++] = arr.get(right++);
			}
		}
		
		while(left <= leftEnd) {
			temp[k++] = arr.get(left++);
		}
		
		while(right <= rightEnd) {
			temp[k++] = arr.get(right++);
		}
		
		for(int i = 0; i < num; i++, rightEnd--) {
			arr.set(rightEnd,temp[rightEnd]);
		}
			
	}
	
	public int compareJobs(Customer a, Customer b){
		if(a.getTimeToPrepare() < b.getTimeToPrepare()){return 1;}
		else if(a.getTimeToPrepare() > b.getTimeToPrepare()) {return -1;}
		else{return 0;}
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
