class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        // LCS[i][N] = arr1[i - 1]
        // LCS[M][j] = arr2[j - 1]
        int[][] LCS = new int[len1 + 1][len2 + 1];
        for(int i = 1; i < LCS.length; i++){
            for(int j = 1; j < LCS[0].length; j++){
                if(arr1[i - 1] == arr2[j - 1]){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else{
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        return LCS[len1][len2];
    }
}