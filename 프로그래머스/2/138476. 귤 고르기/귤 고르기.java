import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int result = 0;
        
        for(int c : list){
            if(k <= 0){
                break;
            }
            
            k -= c;
            result++;
        }
        
        return result;
    }
}