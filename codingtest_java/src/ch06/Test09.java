package ch06;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test09 {

    private static String solution(int s) {
        Deque<Integer> stack = new ArrayDeque<>();

        if (s == 1) {
            return "1";
        }

        // set initial dividend
        int dividend = s;

        while (dividend != 1) {
            stack.push(dividend % 2);
            dividend = dividend / 2;
        }

        StringBuilder sb = new StringBuilder();
        // 1값을 먼저 추가
        sb.append(1);

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
