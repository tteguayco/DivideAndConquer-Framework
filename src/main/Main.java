package main;

import algorithm.QuickSort;
import descriptor.Array;

public class Main {

	public static void main(String[] args) {
		int[] values = { 4, 6, 1, 7, 8, 4, 2, 3, 1, 9, 5};
		Array unsortedArray = new Array(values, 0, values.length);
		Array sortedArray = null;
		
		QuickSort quickSortSolver = new QuickSort();
		sortedArray = (Array) quickSortSolver.solve(unsortedArray);
		
		System.out.print("QuickSort's solution: ");
		System.out.println(sortedArray);
	}
}
