/*
 * Alejandra Casanova
 * JoseA Melendez
 */


package interfaces;

public interface Node<E> {

	/**
	 * 
	 * @param n is the next node
	 */
	void setNext(Node<E> n);
	/**
	 * 
	 * @return the node next to the instance
	 */
	Node<E> getNext();
	/**
	 * 
	 * @param n node that precedes the current node
	 */
	void setPrev(Node<E> n);
	/**
	 * 
	 * @return the previous node of the instance on the list
	 */
	Node<E> getPrev();
	/**
	 * 
	 * @param e element setted on the current Node
	 */
	void setElement(E e);
	/**
	 * 
	 * @return element on the current node
	 */
	E getElement();
}
