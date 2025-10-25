import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        int[] result = new int[prices.length];
        
        for(int i = 1; i < prices.length; i++){
            // if price fall occurs, pop til the point where price fall stops
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int poppedIdx = stack.pop();
                result[poppedIdx] = i - poppedIdx;
            }
            stack.push(i);
        }
        
        // remaining idxs = no price fall occurred
        while(!stack.isEmpty()){
            int poppedIdx = stack.pop();
            result[poppedIdx] = prices.length - 1 - poppedIdx;
        }
        
        return result;
    }
}