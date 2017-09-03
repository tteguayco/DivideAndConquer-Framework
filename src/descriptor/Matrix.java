package descriptor;

import java.util.concurrent.ThreadLocalRandom;

public class Matrix {
    private static final int MIN_RND_VAL = 0;
    private static final int MAX_RND_VAL = 100;

    private int numRows;
    private int numCols;
    private int[][] matrix;

    public Matrix(int rows, int cols, boolean empty) {
        setNumRows(rows);
        setNumCols(cols);
        matrix = new int[rows][cols];

        if (!empty) {
            initializeValuesRandomly();
        }
    }

    public Matrix(Matrix aMatrix) {
        if (getNumRows() != aMatrix.getNumRows()
                || getNumCols() != aMatrix.getNumCols()) {
            throw new RuntimeException("Illegal matrix dimensions");
        }

        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                setVal(i, j, aMatrix.get(i, j));
            }
        }
    }

    private void initializeValuesRandomly() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom
                        .current()
                        .nextInt(MIN_RND_VAL, MAX_RND_VAL);
            }
        }
    }

    public int get(int row, int col) {
        return matrix[row][col];
    }

    public void setVal(int row, int col, int val) {
        matrix[row][col] = val;
    }

    public Matrix add(Matrix anOther) {
        Matrix result = new Matrix(getNumRows(), getNumCols(), true);

        if (getNumRows() != anOther.getNumRows()
                || getNumCols() != anOther.getNumCols()) {
            throw new RuntimeException("Illegal matrix dimensions");
        }

        int auxSum = 0;
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                auxSum = get(i, j) + anOther.get(i, j);
                result.setVal(i, j, auxSum);
            }
        }

        return result;
    }

    public Matrix subtract(Matrix anOther) {
        Matrix result = new Matrix(getNumRows(), getNumCols(), true);

        if (getNumRows() != anOther.getNumRows()
                || getNumCols() != anOther.getNumCols()) {
            throw new RuntimeException("Illegal matrix dimensions");
        }

        int auxSum = 0;
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                auxSum = get(i, j) - anOther.get(i, j);
                result.setVal(i, j, auxSum);
            }
        }

        return result;
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < matrix.length; i++) {
            result += "| ";
            for (int j = 0; j < matrix[i].length; j++) {
                result += matrix[i][j] + " ";
            }

            result += "\n";
        }

        return result;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
}
