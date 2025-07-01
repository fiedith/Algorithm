import java.util.*;

class Solution {
    public static int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        
        for(char ch : chars){
            // 스택에 값이 없거나 상단값이 현재 값과 불일치 시 스택에 넣음
            if(stack.peek() == null || !stack.peek().equals(ch)){
                stack.push(ch);
            } else{
                stack.pop();
            }
        }
        
        // 전부 수행후 스택이 비어있다면 정답
        if(stack.isEmpty()){
            return 1;   // early return
        }
        
        return 0;
    }
}