import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

	 Node head;
	 int count;
	 Node tail; //points to the last node
	

	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}

	class Node{
		T data;
		Node prev;
		Node next;

		public Node(T data) {
			this.data = data;
		}

	}

	@SuppressWarnings("rawtypes")
	private class MyIterator implements ListIterator<T>{
	
		private Node temp;
		//private Node accessed;
		private int i;
		private int headCheck = 0;
		
		public MyIterator(){
			temp = head;
		//	accessed = null;
			i = 0;
			
		}
		
		@Override
		public boolean hasNext() {
			//return i < getSize();
			if (temp.next != null) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			if (temp == head && temp != null && headCheck == 0) {
				headCheck = 1;
				return head.data;
			}
			else if(hasNext()) {
				temp = temp.next;
				T item = temp.data;
				
				return item;
			}

			else
				throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
			return (temp.data != null);
		}

		@Override
		public T previous() {
			if(hasPrevious()) {
				T item = temp.data;
				temp = temp.prev;
				return item;
			}

			else 
				throw new NoSuchElementException();
		}

		
		public int nextIndex() throws UnsupportedOperationException  {
			throw new UnsupportedOperationException();
		}

		
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		public void set(Object e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		public void add(Object e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

	}





	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node frontNewNode = new Node(data);
		if(head == null) {
			head = frontNewNode;
			tail = frontNewNode;
			count++;
		}else {

			head.prev = frontNewNode;
			frontNewNode.next = head;
			head.prev = frontNewNode;
			head = frontNewNode;
			count++;

		}
		return this;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */

	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node endNode = new Node(data);
		if(head == null) {
			head = endNode;
			tail = endNode;
			count++;
		}else {
			tail.next = endNode;
			endNode.prev = tail;
			tail = endNode;
			count++;		
		}
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return count;
	}

	/**
	 * 
	 * @return
	 */
	public T getFirst() {

		return head.data;
	}

	/**
	 * 
	 * @return
	 */
	public T getLast() {
		return tail.data;
	}

	@SuppressWarnings("unchecked")
	public ListIterator<T> iterator()throws UnsupportedOperationException, NoSuchElementException{
		return new MyIterator();

	}
	/**
	 * 
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node temp = head;
		if(comparator.compare(targetData, head.data) == 0) {
			head = head.next;
			head.prev = null;
			count--;
			return null;
		}
		else if (comparator.compare(targetData, tail.data) == 0) {
			tail = tail.prev;
			tail.next = null;
			count--;
			return null;
		}
		while(temp != null) {
			if(comparator.compare(targetData, temp.data) == 0) {

				temp.next.prev = temp.prev;
				temp.prev.next = temp.next;
				temp = null;
				count--;
			}
			else
				temp = temp.next;
		}
		return this;

	}


	public T retrieveFirstElement() {
		if(head != null) {
			head = head.next;
			T value = head.prev.data;
			head.prev = null;
			count--;
			return value;
		}
		return null;

	}

	public T retrieveLastElement() {
		if(tail != null) {
			T value = tail.data;
			tail = tail.prev;
			tail.next = null;
			return value;

		}
		return null;

	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String result = "";
		if (head != null ) {
			Node temp = head;
			while(temp != null) {
				result += temp.data + " -> ";
				temp = temp.next;
			}
		}

		return result;



	}

	public ArrayList<T> toArrayList(){
		ArrayList<T> myList = new ArrayList<T>();
		Node temp = head;
		if(temp != null) {
			while(temp != null) {
				myList.add(temp.data);
				temp = temp.next;
			}
		}

		return myList;

	}

	public final static class ComparableComparator<T extends Comparable<T>> implements Comparator<T> {
		@Override
		public int compare(final T a, final T b) {
			return a.compareTo(b);
		}
	}


	public static void main(String [] args) {

		BasicDoubleLinkedList<Integer> myList = new BasicDoubleLinkedList<Integer>();
		myList.addToEnd(5);
		myList.addToEnd(3);
		myList.addToEnd(4);
		myList.addToEnd(11);
		myList.addToEnd(8);
		myList.addToFront(10);

		Comparator<Integer> comparator = new ComparableComparator<Integer>();
		myList.remove(8, comparator);

		//myList.retrieveFirstElement();
		myList.retrieveLastElement();
		ArrayList l = myList.toArrayList();
		System.out.println(l.toString());

		System.out.print(myList.toString());

		//MyIterator itr = myList.iterator();
	}
	



}


