package descriptor;

import aux.Problem;
import aux.Solution;

public class FindMaximumDesc implements Problem, Solution {
    private int[] arr;
    private int first;
    private int last;
    private int max;

    public FindMaximumDesc(int[] anArr, int aFirst, int aLast) {
        arr = anArr;
        first = aFirst;
        last = aLast;
    }

    public int size() {
        return last - first + 1;
    }

    public int get(int index) {
        return arr[index];
    }

    public String toString() {
        String result = "";

        for (int i = first; i < last; i++) {
            result += arr[i];
            if (i < last - 1)
                result += ", ";
        }

        return result;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
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

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
