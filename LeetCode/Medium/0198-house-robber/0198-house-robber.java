class Solution {
    public int rob(int[] nums) {
        int result = 0;

        int len = nums.length;
        if(len < 3){
            return len == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        } else{
            // init result first
            result = Math.max(nums[0], nums[1]);
        }

        for(int i = 2; i < len; i++){
            int currMax = 0;
            for(int j = 0; j < i - 1; j++){
                currMax = Math.max(currMax, nums[j]);
            }
            nums[i] = nums[i] + currMax;
            result = Math.max(nums[i], result);     // for each loop after idx 2, update result
        }
        
        return result;
    }
}