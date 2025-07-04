import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);     // initial push
        
        int i = 0;
        for(i = 1; i < arr.length; i++){
            if(stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }
        
        int[] answer = new int[stack.size()];
        for(i = 0; i < answer.length; i++){
            answer[i] = stack.pollLast();
        }
        
        return answer;
    }
}