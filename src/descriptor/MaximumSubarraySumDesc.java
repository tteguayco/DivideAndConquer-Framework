package descriptor;

import aux.Problem;
import aux.Solution;

public class MaximumSubarraySumDesc implements Problem, Solution{

    private int[] arr;
    private int first;
    private int last;
    private int middle;

    public MaximumSubarraySumDesc(int[] arr, int first, int last) {
        this.setArr(arr);
        this.setFirst(first);
        this.setLast(last);

        calculateMiddle();
    }

    public void calculateMiddle() {
        setMiddle((first + last) / 2);
    }

    public int computeSum() {
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += getArr()[i];
        }

        return sum;
    }

    public int get(int index) {
        return getArr()[index];
    }

    public String toString() {
        String result = "";

        for (int i = first; i <= last; i++) {
            result += getArr()[i];
            if (i < last)
                result += ", ";
        }

        return result;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }
}
