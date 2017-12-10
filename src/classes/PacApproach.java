
/*
 * Alejandra Casanova
 * JoseA Melendez
 */

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

	/**
	 * 
	 * @param inputCustomers list of customers read on the file
	 */
	public PacApproach(ArrayIndexList<Customer> theList) {
		inputCustomers = theList;
	}
	
	/**
	 *  process the list of customers using the Max approach definition. 
	 */
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
	
	/**
	 * Sorts the list by shortest job first
	 * @param arr original list of customers
	 */
	public void mergeSortByShortestJob(ArrayIndexList<Customer> arr) {
		Customer[] temp = new Customer[arr.size()];
		mergeSortByShortestJob(arr, temp, 0, arr.size()-1);
	}
	
	/**
	 * Sorts the list by shortest job first
	 * @param original list of customers
	 * @param temp array to put sorted customers
	 * @param left first term of divided list
	 * @param right last term of divided list
	 */
	public void mergeSortByShortestJob(ArrayIndexList<Customer> arr, Customer[] temp, int left, int right){
		if (left<right) {
			int center = (left + right)/2;
			mergeSortByShortestJob(arr,temp,left,center);
			mergeSortByShortestJob(arr, temp, center+1, right);
			merge(arr, temp, left, center+1,right);
		}
	}
	
	/**
	 * Merges the lists in non-increasing order
	 * @param arr original list of customers
	 * @param temp temp array to put sorted customers
	 * @param left first term of divided list
	 * @param right first term of second part of divided list
	 * @param rightEnd last term of divided list
	 */
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
	
	/**
	 * Compares the time to prepare order of two customers.
	 * @param a customer to be compared
	 * @param b customer to be compared
	 * @return an integer that indicates if a > b, b < a or a=b
	 */
	public int compareJobs(Customer a, Customer b){
		if(a.getTimeToPrepare() < b.getTimeToPrepare()){return 1;}
		else if(a.getTimeToPrepare() > b.getTimeToPrepare()) {return -1;}
		else{return 0;}
	}
	
	/**
	 * @return orderNumber number of current order
	 */
	public int getOrderNumber() {
		return orderedNumber;
	}

	/**
	 * 
	 * @return profit the profit gained after processing the list of customers
	 */
	public double getProfit() {
		return profit;
	}

	
	/**
	 * 
	 * @return amount of customers not attended 
	 */
	public int getNumberOfDisappointedCustomers() {
		return numberOfDisappointedCustomers;
	}


}
