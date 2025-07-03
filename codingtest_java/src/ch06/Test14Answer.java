package ch06;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test14Answer {

    public static String solution(int n, int k, String[] cmd) {
        Deque<Integer> deleted = new ArrayDeque<>();

        // 각 행 기준 연산에 따른 위치 표시용 배열
        // 첫번째와 맨 마지막 위치 삭제 시에도 정확히 반영해야 하므로 최상단, 최하단을 초과하는 가상공간 추가 -> n+2
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        // 각 인덱스별로 "내 위의 인덱스 값"과 "내 아래의 인덱스 값"을 설정
        // 이를 통해 인덱스 삭제 및 복구 구현 가능
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 현재 인덱스 위치 증가 (최상단 가상 공간 하나 추가됐으므로 초기 인덱스값 수정)
        k++;

        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);    // 삭제된 인덱스 스택에 넣기
                // 삭제된 인덱스의 상하 인덱스값을 수정해야 함
                up[down[k]] = up[k];    // 내 아래의 up 값을 내 현재 up 값으로 바꾸고
                down[up[k]] = down[k];      // 내 위의 down값을 내 현재 down 값으로 바꾼다
                // 그 후 현재 인덱스 위치를 바꿔야 하는데,
                // 만약 내 아래가 인덱스 범위 초과시 위로 올린다
                if(n < down[k]){
                    k = up[k];
                } else{     // 초과하지 않은 경우 아래로 내린다
                    k = down[k];
                }
            } else if (c.startsWith("Z")){
                int rollback = deleted.pop();
                up[down[rollback]] = rollback;  // 롤백 인덱스의 아래 인덱스의 윗 값을 롤백 인덱스로 설정
                down[up[rollback]] = rollback;  // 롤백 인덱스의 위 인덱스의 아랫 값을 롤백 인덱스로 설정
            }

            else{
                String[] s = c.split(" ");
                int moveCount = Integer.parseInt(s[1]);
                // move count만큼 인덱스값을 위로 올리거나 아래로 올리기
                for (int i = 0; i < moveCount; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        char[] result = new char[n];
        Arrays.fill(result, 'O');

        while (!deleted.isEmpty()) {
            result[deleted.pop() - 1] = 'X';
        }

        return new String(result);
    }

}
