import java.util.*;

public class Solution {
    public static int[] solution(int[] prices) {

        int arrLen = prices.length;
        int[] answer = new int[arrLen];

        A: for(int i = 0; i < arrLen - 1; i++) {
            for(int j = i; j < arrLen - 1; j++){
                answer[i]++;
                // 다음 가격에서 하락하는 경우 inner loop 탈출
                if(prices[i] > prices[j + 1]) {
                    continue A;
                }
            }
        }
        // 마지막 요소는 0으로 기록
        answer[arrLen - 1] = 0;
        return answer;
    }
}