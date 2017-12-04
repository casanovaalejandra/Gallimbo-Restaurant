public class SLLQueue<E> implements Queue<E> {

	private DNode<E> first;
	private DNode<E> last;

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
		DNode<E> newFirst = (DNode<E>) first.getNext();
		first.setNext(null);
		first = newFirst;
		size--;
		return returnElement;
	}

	public void enqueue(E e) {
		DNode<E> newNode = new DNode<E>(e);
		if(isEmpty()) {
			first=last = newNode;
		}
		last.setNext(newNode);
		last = newNode;
		size++;
	}

}
