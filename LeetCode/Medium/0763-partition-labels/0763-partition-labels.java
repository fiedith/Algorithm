class Solution {
    public static List<Integer> partitionLabels(String s) {
        // K: char, V: int[2] (starting idx, ending idx)
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int[] arr = map.get(ch);
                arr[1] = i;
                map.put(ch, arr);
            } else{
                int[] arr = new int[]{i, i};
                map.put(ch, arr);
            }
        }

        List<Integer> result = new ArrayList<>();
        // init starting idx and limit idx
        int start = 0;
        int limit = map.get(s.charAt(0))[1];
        
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            // if current index is in limit, and current character's ending idx exceeds limit, update limit
            if(i < limit && map.get(ch)[1] > limit){
                limit = map.get(ch)[1];
            // else, only if current idx exceeds limit, add group to result, reset limit and start
            } else if(i > limit){
                result.add(i - start);
                limit = map.get(ch)[1];
                start = i;
            }
        }

        // remaining last group
        result.add(s.length() - start);

        return result;
    }
}