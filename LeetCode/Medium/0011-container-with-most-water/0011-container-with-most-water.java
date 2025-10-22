class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int result = 0;

        while(l != r){
            result = Math.max((r - l) * Math.min(height[r], height[l]), result);
            // move the min height pointer
            if(height[l] >= height[r]){
                r--;
            } else{
                l++;
            }
        }

        return result;
    }
}