class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;

        while(lp < rp){
            int sum = numbers[lp] + numbers[rp];
            if(target == sum) {
                break;
            } else if(sum < target){
                lp++;
            } else{
                rp--;
            }
        }

        // 1-based arr
        return new int[]{lp + 1, rp + 1};
    }
}