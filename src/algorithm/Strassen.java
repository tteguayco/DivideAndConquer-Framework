package algorithm;

import aux.Problem;
import aux.Solution;
import descriptor.Matrix;
import descriptor.StrassenDesc;
import template.DivideConquerTemplate;

public class Strassen extends DivideConquerTemplate {
    @Override
    protected boolean isSimple(Problem p) {
        StrassenDesc problem = (StrassenDesc) p;
        int n = ((StrassenDesc) p).getA().getNumRows();

        if (n == 1) {
            return true;
        }

        return false;
    }

    @Override
    protected Solution simplySolve(Problem p) {
        int result;
        Matrix A = ((StrassenDesc)p).getA();
        Matrix B = ((StrassenDesc)p).getB();
        Matrix C = ((StrassenDesc)p).getC();

        result = A.get(0, 0) * B.get(0, 0);
        C.setVal(0, 0, result);

        return new StrassenDesc(C);
    }

    @Override
    protected Problem[] decompose(Problem p) {
        StrassenDesc[] ps = new StrassenDesc[7];

        Matrix A = ((StrassenDesc)p).getA();
        Matrix B = ((StrassenDesc)p).getB();
        Matrix C = ((StrassenDesc)p).getC();

        Matrix A11 = new Matrix(A.getNumRows() / 2, A.getNumCols() / 2, true);
        Matrix A12 = new Matrix(A.getNumRows() / 2, A.getNumCols() / 2, true);
        Matrix A21 = new Matrix(A.getNumRows() / 2, A.getNumCols() / 2, true);
        Matrix A22 = new Matrix(A.getNumRows() / 2, A.getNumCols() / 2, true);

        Matrix B11 = new Matrix(B.getNumRows() / 2, B.getNumCols() / 2, true);
        Matrix B12 = new Matrix(B.getNumRows() / 2, B.getNumCols() / 2, true);
        Matrix B21 = new Matrix(B.getNumRows() / 2, B.getNumCols() / 2, true);
        Matrix B22 = new Matrix(B.getNumRows() / 2, B.getNumCols() / 2, true);

        A11 = submatrix(A, 0, 0);
        A12 = submatrix(A, 0, A.getNumCols() / 2);
        A21 = submatrix(A, A.getNumRows() / 2, 0);
        A22 = submatrix(A, A.getNumRows() / 2, A.getNumCols() / 2);

        B11 = submatrix(B, 0, 0);
        B12 = submatrix(B, 0, B.getNumCols() / 2);
        B21 = submatrix(B, B.getNumRows() / 2, 0);
        B22 = submatrix(B, B.getNumRows() / 2, B.getNumCols() / 2);

        ps[0] = new StrassenDesc(A11.add(A22), B11.add(B22));
        ps[1] = new StrassenDesc(A21.add(A22), B11);
        ps[2] = new StrassenDesc(A11, B12.subtract(B22));
        ps[3] = new StrassenDesc(A22, B21.subtract(B11));
        ps[4] = new StrassenDesc(A11.add(A12), B22);
        ps[5] = new StrassenDesc(A21.subtract(A11), B11.add(B12));
        ps[6] = new StrassenDesc(A12.subtract(A22), B21.add(B22));

        return ps;
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        StrassenDesc[] simpleSolutions = new StrassenDesc[ss.length];
        for (int i = 0; i < ss.length; i++) {
            simpleSolutions[i] = (StrassenDesc) ss[i];
        }

        Matrix C11 = simpleSolutions[0].getC().add(simpleSolutions[3].getC())
                .subtract(simpleSolutions[4].getC()).add(simpleSolutions[6].getC());
        Matrix C12 = simpleSolutions[2].getC().add(simpleSolutions[4].getC());
        Matrix C21 = simpleSolutions[1].getC().add(simpleSolutions[3].getC());
        Matrix C22 = simpleSolutions[0].getC().subtract(simpleSolutions[1].getC())
                .add(simpleSolutions[2].getC()).add((simpleSolutions[5].getC()));

        Matrix C = new Matrix(C11.getNumRows() * 2, C11.getNumCols() * 2, true);
        combineMatrix(C, C11, 0, 0);
        combineMatrix(C, C12, 0, C.getNumCols() / 2);
        combineMatrix(C, C21, C.getNumRows() / 2, 0);
        combineMatrix(C, C22, C.getNumRows() / 2, C.getNumCols() / 2);

        return new StrassenDesc(C);
    }

    private Matrix submatrix(Matrix aMatrix, int rowFrom, int colFrom) {
        Matrix submatrix = new Matrix(aMatrix.getNumRows() / 2, aMatrix.getNumCols() / 2, true);
        int thisRow = 0;
        int thisCol = 0;

        for (int i = rowFrom; i < rowFrom + aMatrix.getNumRows() / 2; i++) {
            for (int j = colFrom; j < colFrom + aMatrix.getNumCols() / 2; j++) {
                submatrix.setVal(thisRow, thisCol, aMatrix.get(i, j));
                thisCol++;
            }
            thisCol = 0;
            thisRow++;
        }

        return submatrix;
    }

    private void combineMatrix(Matrix parentMatrix, Matrix submatrix, int rowFrom, int colFrom) {
        int submatrixRow = 0;
        int submatrixCol = 0;

        for (int i = rowFrom; i < rowFrom + parentMatrix.getNumRows() / 2; i++) {
            for (int j = colFrom; j < colFrom + parentMatrix.getNumCols() / 2; j++) {
                parentMatrix.setVal(i, j, submatrix.get(submatrixRow, submatrixCol));
            }
            submatrixCol = 0;
            submatrixRow++;
        }
    }
}
