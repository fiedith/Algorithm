package ch12;

import java.util.ArrayList;
import java.util.List;

public class Test43 {

    private static List<List<Integer>> answer;
    private static int max;

    private static void solution(int n) {
        answer = new ArrayList<>();
        max = n;
        backtrack(0, 1, new ArrayList<Integer>());
        return;
    }

    private static void backtrack(int sum, int start, List<Integer> list) {
        if (sum == 10) {        // 정답 확인
            answer.add(list);
            return;
        }

        for (int i = start; i < max + 1; i++) {
            if (sum + i <= 10) {    // 가지치기
                ArrayList<Integer> arrayList = new ArrayList<>(list);   // 현재 호출 파라미터의 list 데이터를 복사 -> 원본 depth의 데이터 변동 없으므로 데이터 원복 과정 별도 필요없음
                arrayList.add(i);
                backtrack(sum + i, i + 1, arrayList);
            }
        }

    }

    public static void main(String[] args) {
        solution(7);
        System.out.println(answer);
    }

}
