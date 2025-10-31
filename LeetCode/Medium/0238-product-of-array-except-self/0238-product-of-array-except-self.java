class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroPos = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
                // if zero position is set as -1, there were no other 0s yet
                if(zeroPos == -1){
                    zeroPos = i;
                    continue;
                    // if value = 0 and already encountered zero, return [0, 0, ... 0]
                } else{
                    return new int[nums.length];
                }
            }
            // set product for nonzero cases
            product *= nums[i];
        }

        int[] result = new int[nums.length];

        // if nums contains single zero, simply set product val to zeroPos & return
        if(zeroPos != -1){
            result[zeroPos] = product;
            return result;
        } else{
            for(int i = 0; i < nums.length; i++){
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}