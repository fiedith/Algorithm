// 두 행렬 A(NxM), B(MxL)에 대해 행렬곱 AxB의 결과 행렬 C는 (NxL)
// 특정 (i, j) 위치 값은 SUM(A(i, 0)*B(0, j), A(i, 1)*B(1, j), ... A(i, M)*B(M,j)))

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int rowCount = arr1.length;
        int colCount = arr2[0].length;
        int common = arr1[0].length;    // 두 배열 NxM * MxL 에 대해 M값
        
        // 행렬곱 결과 배열
        int[][] result = new int[rowCount][colCount];
        
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                for(int k = 0; k < common; k++){
                    result[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        
        return result;
    }
}