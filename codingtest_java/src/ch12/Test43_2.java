package ch12;

import java.util.ArrayList;
import java.util.List;

class Test43_2 {
    // 1 ~ n 수
    private static List<List<Integer>> result;
    private static int max;

    public static List<List<Integer>> solution(int n) {
        result = new ArrayList<>();
        max = n;
        List<Integer> currentList = new ArrayList<>();
        dfs(currentList, 1, 0);
        return result;
    }

    private static void dfs(List<Integer> currentList, int now, int sum) {
        if (sum == 10) {    // 가지치기 1: 합이 10 만족시 결과에 추가 후 리턴
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (sum > 10) {     // 가지치기 2: 합이 10 초과 시 더이상 진행 X
            return;
        }

        for (int i = now; i <= max; i++) {
            currentList.add(i);
            dfs(currentList, i + 1, sum + i);   // 다음 수부터 loop시작, sum 합
            currentList.remove(currentList.size() - 1);     // 원상복구 -> backtrack
        }
    }

    public static void main(String[] args) {
        solution(7);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}