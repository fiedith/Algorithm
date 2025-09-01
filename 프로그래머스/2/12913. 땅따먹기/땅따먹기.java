import java.util.*;

class Solution {
    // dp table. dp[i][n] = max possible result when picking land[i][n]
    private static int[][] dp;
    
    private static int getMax(int row, int col){
        int[] pastArr = dp[row - 1];
        int max = 0;
        for(int i = 0; i < 4; i++){
            if(i == col){
                continue;
            }
            max = Math.max(pastArr[i], max);
        }
        
        return max;
    }
    
    // max col length is always given as 4
    public static int solution(int[][] land) {
        int len = land.length;  // max idx = len - 1
        
        // init dp and first row
        dp = new int[len][4];
        dp[0] = Arrays.copyOf(land[0], 4);

        for(int i = 1; i < len; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j] = land[i][j] + getMax(i, j);
            }
        }
        
        // get max of last row 
        // set row idx as maxIdx + 1, col idx as any num out of range 0~3
        return getMax(len, -1);
    }
}