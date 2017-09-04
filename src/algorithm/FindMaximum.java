package algorithm;

import aux.Problem;
import aux.Solution;
import descriptor.FindMaximumDesc;
import template.DivideConquerTemplate;

public class FindMaximum extends DivideConquerTemplate {

    @Override
    protected boolean isSimple(Problem p) {
        return ((FindMaximumDesc)p).getFirst()
                == ((FindMaximumDesc)p).getLast();
    }

    @Override
    protected Solution simplySolve(Problem p) {
        ((FindMaximumDesc)p).setMax(
                ((FindMaximumDesc)p).get(((FindMaximumDesc)p).getFirst()));
        return (Solution) p;
    }

    @Override
    protected Problem[] decompose(Problem p) {
        Problem[] ps = new Problem[2];
        int middle = (((FindMaximumDesc)p).getFirst()
                + ((FindMaximumDesc)p).getLast()) / 2;

        ps[0] = new FindMaximumDesc(((FindMaximumDesc)p).getArr(),
                ((FindMaximumDesc)p).getFirst(), middle);
        ps[1] = new FindMaximumDesc(((FindMaximumDesc)p).getArr(),
                middle + 1, ((FindMaximumDesc)p).getLast());

        return ps;
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        int maxValue = ((FindMaximumDesc)ss[0]).getMax();

        if (maxValue < ((FindMaximumDesc)ss[1]).getMax()) {
            maxValue = ((FindMaximumDesc)ss[1]).getMax();
        }

        FindMaximumDesc solution = new FindMaximumDesc(((FindMaximumDesc)ss[0]).getArr(),
                ((FindMaximumDesc)ss[0]).getFirst(), ((FindMaximumDesc)ss[1]).getLast());
        solution.setMax(maxValue);

        return solution;
    }
}
