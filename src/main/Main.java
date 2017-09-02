package main;

import algorithm.BinarySearch;
import algorithm.QuickSort;
import algorithm.MergeSort;
import descriptor.BinarySearchDesc;
import descriptor.MergeSortDesc;
import descriptor.QuickSortDesc;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		int[] valuesToSort = { 4, 6, 1, 7, 8, 4, 2, 3, 1, 9, 5 };

		// QuickSort
		QuickSortDesc sortedArrayQuickSort = null;
		QuickSortDesc unsortedArrayQuickSort =
				new QuickSortDesc(valuesToSort, 0, valuesToSort.length);
		
		QuickSort quickSortSolver = new QuickSort();
		sortedArrayQuickSort = (QuickSortDesc) quickSortSolver.solve(unsortedArrayQuickSort);
		
		System.out.print("QuickSort's solution: ");
		System.out.println(sortedArrayQuickSort);

		// MergeSort
		MergeSortDesc sortedArrayMergeSort = null;
		MergeSortDesc unsortedArrayMergeSort = new MergeSortDesc(valuesToSort);

		MergeSort mergeSortSolver = new MergeSort();
		sortedArrayMergeSort = (MergeSortDesc) mergeSortSolver.solve(unsortedArrayMergeSort);

		System.out.print("MergeSort's solution: ");
		System.out.println(sortedArrayMergeSort);

		// Binary Search
		int[] valuesToSearch = { 3, 23, 37, 55, 58, 69, 72, 81, 95, 124, 146 };
        int rndIndex = ThreadLocalRandom.current().nextInt(0, valuesToSort.length);
		int rndValueToSearch = valuesToSearch[rndIndex];

		System.out.println("\nApplying Binary Search with the following value: " + rndValueToSearch);

		BinarySearch binarySearchSolver = new BinarySearch();
		BinarySearchDesc binarySearchProblem =
				 new BinarySearchDesc(valuesToSearch, 0,
				valuesToSearch.length - 1, rndValueToSearch);
		BinarySearchDesc binarySearchSolution =
				(BinarySearchDesc) binarySearchSolver.solve(binarySearchProblem);

		System.out.println("Index of the target value: " + binarySearchSolution.getIndexOfValue());
	}
}
