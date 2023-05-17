package com.example.amatrixcalculator;

// Adjoint or Adjugate of matrix
public class Adjoint {
    static int[][] adjointOfMatrix(int mat[][], int n) {
        int[][] Tmat = Transpose.transposeOfMatrix(mat, n, n);
        return Cofactor.cofactorOfMatrix(Tmat, n);
    }
}
