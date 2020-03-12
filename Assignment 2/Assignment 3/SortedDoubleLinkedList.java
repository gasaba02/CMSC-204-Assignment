import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

//import BasicDoubleLinkedList.Node;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T> {
	
	//private Node head;
	private Comparator<T> comparator;
	/**
	 * 
	 * @param comparator2
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		super();
		//super.setHead(head);
		this.comparator = comparator2;
		
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node cur = head;
		Node n = new Node (data);
		if (head == null) {
			head = n;
			tail = n;
			count++;
		} 
		else if (comparator.compare((T)head.data, data) >= 1) {
			
			n.next = head;
			head.prev = n;
			head = n;
			count++;
		}
		else {
			Node previous = cur.prev;
			while (cur != null) {
				if (comparator.compare((T)cur.data, data) >= 1) {
					n.next = cur;
					cur.prev.next = n;
					n.prev = cur.prev;
					cur.prev = n;
					count++;
					return this;
					
				}
				previous = cur;
				cur = cur.next;
			}
			if (comparator.compare((T)previous.data, data) < 0) {
				previous.next = n;
				n.prev = previous;
				tail = n;
				count++;
				return this;
			}
		}
		return this;
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		
		
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data){
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public ListIterator<T> iterator(){
		return super.iterator();
		
	}
	
	
	public SortedDoubleLinkedList<T> remove(T targetData){
		super.remove(targetData, comparator);
		return this;
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

	public final static class ComparableComparator<T extends Comparable<T>> implements Comparator<T> {
	    @Override
	    public int compare(final T a, final T b) {
	        return a.compareTo(b);
	    }
	}
	

	public static void main(String [] args) {
		ComparableComparator comparator = new ComparableComparator();
		SortedDoubleLinkedList<Integer> list = new SortedDoubleLinkedList(comparator);
		
		list.add(45);
		list.add(2);
		list.add(12);
		list.add(22);
		list.add(12);
		list.add(22);
		list.add(121);
		list.add(0);
		list.add(100);
		list.add(121);
		String result = list.toString();
		System.out.println(result);
	}

	
}
