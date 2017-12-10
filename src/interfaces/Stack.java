package interfaces;

import exceptions.EmptyStackException;

public interface Stack<E> {
	/**
	 * 
	 * @return number of elements on the stack
	 */
	int size(); 
	/**
	 * 
	 * @return true if the stack does not have any element
	 */
	boolean isEmpty(); 
	/**
	 * 
	 * @return element at the top of the Stack
	 * @throws EmptyStackException if the stack is empty it throw the exception
	 */
	E top() throws EmptyStackException; 
	/**
	 * 
	 * @return the element at the top of the stack and it gets removed from the stack
	 * @throws EmptyStackException
	 */
	E pop() throws EmptyStackException; 
	/**
	 * 
	 * @param e add a new element to the top of the Stack
	 */
	void push(E e); 
}
