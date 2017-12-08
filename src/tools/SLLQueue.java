package tools;
import interfaces.Queue;

public class SLLQueue<E> implements Queue<E> {

	private SNode<E> first;
	private SNode<E> last;

	private int size;

	public SLLQueue(){
		last = first = null;
		size=0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public E first() {
		if(size==0)  {return null;}
		return first.getElement();
	}

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
