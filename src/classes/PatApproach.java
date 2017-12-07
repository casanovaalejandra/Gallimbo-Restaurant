package classes;
import tools.ArrayIndexList;
import tools.SLLQueue;


public class PatApproach<E> {

	private int time;
	private double profit = 0;
	private int numberOfDisappointedCustomers = 0;
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
				System.out.println("Remaining time to prepare order: " + processQueue.first().getTimeToPrepare());
				
				if(processQueue.first().getTimeToPrepare()==0) {
					profit+=processQueue.dequeue().getCostOfOrder();
					System.out.println("Order finished!\n");
					
					if(!processQueue.isEmpty() && time - processQueue.first().getArrivalTime()> processQueue.first().getLevelOfPatience()) {
						processQueue.dequeue();	
						numberOfDisappointedCustomers++;
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

	public int getNumberOfDisappointedCustomers() {
		return numberOfDisappointedCustomers;
	}

	public void setNumberOfDisappointedCustomers(int numberOfDisappointedCustomers) {
		this.numberOfDisappointedCustomers = numberOfDisappointedCustomers;
	}

	


}

