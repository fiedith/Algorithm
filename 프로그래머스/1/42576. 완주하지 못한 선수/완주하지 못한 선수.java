import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> cMap = new HashMap<>(completion.length);
        
        for(String c : completion){
            if(!cMap.keySet().contains(c)){
                cMap.put(c, 1);
            } else{
                cMap.put(c, cMap.get(c) + 1);
            }
        }
        
        for(String p : participant){
            if(!cMap.keySet().contains(p)){
                return p;
            } else if(cMap.get(p) == 1){
                cMap.remove(p);
            } else{
                cMap.put(p, cMap.get(p) - 1);
            }
        }
        
        
        return "";
    }
}