package interfaces;
import java.io.File;

public interface ApproachInterface {
/**
 * 
 * @return profit return by the specific approach
 */
	double profit();
	/**
	 * 
	 * @return number of customers that were not attended in the determined approach
	 */
	
	int customersSatisfied();
	
	/**
	 * 
	 * @param theFile is the list of customers that will be proccessed
	 */
	
	void processCustomer(File theFile);
	
}
