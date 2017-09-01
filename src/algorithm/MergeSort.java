package algorithm;

import aux.Problem;
import aux.Solution;
import descriptor.MergeSortDesc;
import descriptor.QuickSortDesc;
import template.DivideConquerTemplate;

import java.util.Arrays;

public class MergeSort extends DivideConquerTemplate {

    @Override
    protected boolean isSimple(Problem p) {
        return ((MergeSortDesc)p).size() == 1;
    }

    @Override
    protected Solution simplySolve(Problem p) {
        return (Solution) p;
    }

    @Override
    protected Problem[] decompose(Problem p) {
        MergeSortDesc problem = (MergeSortDesc) p;
        int middle = problem.size() / 2;
        Problem[] ps = new MergeSortDesc[2];

        int[] firstHalf = Arrays.copyOfRange(problem.getArr(), 0, middle);
        int[] secondHalf = Arrays.copyOfRange(problem.getArr(),middle,
                problem.size());

        ps[0] = new MergeSortDesc(firstHalf);
        ps[1] = new MergeSortDesc(secondHalf);

        return ps;
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        MergeSortDesc array1 = (MergeSortDesc)ss[0];
        MergeSortDesc array2 = (MergeSortDesc)ss[1];
        int[] aux = new int[array1.size() + array2.size()];
        int i = 0, j = 0, k = 0;

        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i) < array2.get(j)) {
                aux[k] = array1.get(i);
                i++;
            }

            else {
                aux[k] = array2.get(j);
                j++;
            }

            k++;
        }

        // The first array is entirely read.
        // Let's copy the remaining second array.
        if (i == array1.size()) {
            while (j < array2.size()) {
                aux[k] = array2.get(j);
                j++;
                k++;
            }
        }

        // The second array is entirely read.
        // Let's copy the remaining first array.
        else if (j == array2.size()) {
            while (i < array1.size()) {
                aux[k] = array1.get(i);
                i++;
                k++;
            }
        }

        return new MergeSortDesc(aux);
    }
}
