package tools;

public class ArrayIndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 

	public void add(int index, E e) throws IndexOutOfBoundsException {
		if(index>size|| index<0) {
			throw new IndexOutOfBoundsException("add: Invalid index: " + index); 
		}        
		if(size==element.length) {changeCapacity(CAPTOAR);}
		moveDataOnePositionTR(index,size-1);
		element[index]=e;
		size++;
	}

	public void add(E e) {
		if(size==element.length) {changeCapacity(CAPTOAR);}
		element[size]=e;
		size++;

	}
	public E get(int index) throws IndexOutOfBoundsException {
		if(index>size-1|| index<0) {
			throw new IndexOutOfBoundsException("get: Invalid index: " + index);
		}
		return element[index]; 
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if(index>size-1|| index<0) { throw new IndexOutOfBoundsException("remove: Invalid index: "+ index);}
		E temp = element[index];
		moveDataOnePositionTL(index+1,size-1);
		size--;
		element[size]=null;
		return temp;
	}

	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index>size-1|| index<0) { throw new IndexOutOfBoundsException("set: Invalid index: " + index);
		}    
		E temp = element[index];
		element[index]=e;
		return temp;
	}

	public int size() {
		return size;
	}    
	public int capacity() {
		return element.length;
	}

	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}

	private void moveDataOnePositionTR(int low, int sup) { 
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	private void moveDataOnePositionTL(int low, int sup) { 
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 

	}

}