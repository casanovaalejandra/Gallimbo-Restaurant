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
	
	/**
	 * 
	 * @param inputCustomers list of customers read on the file
	 */
	public MaxApproach(ArrayIndexList<Customer> inputCustomers) {
		this.inputCustomers  = inputCustomers;
	}
	
	/**
	 *  process the list of customers using the Max approach definition. 
	 */
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

					while(!waitingLine.isEmpty() && time - waitingLine.get(0).getArrivalTime() > waitingLine.get(0).getLevelOfPatience()) {
						orderNumber++;
						waitingLine.remove(0);	
						numberOfDisappointedCustomers++;
						System.out.println("Order " + orderNumber + " dissapointed\n");
					}
				}

			}
			int count = 0;
			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {
				waitingLine.add(inputCustomers.remove(0));
				count++;
			}
			if(count > 0) {
				mergeSortByProfit(waitingLine);
			}

			if(processCustomer == null && !waitingLine.isEmpty()){
				processCustomer = waitingLine.remove(0);
			}

			time++;
		}
	}


	/**
	 * Sorts the list by larger profit first
	 * @param arr original list of customers
	 */
	public void mergeSortByProfit(ArrayIndexList<Customer> arr) {
		Customer[] temp = new Customer[arr.size()];
		mergeSortByProfit(arr, temp, 0, arr.size()-1);
	}
	
	/**
	 * Sorts the list by larger profit first
	 * @param original list of customers
	 * @param temp array to put sorted customers
	 * @param left first term of divided list
	 * @param right last term of divided list
	 */
	public void mergeSortByProfit(ArrayIndexList<Customer> arr, Customer[] temp, int left, int right){
		if (left<right) {
			int center = (left + right)/2;
			mergeSortByProfit(arr,temp,left,center);
			mergeSortByProfit(arr, temp, center+1, right);
			merge(arr, temp, left, center+1,right);
		}
	}
	
	/**
	 * Merges the lists in non-decreasing order
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
			if(compareProfit(arr.get(left),arr.get(right)) >= 0){
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
	 * Compares the profit of two customers.
	 * @param a customer to be compared
	 * @param b customer to be compared
	 * @return an integer that indicates if a > b, b < a or a=b
	 */
	public int compareProfit(Customer a, Customer b){
		if(a.getCostOfOrder() > b.getCostOfOrder()){return 1;}
		else if(a.getCostOfOrder() < b.getCostOfOrder()) {return -1;}
		else{return 0;}
	}
	
	/**
	 * @return orderNumber number of current order
	 */
	public int getOrderNumber() {
		return orderNumber;
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
