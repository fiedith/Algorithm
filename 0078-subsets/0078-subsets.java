class Solution {
    private static List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(nums, 0, currentList);
        return result;
    }

    private static void dfs(int[] nums, int start, List<Integer> currentList){
        if(start >= nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[start]);
        dfs(nums, start + 1, currentList);
        currentList.remove(currentList.size() - 1);
        dfs(nums, start + 1, currentList);
    }
}