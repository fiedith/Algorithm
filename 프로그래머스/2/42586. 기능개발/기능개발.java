import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        // edge case
        if(len == 1){
            return new int[]{1};
        }
        
        int[] daysToDeploy = new int[len];
        
        for(int i = 0; i < len; i++){
            // remaining task time
            daysToDeploy[i] = 100 - progresses[i];  
            // round up
            if(daysToDeploy[i] % speeds[i] != 0){
                daysToDeploy[i] = (daysToDeploy[i] / speeds[i]) + 1;
            } else {
                daysToDeploy[i] = daysToDeploy[i] / speeds[i];
            }
        }
        
        // base point
        int bp = daysToDeploy[0];
        int counter = 1;
        List<Integer> result = new ArrayList<>();
        
        // stack unnecessary, can simply loop in arr
        for(int i = 1; i < len; i++){
            if(daysToDeploy[i] <= bp) {
                counter++;
            } else {
                bp = daysToDeploy[i];
                result.add(counter);
                counter = 1;    // reset counter
            }
        }
        
        result.add(counter);    // add last one
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}