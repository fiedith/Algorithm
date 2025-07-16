class Solution {
    public int[] twoSum(int[] nums, int target) {
        // k: val, v: index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i], i);
        }

        int n = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            n = target - nums[i];
            if(map.containsKey(n) && map.get(n) != i){
                result.add(i);
                result.add(map.get(n));
                break;
            }
        }

        return result.stream()
        .mapToInt(Integer::intValue)
        .toArray();
    }
}
