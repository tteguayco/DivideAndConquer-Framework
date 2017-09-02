package descriptor;

import aux.Problem;
import aux.Solution;

public class BinarySearchDesc implements Problem, Solution {
    private int[] sortedArray;
    private int first;
    private int last;
    private int valueToSearch;
    private int indexOfValue;

    public BinarySearchDesc(int[] aSortedArray, int aFirst, int aLast, int aValueToSearch) {
        setSortedArray(aSortedArray);
        setFirst(aFirst);
        setLast(aLast);
        setValueToSearch(aValueToSearch);
        indexOfValue = -1;
    }

    public int get(int index) {
        return sortedArray[index];
    }

    public void setIndexOfValue(int index) {
        indexOfValue = index;
    }

    public int getIndexOfValue() {
        return indexOfValue;
    }

    public String toString() {
        String result = "";

        result += "Array: ";
        for (int i = first; i < last + 1; i++) {
            result += sortedArray[i];
            if (i < last)
                result += ", ";
        }

        return result;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
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

    public int getValueToSearch() {
        return valueToSearch;
    }

    public void setValueToSearch(int valueToSearch) {
        this.valueToSearch = valueToSearch;
    }
}
