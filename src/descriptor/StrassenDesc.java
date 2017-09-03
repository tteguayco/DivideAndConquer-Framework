package descriptor;

import aux.Problem;
import aux.Solution;

public class StrassenDesc implements Problem, Solution {
    private Matrix A;
    private Matrix B;
    private Matrix C;

    public StrassenDesc(Matrix A, Matrix B) {
        if (A.getNumCols() != B.getNumRows()) {
            throw new RuntimeException("Matrices multiplication: wrong dimensions");
        }

        this.setA(A);
        this.setB(B);

        C = new Matrix(A.getNumRows(), B.getNumCols(), true);
    }

    public StrassenDesc(Matrix C) {
        this.setC(C);
    }

    public Matrix getA() {
        return A;
    }

    public void setA(Matrix a) {
        A = a;
    }

    public Matrix getB() {
        return B;
    }

    public void setB(Matrix b) {
        B = b;
    }

    public Matrix getC() {
        return C;
    }

    public Matrix getResult() {
        return getC();
    }

    public void setC(Matrix c) {
        C = c;
    }
}
