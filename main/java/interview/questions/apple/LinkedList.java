package interview.questions.apple;

import java.util.Iterator;

/**
 *
 *
 */
public class LinkedList<T> implements Iterable<T>{

	private Node<T> head;
	
	
	public void add(T item){
		if(head == null){
			head = new Node<T>(item);
		}
		else {
			Node<T> temp = head;
			while(temp.next != null)
				temp = temp.next;
			Node<T> node = new Node<T>(item);
			temp.next = node;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<T> iterator() {
		return new LinkedIterator();
	}
	
	private final class LinkedIterator implements Iterator<T>{

		private Node<T> start;
		
		/**
		 * 
		 */
		public LinkedIterator() {
			start = head;
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			if(start == null)
				return false;
			return start != null;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		public T next() {
			Node<T> temp = start;
			start = start.next;
			return temp.value;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}
	
	private final class Node<T>{
		T value;
		Node<T> next;
		
		/**
		 * @param value
		 */
		public Node(T value) {
			this.value = value;
		}
		
		
	}
	
	public static void main(String[] args) {
		args = new String[]{"A", "B", "C"};
		LinkedList<LinkedList<String>> lll = new LinkedList<LinkedList<String>>();
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			LinkedList<String> ll = new LinkedList<String>();
			for(int j=0; j<10; j++)
				ll.add(s+  "_" + j);
			lll.add(ll);
		}
		
		Iterator<LinkedList<String>> outer = lll.iterator();
		while(outer.hasNext()){
			LinkedList<String> ll = outer.next();
			Iterator<String> inner = ll.iterator();
			while(inner.hasNext()){
				System.out.print(inner.next() + " , ");
			}
			System.out.println();
		}
	}

}