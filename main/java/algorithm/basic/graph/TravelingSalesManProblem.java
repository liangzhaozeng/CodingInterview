package algorithm.basic.graph;

import java.util.ArrayList;

import java.util.HashMap;

public class TravelingSalesManProblem {

	public static HashMap<String, Integer> DynamicProgrammingCache = new HashMap<String, Integer>();

	public static void main(String[] args) {

		int source = 0;

		int matrix[][] = { { 0, 10, 15, 20 }, { 10, 0, 35, 25 },

		{ 15, 35, 0, 30 }, { 20, 25, 30, 0 } };

		ArrayList<Integer> visitedNodes = new ArrayList<Integer>();

		visitedNodes.add(source);

		int minDistance = findMinimumDistance(matrix, source, visitedNodes);

		System.out.println(minDistance);

	}

	private static int findMinimumDistance(int[][] matrix, int source, ArrayList<Integer> visitedNodes) {

		if (DynamicProgrammingCache.containsKey(visitedNodes + ",(" + source + ")")) {

			return DynamicProgrammingCache.get(visitedNodes + ",(" + source + ")");

		}

		if (visitedNodes.size() == 4) {

			int temp = matrix[visitedNodes.get(visitedNodes.size() - 1)][visitedNodes.get(0)];

			if (temp != 0)

				return temp;

			else

				return -1;

		}

		int min = -1;

		for (int i = 0; i < matrix.length; i++) {

			if (matrix[source][i] != 0 && notInVisitedNodes(visitedNodes, i)) {

				ArrayList<Integer> tempVisitedNodes = copyOf(visitedNodes);

				tempVisitedNodes.add(i);

				int val = findMinimumDistance(matrix, i, tempVisitedNodes);

				if (val != -1) {

					val = val + matrix[source][i];

					if (min == -1) {

						min = val;

					} else {

						if (min > val) {

							min = val;

						}

					}

				}

			}

		}

		DynamicProgrammingCache.put(visitedNodes + ",(" + source + ")", min);

		return min;

	}

	private static ArrayList<Integer> copyOf(ArrayList<Integer> visitedNodes) {

		return new ArrayList<Integer>(visitedNodes);

	}

	private static boolean notInVisitedNodes(ArrayList<Integer> visitedNodes, int i) {

		return !visitedNodes.contains(i);

	}

}