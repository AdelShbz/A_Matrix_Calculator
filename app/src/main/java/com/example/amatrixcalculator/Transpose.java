package com.example.amatrixcalculator;

public class Transpose {
    static int[][] transposeOfMatrix(int[][] mat, int R, int C){
        int[][] m = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                m[i][j] = mat[j][i];
            }
        }
        return m;
    }
}
