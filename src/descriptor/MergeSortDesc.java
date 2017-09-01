package descriptor;

import aux.Problem;
import aux.Solution;

public class MergeSortDesc implements Problem, Solution {
    private int[] arr;

    public MergeSortDesc(int[] anArr) {
        setArr(anArr);
    }

    public int size() {
        return arr.length;
    }

    public int get(int index) {
        return getArr()[index];
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1)
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
}
