package interfaces;

public interface Node<E> {

	/*
	 *
	 */
	void setNext(Node<E> n);
	/*
	 * 
	 */
	Node<E> getNext();
	/*
	 * 
	 */
	void setPrev(Node<E> n);
	/*
	 * 
	 */
	Node<E> getPrev();
	/*
	 * 
	 */
	void setElement(E e);
	/*
	 * 
	 */
	E getElement();
}
