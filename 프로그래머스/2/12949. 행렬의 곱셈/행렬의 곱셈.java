// 두 행렬 A(NxM), B(MxL)에 대해 행렬곱 AxB의 결과 행렬 C는 (NxL)
// 특정 (i, j) 위치 값은 SUM(A(i, 0)*B(0, j), A(i, 1)*B(1, j), ... A(i, M)*B(M,j)))

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int rowCount = arr1.length;
        int colCount = arr2[0].length;
        int common = arr1[0].length;    // 두 배열 NxM * MxL 에 대해 M값
        int[][] result = new int[rowCount][colCount];
        
        int mulVal = 0;  // 곱 결과
        
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                mulVal = 0;  // 곱셈 값 초기화
                for(int k = 0; k < common; k++){
                    mulVal += (arr1[i][k] * arr2[k][j]);
                }
                // 해당 위치에 곱셈 결과 넣기
                result[i][j] = mulVal;
            }
        }
        
        return result;
    }
}