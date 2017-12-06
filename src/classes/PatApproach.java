package classes;
import tools.ArrayIndexList;
import tools.SLLQueue;


public class PatApproach<E> {

	private int time;
	private double profit = 0;
	private int numberOfCustomerSatisfied = 0;
	ArrayIndexList<Customer> inputCustomers;
	SLLQueue<Customer> processQueue;


	public PatApproach(ArrayIndexList<Customer> inputCustomers) {
		this.inputCustomers = inputCustomers;
		processQueue = new SLLQueue<Customer>();

	}

	public void processCustomer() {
		time=0;
		while(!inputCustomers.isEmpty() || !processQueue.isEmpty()) {
			if(!processQueue.isEmpty()) {
				processQueue.first().setTimeToPrepare(processQueue.first().getTimeToPrepare()-1);
				if(processQueue.first().getTimeToPrepare()==0) {
					profit+=processQueue.dequeue().getCostOfOrder();
					numberOfCustomerSatisfied++;
					if(!processQueue.isEmpty() && time - processQueue.first().getArrivalTime()> processQueue.first().getLevelOfPatience()) {
						processQueue.dequeue();	
					}
				}
				
			}
			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {
					processQueue.enqueue(inputCustomers.remove(0));
			}
			time++;
		}
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getNumberOfCustomerSatisfied() {
		return numberOfCustomerSatisfied;
	}

	public void setNumberOfCustomerSatisfied(int numberOfCustomerSatisfied) {
		this.numberOfCustomerSatisfied = numberOfCustomerSatisfied;
	}


}
