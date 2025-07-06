import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        List<Integer> progressList = new ArrayList<>(
            Arrays.stream(progresses).boxed().collect(Collectors.toList())
        );

        List<Integer> speedList = new ArrayList<>(
            Arrays.stream(speeds).boxed().collect(Collectors.toList())
        );
        
        List<Integer> result = new ArrayList<>();
        
        while(!progressList.isEmpty()){
            int popped = 0;
            for(int i = 0; i < progressList.size(); i++){
                progressList.set(i, progressList.get(i) + speedList.get(i));
            }
            while(!progressList.isEmpty() && progressList.get(0) >= 100){
                progressList.remove(0);
                speedList.remove(0);
                popped++;
            }
            if(popped != 0){
                result.add(popped);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        
    }
}