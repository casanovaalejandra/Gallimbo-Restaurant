package classes;
import tools.ArrayIndexList;
import tools.SLLQueue;


public class PatApproach {

	private int time;
	private int orderNumber = 0;
	private double profit = 0;
	private int numberOfDisappointedCustomers = 0;
	ArrayIndexList<Customer> inputCustomers;
	SLLQueue<Customer> processQueue;


	public PatApproach(ArrayIndexList<Customer> inputCustomers) {
		this.inputCustomers = inputCustomers;
		processQueue = new SLLQueue<Customer>();

	}

	/**
	 * process the list of customers according to Pat approach's specifications. 
	 */
	public void processCustomers() {
		time=0;
		while(!inputCustomers.isEmpty() || !processQueue.isEmpty()) {
			System.out.println("Time: " + time);
			if(!processQueue.isEmpty()) {
				processQueue.first().setTimeToPrepare(processQueue.first().getTimeToPrepare()-1);
				System.out.println("Remaining time to prepare order: " + processQueue.first().getTimeToPrepare());
				
				if(processQueue.first().getTimeToPrepare()==0) {
					orderNumber++;
					profit+=processQueue.dequeue().getCostOfOrder();
					System.out.println("Order " + orderNumber+  " finished!\n");
					
					while(!processQueue.isEmpty() && time - processQueue.first().getArrivalTime()> processQueue.first().getLevelOfPatience()) {
						orderNumber++;
						processQueue.dequeue();	
						numberOfDisappointedCustomers++;
						System.out.println("Order " + orderNumber + " dissapointed\n");
					}
				}
				
			}
			while(!inputCustomers.isEmpty() && inputCustomers.get(0).getArrivalTime()==time) {

					processQueue.enqueue(inputCustomers.remove(0));
			}
			time++;
		}
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

