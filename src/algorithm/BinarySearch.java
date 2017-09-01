package algorithm;

import aux.Problem;
import aux.Solution;
import template.DivideConquerTemplate;

public class BinarySearch extends DivideConquerTemplate {

    @Override
    protected boolean isSimple(Problem p) {
        return false;
    }

    @Override
    protected Solution simplySolve(Problem p) {
        return null;
    }

    @Override
    protected Problem[] decompose(Problem p) {
        return new Problem[0];
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        return null;
    }
}
