class Solution {
    public int maxSubArray(int[] nums) {
        int max = -987654321;
        int sum = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(max, sum);
            // reset sum if negative
            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}