package algorithm;

import aux.Problem;
import aux.Solution;
import template.DivideConquerTemplate;
import descriptor.Array;

public class QuickSort extends DivideConquerTemplate {

	@Override
	protected boolean isSimple(Problem p) {
		return (((Array)p).getFirst() >= ((Array)p).getLast());
	}

	@Override
	protected Solution simplySolve(Problem p) {
		return (Solution) p;
	}

	@Override
	protected Problem[] decompose(Problem p) {
		int first = ((Array)p).getFirst();
		int last = ((Array)p).getLast();
		int[] a = ((Array)p).getArr ();
		int pivot = a[first];
		int sp = first;
		
		for (int i = first; i < last; i++)
		{ 
			if (a[i] < pivot) { 
				swap(a, ++sp, i); 
			} 
		}
		
		swap(a, first, sp);
		Problem[] ps = new Array[2];
		ps[0] = new Array(a,first,sp-1);
		ps[1] = new Array(a,sp+1,last);
		return ps;
	}

	@Override
	protected Solution combine(Problem p, Solution[] ss) {
		return (Solution) p;
	}

	private void swap (int [] a, int first, int last)
	{ 	int temp = a[first];
		a[first] = a[last];
		a[last] = temp;
	}
}
