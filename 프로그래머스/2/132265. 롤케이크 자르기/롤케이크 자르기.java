import java.util.Map;
import java.util.HashMap;


class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> baseMap = new HashMap<>();
        Map<Integer, Integer> partner = new HashMap<>();
        int result = 0;
        
        // init base map
        for(int n : topping){
            baseMap.put(n, baseMap.getOrDefault(n, 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++){
            if(baseMap.size() < partner.size()){
                break;
            }
            
            int currentTopping = topping[i];
            
            if(baseMap.containsKey(currentTopping)){
                baseMap.put(currentTopping, baseMap.get(currentTopping) - 1);
            } 
            
            if(baseMap.get(currentTopping) == 0){
                baseMap.remove(currentTopping);
            }
            
            partner.put(currentTopping, partner.getOrDefault(currentTopping, 0) + 1);
            
            if(partner.size() == baseMap.size()){
                result++;
            }
        }
        
        return result;
        
    }
}