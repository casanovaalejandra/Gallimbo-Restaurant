package interfaces;
public interface Queue<E> {
	/**
	 * 
	 * @return number of elements in the current Queue
	 */
	int size();
	/**
	 * 
	 * @return true if the Queue does not contain any element
	 */
	boolean isEmpty(); 
	/**
	 * 
	 * @return the element at the first position of the Queue
	 */
	E first();
	/**
	 * 
	 * @return removes the element at the first position of the Queue and returns its value
	 */
	E dequeue(); 
	/**
	 * 
	 * @param e add a new element at the top of the Queue
	 */
	void enqueue(E e);
}
