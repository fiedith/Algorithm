import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        
        int answer = 1;
        
        // (입을 수 있는 각 종류 개수 + 안입는 경우)
        for(Integer val : map.values()){
            answer *= (val + 1);
        }
        
        // 아무것도 입지 않는 경우는 제외
        return answer - 1;
    }
}