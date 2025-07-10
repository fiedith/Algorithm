import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> cMap = new HashMap<>(completion.length);
        
        for(String c : completion){
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }
        
        for(String p : participant){
            // return inexisting or actual 0 valued string in map
            if(cMap.getOrDefault(p, 0) == 0){
                return p;
            }
            cMap.put(p, cMap.get(p) - 1);
        }
        
        // 위 반복문에서 반드시 리턴됨
        return "";
    }
}