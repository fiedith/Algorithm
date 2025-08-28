class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int len = nums.length;
        int[] LIS = new int[len];   // idx: 0 ~ len-1, value: longest subsequence count
        Arrays.fill(LIS, 1);    // init LIS

        // going backwards
        for(int i = len - 1; i > -1; i--){
            // check all indexes that comes after i where nums is greater than nums[i]
            for(int j = i + 1; j < len; j++){
                if(nums[i] < nums[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            max = Math.max(LIS[i], max);
        }
        return max;
    }
}