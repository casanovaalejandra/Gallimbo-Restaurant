package classes;

import tools.ArrayIndexList;
import tools.SLLStack;

public class MatApproach<E> {

	private int time;
	private int numberOfDissapointedCustomers=0;
	private double profit=0;
	private int orderedNumber=0;
	private Customer currentCustomer = null;

	private ArrayIndexList<Customer> inputCustomers;
	private SLLStack<Customer> processStack;

	public MatApproach(ArrayIndexList<Customer> theList) {

		inputCustomers = theList;
		processStack = new SLLStack<Customer>();
	}

	public void proccesOrders() {
		time = 0;
		while(!inputCustomers.isEmpty() || !processStack.isEmpty()) {
			if(!processStack.isEmpty()) {
				processStack.push(inputCustomers.get(0));

				while(inputCustomers.get(0).getArrivalTime()==time) {
					processStack.push(inputCustomers.remove(0));
				}
				if(currentCustomer.getTimeToPrepare()==0) {
					profit+=currentCustomer.getCostOfOrder();
					orderedNumber++;
					currentCustomer = processStack.pop();
				}
				
				currentCustomer.setArrivalTime(currentCustomer.getArrivalTime()-1);
			}
			if(!processStack.isEmpty()&& currentCustomer.getTimeToPrepare()==time-currentCustomer.getArrivalTime()) {

			}

			currentCustomer.setArrivalTime(currentCustomer.getArrivalTime()-1);

		}time++;

	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	public int getNumberOfDissapointedCustomers() {
		return numberOfDissapointedCustomers;
	}
	public void setNumberOfDissapointedCustomers(int numberOfDissapointedCustomers) {
		this.numberOfDissapointedCustomers = numberOfDissapointedCustomers;
	}



}
