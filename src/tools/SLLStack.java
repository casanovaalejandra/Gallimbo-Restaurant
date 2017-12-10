package tools;
import exceptions.EmptyStackException;
import interfaces.Stack;

public class SLLStack<E> implements Stack<E>
{
	private SNode<E> top; 
	private int size; 
	/**
	 * Creates a new empty instance of SLLStack 
	 */
	public SLLStack() {
		top = null; 
		size = 0; 
	}
	/**
	 * @return etr: removes the node at the top of the Stack and returns its element
	 */
	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("pop: Stack is empty."); 
		E etr = top.getElement(); 
		top = top.getNext();
		size--;
		return etr;
	}
	/**
	 * @param e: add a new Node at the top of the Stack that has e as element
	 */
	public void push(E e) {
		SNode<E> newNode = new SNode<E>(e,top);
		top = newNode;
		size++; 
	}
	/**
	 * @return the element saved in the node at the top of the stack
	 */

	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("pop: Stack is empty."); 
		return top.getElement();
	}
	/**
	 * @return size: The number of nodes in the SLLStack
	 */

	public int size() {
		return size;
	}
	/**
	 * @return true if the SLLStack does not contain any node
	 */

	public boolean isEmpty() {
		return size == 0;
	} 

}
