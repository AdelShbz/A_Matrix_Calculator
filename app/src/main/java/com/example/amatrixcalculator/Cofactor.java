package com.example.amatrixcalculator;

public class Cofactor {

    //the Maxor method.
    static int maxor(int matrix[][], int row, int col, int n) {
        String[][] matrixInString = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixInString[i][j] = matrix[i][j] + "";
            }
        }
        for (int i = 0; i < n; i++) {
            matrixInString[row][i] = "";
            matrixInString[i][col] = "";
        }
        int[][] matrixResult = new int[n - 1][n - 1];
        String s = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixInString[i][j] != "") {
                    s += matrixInString[i][j] + " ";
                }
            }
        }
        String ss[] = s.split(" ");
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                matrixResult[i][j] = Integer.parseInt(ss[index]);
                ++index;
            }
        }

        return Determinant.determinantOfMatrix(matrixResult, n - 1);
    }

    static int[][] cofactorOfMatrix(int mat[][], int n) {
        int[][] matResult = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matResult[i][j] = ((int) Math.pow(-1, i + j)) * maxor(mat, i, j, n);
            }
        }
        return matResult;
    }
}
