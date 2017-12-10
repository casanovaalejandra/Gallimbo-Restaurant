package classes;

import tools.ArrayIndexList;
import tools.SLLStack;

public class MatApproach<E> {

	private int time;
	private int numberOfDisappointedCustomers=0;
	private double profit=0;
	private int orderedNumber=0;
	private Customer currentCustomer = null;

	private ArrayIndexList<Customer> inputCustomers;
	private SLLStack<Customer> processStack;
/**
 * Receives an ArrayindexList with the Customer objects on the file to be tested.
 * 
 * @param theList list of customers to be processed
 * 
 */
	public MatApproach(ArrayIndexList<Customer> theList) {

		inputCustomers = theList;
		processStack = new SLLStack<Customer>();
	}

/**
 * Process the received list of customers based on the Mat approach ( last in first out)
 */
	public void proccesOrders() {
		time = 0;
		while(!inputCustomers.isEmpty() || !processStack.isEmpty() || currentCustomer != null) {
			System.out.println("Time: " + time);
			if(currentCustomer!=null) {

				currentCustomer.setTimeToPrepare(currentCustomer.getTimeToPrepare()-1);
				System.out.println("Remaining time to prepare order: " + currentCustomer.getTimeToPrepare());

				if(currentCustomer.getTimeToPrepare()==0) {
					profit+=currentCustomer.getCostOfOrder();
					orderedNumber++;
					System.out.println("Order " + orderedNumber +  " finished!\n");
					while(!processStack.isEmpty() && processStack.top().getLevelOfPatience() < time - processStack.top().getArrivalTime()) {
						processStack.pop();
						numberOfDisappointedCustomers++;
						System.out.println("Order " + orderedNumber + " dissapointed\n");
					} 
					if(!processStack.isEmpty()) {
						currentCustomer=processStack.pop();
					}
					else {
						currentCustomer = null;
					}
				}

			}
			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {
				processStack.push(inputCustomers.remove(0));
			}
			if(currentCustomer == null && !processStack.isEmpty()) {
				currentCustomer = processStack.pop();
			}
			
			time++;
		}	
	}
	/**
	 * 
	 * @return
	 */
	public double getProfit() {
		return profit;
	}
/**
 * 
 * @param profit
 */
	public void setProfit(double profit) {
		this.profit = profit;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumberOfDissapointedCustomers() {
		return numberOfDisappointedCustomers;
	}
	/**
	 * 
	 * @param numberOfDissapointedCustomers
	 */
	public void setNumberOfDissapointedCustomers(int numberOfDissapointedCustomers) {
		this.numberOfDisappointedCustomers = numberOfDissapointedCustomers;
	}



}
