import java.util.*;

class Solution {
    private static int result = 0;
    private static Map<Character, Character> closingPairs = new HashMap<>();
    
    public int solution(String s) {
        // fast return on odd length
        if(s.length() % 2 != 0){
            return 0;
        }
        
        closingPairs.put('}', '{');
        closingPairs.put(')', '(');
        closingPairs.put(']', '[');
        
        if(validParenthesis(s) == -1){  // fast return on exceeding open parenthesis
            return 0;
        } 
        
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < sb.length(); i++){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            result += validParenthesis(sb.toString());
        }
        
        return result;
        
    }
    
    private static int validParenthesis(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // if opening parenthesis, push
            if(!closingPairs.containsKey(ch)){
                stack.push(ch);
            // if closing parenthesis, validate
            } else{
                // invalid case on empty stack or mismatching parenthesis
                if(stack.isEmpty() || stack.peek() != closingPairs.get(ch)){
                    return 0;
                }
                // if valid parenthesis, pop the top
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        } else{
            return -1;  // exceeding open parenthesis amt. case
        }
    }
    
    
}