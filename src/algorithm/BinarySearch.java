package algorithm;

import aux.Problem;
import aux.Solution;
import descriptor.BinarySearchDesc;
import template.DivideConquerTemplate;

public class BinarySearch extends DivideConquerTemplate {

    @Override
    protected boolean isSimple(Problem p) {
        return ((BinarySearchDesc)p).getFirst() >= ((BinarySearchDesc)p).getLast();
    }

    @Override
    protected Solution simplySolve(Problem p) {
        BinarySearchDesc problem = (BinarySearchDesc) p;

        if (problem.getValueToSearch() == problem.get(problem.getLast())) {
            ((BinarySearchDesc)p).setIndexOfValue(((BinarySearchDesc)p).getLast());
        }

        return (Solution) p;
    }

    @Override
    protected Problem[] decompose(Problem p) {
        BinarySearchDesc problem = (BinarySearchDesc) p;
        int middle =
            (((BinarySearchDesc)p).getFirst() + ((BinarySearchDesc)p).getLast()) / 2;
        Problem[] ps = new Problem[1];

        // The value is present at the middle
        if (problem.get(middle) == problem.getValueToSearch()) {
            ps[0] = new BinarySearchDesc(problem.getSortedArray(),
                    middle, middle, problem.getValueToSearch());
        }

        // The value is present at the left subarray
        else if (problem.get(middle) > problem.getValueToSearch()) {
            ps[0] = new BinarySearchDesc(problem.getSortedArray(),
                    problem.getFirst(), middle - 1, problem.getValueToSearch());
        }

        // The value is present at the right subarray
        else {
            ps[0] = new BinarySearchDesc(problem.getSortedArray(),
                    middle + 1, problem.getLast(), problem.getValueToSearch());
        }

        return ps;
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        return ss[0];
    }
}
