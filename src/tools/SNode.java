/*
 * Alejandra Casanova
 * JoseA Melendez
 */

package tools;

public class SNode<E>  {
	private E element; 
	private SNode<E> next; 
	public SNode() { 
		element = null; 
		next = null; 
	}
	/**
	 * 
	 * @param data element to be saved inside the Node
	 * @param next node that is next to the current node
	 */
	public SNode(E data, SNode<E> next) { 
		this.element = data; 
		this.next = next; 
	}
	/**
	 * 
	 * @param data creates a new Node that saves data
	 */
	public SNode(E data)  { 
		this.element = data; 
		next = null; 
	}
	/**
	 * 
	 * @return the element saved inside the node
	 */
	public E getElement() {
		return element;
	}
	/**
	 * 
	 * @param data: Set data as the element in the current node
	 */
	public void setElement(E data) {
		this.element = data;
	}
	/**
	 * 
	 * @return the node next to the current
	 */
	public SNode<E> getNext() {
		return next;
	}
	/**
	 * 
	 * @param next: Set the next node to the current node
	 */
	public void setNext(SNode<E> next) {
		this.next = next;
	}
}

