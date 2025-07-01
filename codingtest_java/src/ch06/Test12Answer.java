package ch06;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test12Answer {

    public static int[] solution(int[] prices) {

        int arrLen = prices.length;
        int[] answer = new int[arrLen]; // 가격이 하락하지 않은 기간을 저장할 정답 배열

        /**
         * 인덱스 값을 저장할 스택
         * 아직 하락 기간이 확정되지 않은 인덱스들이 저장된다
         */
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);  // init

        for (int i = 1; i < arrLen; i++) {
            // 현재 가격보다 이전(확정되지 않은 인덱스의) 가격이 더 높은 경우, 즉 가격 하락이 발생한 경우
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();    // 그 인덱스는 이제 기간을 확정할 것이므로 pop한 후,
                answer[j] = i - j;      // 그 인덱스의 기간 값을 정하는데 이때 기간은 서로의 인덱스값 차이로 나타낸다
            }
            stack.push(i);  // 이제 현재 위치 인덱스의 가격 하락 기간을 정하기 위해 스택에 삽입
        }
        // 배열 길이만치 위 과정을 다 겪고 난 후 남아있는 요소에 대해서 기간을 마저 확정해야 함,
        // 즉 아직 하락을 못 겪은 지점들은 스택에 그대로 남아있음
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = arrLen - 1 - j;     // 하락을 못 만난 요소들의 길이를 확정 (마지막 인덱스 위치에서 해당 인덱스값의 차)
        }
        return answer;
    }

    // test cases
    public static void main(String[] args) {

        int[][] inputs = {
                {1, 2, 3, 2, 1},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5}
        };

        for (int[] input : inputs) {
            System.out.println("result = " + Arrays.toString(solution(input)));
        }
    }
}
