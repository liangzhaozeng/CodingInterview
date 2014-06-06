package interview.questions;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 包装一个普通的Iterator，要实现peek()方法，返回当前iterator指向的元素，但是不能移动它。
 * 除此之外也要实现hasNext()和next()方法。第二题，给一个BST的Node，有父节点的指针，求该Node的下一个Node。
 */
public class PeekableIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T current;

	public PeekableIterator(Iterator<T> it) {
		this.iterator = it;
	}

	@Override
	public boolean hasNext() {
		return current != null || iterator.hasNext();
	}

	@Override
	public T next() {
		if (current == null) {
			getCurr();
		}
		T temp = current;
		current = null;
		return temp;
	}

	@Override
	public void remove() {
		iterator.remove();
	}

	public T peek() {
		getCurr();
		return current;
	}

	private void getCurr() {
		if (current == null && hasNext()) {
			current = iterator.next();
		}
	}

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		Iterator<Integer> it = Arrays.asList(array).iterator();
		PeekableIterator<Integer> peekit = new PeekableIterator<Integer>(it);
		System.out.println(peekit.next());
		while (peekit.hasNext()) {
			
			System.out.println("peek "+ peekit.peek());
			System.out.println("next " + peekit.next());
			System.out.println("next " + peekit.next());
		}
	}
}