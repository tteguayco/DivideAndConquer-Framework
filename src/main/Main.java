package main;

import algorithm.QuickSort;
import algorithm.MergeSort;
import descriptor.MergeSortDesc;
import descriptor.QuickSortDesc;

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
	}
}
