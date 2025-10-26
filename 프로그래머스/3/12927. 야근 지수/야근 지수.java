import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int w : works){
            pq.add(w);
        }
        
        while(n > 0 && !pq.isEmpty()){
            int polled = pq.poll();
            if(polled <= 0){
                break;
            }
            
            n--;
            if(polled > 1){
                pq.add(polled - 1);
            }
            
        }
        
        long result = 0;
        while(!pq.isEmpty()){
            long val = pq.poll();
            result += val * val;
        }
        
        return result;
    }
}