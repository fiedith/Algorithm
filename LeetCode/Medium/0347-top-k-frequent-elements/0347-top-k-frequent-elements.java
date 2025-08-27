class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> sortedList = map.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // desc
        .map(e -> e.getKey())   // returns Stream<Integer>
        .collect(Collectors.toList());  // collect each to list

        int[] result = new int[k];
        // top k
        for(int i = 0; i < k; i++){
            result[i] = sortedList.get(i);
        }

        return result;
    }
}