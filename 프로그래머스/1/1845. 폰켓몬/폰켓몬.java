import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int half = nums.length / 2;
        for(int num : nums){
            set.add(num);
        }
        int setSize = set.size();
        
        if(half > setSize){
            return setSize;
        } else{
            return half;
        }
    }
}