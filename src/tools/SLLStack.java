package tools;
import exceptions.EmptyStackException;
import interfaces.Stack;

public class SLLStack<E> implements Stack<E>
{
	private SNode<E> top; 
	private int size; 
	
	public SLLStack() {
		top = null; 
		size = 0; 
	}
	
	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("pop: Stack is empty."); 
		E etr = top.getElement(); 
		top = top.getNext();
		size--;
		return etr;
	}

	public void push(E e) {
		SNode<E> newNode = new SNode<E>(e,top);
		top = newNode;
		size++; 
	}

	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("pop: Stack is empty."); 
		return top.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	} 
 
}
