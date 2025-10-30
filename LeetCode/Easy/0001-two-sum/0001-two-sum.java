class Solution {
    class Number{
        int value;
        int idx;
        
        public Number(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Number[] arr = new Number[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Number(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.value, b.value));

        int lp = 0;
        int rp = nums.length - 1;
        
        while(lp < rp){
            int sum = arr[lp].value + arr[rp].value;
            if(sum == target){
                return new int[]{arr[lp].idx, arr[rp].idx};
            } else if(sum < target){
                lp++;
            } else{
                rp--;
            }
        }

        // will always return within loop
        return new int[2];
    }
}