package com.example.amatrixcalculator;

public class Inverse {
    static float[][] inverseOfMatrixInFloat(int[][] mat, int n) {
        int[][] matAdj = Adjoint.adjointOfMatrix(mat, n);
        float[][] matResult = new float[n][n];
        float coefficient = (float) 1 / (float) Determinant.determinantOfMatrix(mat, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matResult[i][j] = Float.parseFloat(String.format("%.3f", coefficient * matAdj[i][j]));
            }
        }
        return matResult;
    }

    static String[][] inverseOfMatrixInString(int[][] mat, int n) {
        int[][] matAdj = Adjoint.adjointOfMatrix(mat, n);
        String[][] matResult = new String[n][n];
        int coefficient = Determinant.determinantOfMatrix(mat, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matResult[i][j] = matAdj[i][j] + "/" + coefficient;
            }
        }
        return matResult;
    }
}
