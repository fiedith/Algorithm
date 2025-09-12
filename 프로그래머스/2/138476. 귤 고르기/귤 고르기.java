import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // worst case: 100,000
        Arrays.sort(tangerine);
        int max = tangerine[tangerine.length - 1];
        
        // idx = size, val = number of tangerines for each size
        int[] quantity = new int[max + 1];
        
        // worst case: 100,000
        for(int t : tangerine){
            quantity[t] += 1;
        }
        
        // worst case: 10,000,000
        Arrays.sort(quantity);
        
        // worst case: 10,000,000
        for(int i = max; i >= 0; i--){
            if(k <= 0){
                break;
            }
            k -= quantity[i];
            answer++;
        }
        
        return answer;
    }
}