import java.util.*;


class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> baseMap = new HashMap<>();
        Set<Integer> partner = new HashSet<>();
        int result = 0;
        
        // init base map
        for(int n : topping){
            baseMap.put(n, baseMap.getOrDefault(n, 0) + 1);
        }
        
        for(int n : topping){
            if(baseMap.size() < partner.size()){
                break;
            }
            
            partner.add(n);
            baseMap.put(n, baseMap.get(n) - 1);
            
            if(baseMap.get(n) == 0){
                baseMap.remove(n);
            }
            
            if(partner.size() == baseMap.size()){
                result++;
            }
        }
        
        return result;
        
    }
}