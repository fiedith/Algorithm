import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        
        // init each queues
        for(String s : cards1){
            q1.addLast(s);
        }
        for(String s : cards2){
            q2.addLast(s);
        }
        
        for(String s : goal){
            if(!q1.isEmpty() && q1.peek().equals(s)){
                q1.pollFirst();
            } else if(!q2.isEmpty() && q2.peek().equals(s)){
                q2.pollFirst();
            } else{
                return "No";
            }
        }
        
        return "Yes";
        
    }
}