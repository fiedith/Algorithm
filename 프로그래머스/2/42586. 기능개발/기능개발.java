import java.util.*;

// 각 작업별 배포일자를 먼저 계산해서 복잡도 낮추는 enhancement
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int n = progresses.length;
        int[] releaseDays = new int[n];    // deployable days per job
        List<Integer> result = new ArrayList<>();
        
        // init releases
        for(int i = 0; i < n; i++){
            releaseDays[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // init head release day
        int head = releaseDays[0];
        int tasks = 0;  // deployable jobs per release
        
        for(int i = 0; i < n; i++){
            if(releaseDays[i] <= head){
                tasks++;
            } else{
                result.add(tasks);  // add deployable job count in result
                head = releaseDays[i];  // set next head job at current
                tasks = 1;
            }
        }
        result.add(tasks);  // add remaining
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}