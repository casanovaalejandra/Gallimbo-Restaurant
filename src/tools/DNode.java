/*
 * Alejandra Casanova
 * JoseA Melendez
 */

package tools;
import interfaces.Node;

public class DNode<E> implements Node<E> {

	private E element;
	private Node<E> next;
	private Node<E> prev;
	/**
	 * 
	 * @param elem creates a new node that saves the elem
	 */
	public DNode(E elem) {
		element = elem;
		prev = next = null;
	}
	/**
	 * 
	 * @param elem element saved in the new node
	 * @param p previous node
	 * @param n next node
	 */
	
	public DNode(E elem,Node<E> p, Node<E> n){
		element = elem;
		prev = p;
		next = n;
	}
	/**
	 * @param n set next to the current node
	 */
	
	public void setNext(Node<E> n) {
		next = n;
	}
	/**
	 * @param p set previous node to the current node
	 */
	public void setPrev(Node<E> p) {
		prev = p;
	}
	/**
	 * @param e set element to the current node
	 */
	public void setElement(E e) {
		element = e;
	}
	/**
	 * @return node previous to the current node
	 */
	public Node<E> getPrev(){
		return prev;
	}
	/**
	 * @return return element next to the current node
	 */
	public Node<E> getNext(){
		return next;
	}
	/**
	 * @return element saved on the current node
	 */
	public E getElement() {
		
		return element;
	}
}