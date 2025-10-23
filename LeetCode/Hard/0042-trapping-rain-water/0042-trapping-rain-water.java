/**
 * The amount of water that can be trapped at any single position i is determined by: 
 * the shortest of the two tallest walls to its left and right
 */

class Solution {
    public static int trap(int[] height) {
        // init all
        int l = 0;
        int r = height.length - 1;

        int lMax = height[l];
        int rMax = height[r];

        int result = 0;

        // loop til each meet
        while(l < r){
            if(rMax < lMax){
                r--;
                rMax = Math.max(height[r], rMax);
                result += rMax - height[r];     // will not cause negative values since rMax is pre-updated
            } else{
                l++;
                lMax = Math.max(height[l], lMax);
                result += lMax - height[l];     // same as above
            }
        }

        return result;
    }
}