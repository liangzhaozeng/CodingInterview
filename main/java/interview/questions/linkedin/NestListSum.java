package interview.questions.linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestListSum {
	public static void main(String[] args) {
		// {{1,1},2,{1,1}}
		List<Object> parent1 = new ArrayList<Object>();

		List<Object> child1 = new ArrayList<Object>();
		child1.add(1);
		child1.add(1);
		parent1.add(child1);

		parent1.add(2);

		List<Object> child3 = new ArrayList<Object>();
		child3.add(1);
		child3.add(1);
		parent1.add(child3);

		System.out.println(getSum(parent1, 1));

		// {1,{4,{6}}}
		List<Object> parent2 = new ArrayList<Object>();
		parent2.add(1);

		List<Object> child11 = new ArrayList<Object>();
		child11.add(4);

		List<Object> child111 = new ArrayList<Object>();
		child111.add(6);

		child11.add(child111);
		parent2.add(child11);
		System.out.println(getSum(parent2, 1));
	}

	private static int getSum(Object list, int depth) {
		if (list == null)
			return 0;

		int sum = 0;
		if (list.getClass() == ArrayList.class) {
			for (Object nestedList : (ArrayList<Object>) list) {
				if (nestedList.getClass() == ArrayList.class)
					sum += getSum(nestedList, depth + 1);
				else
					sum += getSum(nestedList, depth);
			}
		} else {
			sum += (Integer) list * depth;
			System.out.println("CurrentSum => " + sum + " integer => " + list + " Depth => " + depth);
		}
		return sum;
	}

	/**
	 * Given a nested list of integers, returns the sum of all integers in the
	 * list weighted by their depth For example, given the list {{1,1},2,{1,1}}
	 * the function should return 10 (four 1's at depth 2, one 2 at depth 1)
	 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth
	 * 1, one 4 at depth 2, one 6 at depth2)
	 */
	/**
	 * This is the interface that represents nested lists. You should not
	 * implement it, or speculate about its implementation.
	 */
	public interface NestedInteger {
		// Returns true if this NestedInteger holds a single integer, rather
		// than a nested list
		public boolean isInteger();

		// Returns the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Returns null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Returns the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Returns null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	private int getListSum(List<NestedInteger> lni, int depth) {
		int sum = 0;

		for (NestedInteger ni : lni) {

			if (ni.isInteger())
				sum += ni.getInteger() * depth;
			else
				sum += getListSum(ni.getList(), depth + 1);
		}
		return sum;
	}

	public int getSum(NestedInteger ni) {
		if (ni.isInteger())
			return ni.getInteger();
		else
			return getListSum(ni.getList(), 1);
	}
}