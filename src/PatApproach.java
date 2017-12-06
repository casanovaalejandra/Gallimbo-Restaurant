import classes.Customer;
import tools.ArrayIndexList;
import tools.SLLQueue;


public class PatApproach<E> {

	private int time;
	private double profit;
	private int numberOfCustomerSatisfied;
	ArrayIndexList<Customer> inputCustomers;
	SLLQueue<Customer> processQueue;


	public PatApproach(ArrayIndexList<Customer> inputCustomers ) {
		this.inputCustomers = inputCustomers;

	}

	public void processCustomer() {
		time=0;
		while(!inputCustomers.isEmpty() || !processQueue.isEmpty()) {
			if(!processQueue.isEmpty() && processQueue.first().getStatus()) {
				processQueue.first().setTimeToPrepare(processQueue.first().getTimeToPrepare()-1);
				if(processQueue.first().getTimeToPrepare()==0) {
					profit+=profit+processQueue.dequeue().getCostOfOrder();
					numberOfCustomerSatisfied++;
				}
				if(inputCustomers.get(0).getArrivalTime()==time) {
					if(time - inputCustomers.get(0).getArrivalTime()> inputCustomers.get(0).getLevelOfPatience()) {
						inputCustomers.remove(0);	
				}processQueue.enqueue(inputCustomers.remove(0));
			}
			else {
				
			}
			time++;

		}

	}
}

