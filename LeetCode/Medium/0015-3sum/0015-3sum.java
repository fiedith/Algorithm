class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++){
            int target = -nums[i];
            if(visited.contains(target)){
                continue;
            }
            // since array is sorted, if current target < 0, cannot form sum to target
            if(target < 0){
                break;
            }

            visited.add(target);
            int lp = i + 1;
            int rp = nums.length - 1;

            while(lp < rp){
                int sum = nums[lp] + nums[rp];

                if(sum == target){
                    set.add(List.of(nums[i], nums[lp], nums[rp]));
                    rp--;   // try to search for other combinations within current possible range
                } else if(sum < target){
                    lp++;
                } else{
                    rp--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}