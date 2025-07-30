import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        
        int half = nums.length / 2;
        int setSize = set.size();
        return Math.min(half, setSize);
    }
}