import java.util.*;
import java.util.function.BiPredicate;

class Solution {
    public int[] solution(int n, String[] words) {
        // init set
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        int[] answer = new int[]{0, 0};
        
        for(int i = 1; i < words.length; i++){
            String past = words[i - 1];
            String current = words[i];
            
            // 기존에 나온 단어가 아니고, 끝말잇기가 성공적
            if(!set.contains(current) && past.charAt(past.length() - 1) == current.charAt(0)){
                set.add(current);
            } else{
                int player = (i % n) + 1;
                int cycle = (i / n) + 1;
                answer[0] = player;
                answer[1] = cycle;
                return answer;
            }
        }
        // if never returned in loop, return {0, 0}
        return answer;
    }
}