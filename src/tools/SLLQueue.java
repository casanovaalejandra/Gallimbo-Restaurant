/*
 * Alejandra Casanova
 * JoseA Melendez
 */

package tools;
import interfaces.Queue;

public class SLLQueue<E> implements Queue<E> {

	private SNode<E> first;
	private SNode<E> last;

	private int size;

	/**
	 * creates an empty instance of SLLQueue
	 */
	public SLLQueue(){
		last = first = null;
		size=0;
	}
	/**
	 * @return size of the SLLQueue, quantity of element in the SLLQueue
	 */

	public int size() {
		return size;
	}
	/**
	 * @return true if the SLLQueue does not contain any elements
	 */
	public boolean isEmpty() {
		return size==0;
	}
	/**
	 * @return the element saved in the first element of the Queue
	 */

	public E first() {
		if(size==0)  {return null;}
		return first.getElement();
	}
	/**
	 * @return removes the element in the first position of the Queue and returns the element saved in it
	 */

	public E dequeue() {
		if(isEmpty()) {
			return null;
		}
		E returnElement = first.getElement();
		SNode<E> newFirst = (SNode<E>) first.getNext();
		first.setNext(null);
		first = newFirst;
		size--;
		return returnElement;
	}
	/**
	 * @param Adds e to the top of the SLLQueue
	 */

	public void enqueue(E e) {
		SNode<E> newNode = new SNode<E>(e);
		if(isEmpty()) {
			first=last = newNode;
		}
		last.setNext(newNode);
		last = newNode;
		size++;
	}

}
