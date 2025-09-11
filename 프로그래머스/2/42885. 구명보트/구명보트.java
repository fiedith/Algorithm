import java.util.Arrays;

public class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int result = 0;
        
        while(left <= right){
            // sum(min, max) < limit -> let both board the boat
            // if exceeds, won't trigger and will only let max-weighted onboard
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            result++;
        }
        
        return result;
    }

}