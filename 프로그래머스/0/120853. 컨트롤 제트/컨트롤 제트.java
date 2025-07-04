import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        String[] commands = s.split(" ");
        int answer = 0;
        
        for(String val : commands){
            if(val.equals("Z")){
                int popped = Integer.parseInt(stack.pop());
                answer -= popped;
            } else{
                stack.push(val);
                answer += Integer.parseInt(val);
            }
        }
        
        return answer;
    }
}