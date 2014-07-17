package interview.questions.apple;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Node<E>  implements Iterable<E> {
	private Node<E> left;
	private Node<E> right;
	private E value;

	public Node(E value) {
		this.value = value;
	}

	public Node<E> left(E leftval) {
		left = new Node<>(leftval);
		return left;
	}

	public Node<E> right(E rightval) {
		right = new Node<>(rightval);
		return right;
	}

	public Iterator<E> iterator() {
		return new BstIterator(this);
	}

	private class BstIterator implements Iterator<E> {
		Stack<Node<E>> stack;

		BstIterator(Node<E> root) {
			stack = new Stack<>();
			Node<E> node = root;
			while (node != null) {  // initiate the stack, where is current top is left most leave
				stack.push(node);
				node = node.left;
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();

			Node<E> node = stack.pop();
			E retval = node.value;

			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			return retval;
		}
	}

	public static void main(String... args) {
		Node<Integer> ten = new Node<>(10), five = ten.left(5), four = five.left(4), seven = five.right(7), six = seven
				.left(6), three = four.left(3), one = three.left(1), two = one.right(2), twenty = ten.right(20), fifteen = twenty
				.left(15), seventeen = fifteen.right(17), thirty = twenty.right(30);

		for (Integer num : ten) {
			System.out.println(num);
		}
	}
}