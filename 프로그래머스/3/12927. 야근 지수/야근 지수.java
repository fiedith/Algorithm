import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int w : works){
            pq.add(w);
        }
        
        while(n > 0 && !pq.isEmpty()){
            int polled = pq.poll();
            polled--;
            n--;
            if(polled == 0){
                continue;
            }
            pq.add(polled);
        }
        
        long result = 0;
        if(pq.isEmpty()){
            return 0;
        } else{
            while(!pq.isEmpty()){
                int polled = pq.poll();
                result += polled * polled;
            }
            return result;
        }
    }
}