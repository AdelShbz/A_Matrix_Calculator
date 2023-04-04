package com.example.amatrixcalculator;

public class Transpose {
    static int[][] transposeOfMatrix(int[][] mat, int n){
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = mat[j][i];
            }
        }
        return m;
    }
}
