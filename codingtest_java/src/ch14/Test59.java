package ch14;

import java.util.Arrays;

public class Test59 {

    public static int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotateRight(arr);
        }

        return arr;
    }

    // 왼쪽 90도 회전 (반시계방향)
    private static int[][] rotateLeft(int[][] arr) {
        int size = arr.length;

        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[(size - 1) - j][i] = arr[i][j];
            }
        }
        return result;
    }

    // 오른쪽 90도 회전 (시계방향)
    public static int[][] rotateRight(int[][] arr) {
        int size = arr.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[j][(size - 1) - i] = arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] result = solution(arr, 1);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}