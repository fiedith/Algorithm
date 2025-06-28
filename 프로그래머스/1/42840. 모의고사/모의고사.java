import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // 찍는 패턴들
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int answersLength = answers.length;
        int patternsLength = patterns.length;
        
        // 각 수포자가 맞힌 문제들 counter
        int[] counter = new int[patternsLength];
        
        for(int i = 0; i< answersLength; i++){
            for(int j = 0; j < patternsLength; j++){
                if(patterns[j][i % (patterns[j].length)] == answers[i]){
                    counter[j] += 1;
                }
            }
        }
        
        // 제일 많이 맞힌 정답수 판별
        int highest = counter[0];
        for(int i = 1; i < counter.length; i++){
            if(counter[i] > highest){
                highest = counter[i];
            }
        }
        
        // highest만치 맞힌 수포자들 배열로 담아 변환 후 반환
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