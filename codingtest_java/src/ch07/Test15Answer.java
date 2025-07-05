package ch07;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test15Answer {

    public static int solution(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        // loop til deque contains only one element
        while (deque.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }

        return deque.pollFirst();
    }
}
