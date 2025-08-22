package ch14;

import java.util.Arrays;

public class Test60 {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = new int[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] result = transpose(multiply(matrix1, matrix2));
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    // matrix1의 row_count == matrix2의 col_count
    private static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int common = matrix2.length;    // or matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // NxM matrix -> MxN matrix
    private static int[][] transpose(int[][] matrix) {
        int cols = matrix.length;      // 전치 후의 cols count
        int rows = matrix[0].length;    // 전치 후의 rows count

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
