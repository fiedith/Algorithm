import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] firstPattern = {1, 2, 3, 4, 5};   // 5개 주기
        int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개 주기
        int[] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    // 10개 주기
        
        int answersLength = answers.length;
        
        
        int[] counter = {0, 0, 0};
        
        for(int i = 0; i< answersLength; i++){
            int currentAnswer = answers[i];
            if(currentAnswer == firstPattern[i % 5]){
                counter[0] += 1;
            }
            
            if(currentAnswer == secondPattern[i % 8]){
                counter[1] += 1;
            }
            
            if(currentAnswer == thirdPattern[i % 10]){
                counter[2] += 1;
            }
        }
        
        int highest = counter[0];
        for(int i = 1; i < counter.length; i++){
            if(counter[i] > highest){
                highest = counter[i];
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < counter.length; i++){
            if(counter[i] == highest){
                result.add(i+1);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}