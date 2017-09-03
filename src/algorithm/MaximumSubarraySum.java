package algorithm;

import aux.Problem;
import aux.Solution;
import descriptor.MaximumSubarraySumDesc;
import template.DivideConquerTemplate;

public class MaximumSubarraySum extends DivideConquerTemplate {
    @Override
    protected boolean isSimple(Problem p) {
        return ((MaximumSubarraySumDesc)p).getFirst() == ((MaximumSubarraySumDesc)p).getLast();
    }

    @Override
    protected Solution simplySolve(Problem p) {
        return new MaximumSubarraySumDesc(
                ((MaximumSubarraySumDesc)p).getArr(),
                ((MaximumSubarraySumDesc)p).getFirst(),
                ((MaximumSubarraySumDesc)p).getLast()
        );
    }

    @Override
    protected Problem[] decompose(Problem p) {
        Problem[] ps = new MaximumSubarraySumDesc[2];
        MaximumSubarraySumDesc problem = (MaximumSubarraySumDesc) p;
        int middle = problem.getMiddle();

        ps[0] = new MaximumSubarraySumDesc(problem.getArr(), problem.getFirst(), middle);
        ps[1] = new MaximumSubarraySumDesc(problem.getArr(),middle + 1, problem.getLast());

        return ps;
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        int leftSum = ((MaximumSubarraySumDesc)ss[0]).computeSum();
        int rightSum = ((MaximumSubarraySumDesc)ss[1]).computeSum();
        int[] middleElementSum = maxSubarraySumWithMiddle(
                ((MaximumSubarraySumDesc)ss[0]).getArr(),
                ((MaximumSubarraySumDesc)ss[0]).getFirst(),
                ((MaximumSubarraySumDesc)ss[0]).getLast(),
                ((MaximumSubarraySumDesc)ss[1]).getLast()
        );

        if (leftSum > rightSum && leftSum > middleElementSum[2]) {
            return new MaximumSubarraySumDesc(
                    ((MaximumSubarraySumDesc)ss[0]).getArr(),
                    ((MaximumSubarraySumDesc)ss[0]).getFirst(),
                    ((MaximumSubarraySumDesc)ss[0]).getLast()
            );
        }

        else if (rightSum > leftSum && rightSum > middleElementSum[2]) {
            return new MaximumSubarraySumDesc(
                    ((MaximumSubarraySumDesc)ss[1]).getArr(),
                    ((MaximumSubarraySumDesc)ss[1]).getFirst(),
                    ((MaximumSubarraySumDesc)ss[1]).getLast()
            );
        }

        else {
            return new MaximumSubarraySumDesc(
                    ((MaximumSubarraySumDesc)ss[0]).getArr(),
                    middleElementSum[0],
                    middleElementSum[1]
            );
        }
    }

    public int[] maxSubarraySumWithMiddle(int[] arr, int first, int middle, int last) {
        // Result: [maxLeft, maxRight, sum]
        int[] result = new int[3];

        int sum = 0;
        int leftSum = (int) Double.NEGATIVE_INFINITY;
        int rightSum = (int) Double.NEGATIVE_INFINITY;
        int maxLeft = 0;
        int maxRight = 0;

        // Sum from arr[middle] downto arr[first]
        for (int i = middle; i >= first; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;

        // Sum from arr[middle+1] to arr [last]
        for (int i = middle + 1; i <= last; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        result[0] = maxLeft;
        result[1] = maxRight;
        result[2] = leftSum + rightSum;

        return result;
    }
}
