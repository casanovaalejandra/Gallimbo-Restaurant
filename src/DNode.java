
public class DNode<E> implements Node<E> {

	private E element;
	private Node<E> next;
	private Node<E> prev;
	
	public DNode(E elem,Node<E> p, Node<E> n){
		element = elem;
		prev = p;
		next = n;
	}
	
	public void setNext(Node<E> n) {
		next = n;
	}
	public void setPrev(Node<E> p) {
		prev = p;
	}
	public void setElement(E e) {
		element = e;
	}
	public Node<E> getPrev(){
		return prev;
	}
	public Node<E> getNext(){
		return next;
	}
	public E getElement() {
		return element;
	}
}