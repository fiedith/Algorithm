class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;    // max element idx = depth - 1
        
        if (depth == 1){
            return triangle[0][0];
        }
        
        // init
        triangle[1][0] = triangle[1][0] + triangle[0][0];
        triangle[1][1] = triangle[1][1] + triangle[0][0];
        
        for(int i = 2; i < depth; i++){
            int[] currentArr = triangle[i];
            int maxIdx = currentArr.length - 1;
            
            for(int j = 0; j <= maxIdx; j++){
                if(j != 0 && j != maxIdx) {
                    triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                } else{
                    int nextJ = 0;
                    nextJ = j == 0 ? 0 : j - 1;
                    triangle[i][j] += triangle[i - 1][nextJ];
                }
            }
        }
        
        int result = 0;
        int[] lastRow = triangle[depth - 1];
        for(int num : lastRow){
            result = Math.max(result, num);
        }
        
        return result;
    }
}