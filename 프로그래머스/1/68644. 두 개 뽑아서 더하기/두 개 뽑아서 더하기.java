import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int numbersLength = numbers.length;
        
        // take array's elements' sums
        Set<Integer> sumSet = new HashSet<>();
        
        for(int i = 0; i < numbersLength - 1; i++){
            for(int j = i+1; j < numbersLength; j++){
                sumSet.add(numbers[i] + numbers[j]);
            }
        }
        
        // map all values in set to array as primitive type
        int[] result = sumSet.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        // sort result array & return
        Arrays.sort(result);
        return result;
        
    }
}