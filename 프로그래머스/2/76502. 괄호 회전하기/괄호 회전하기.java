import java.util.*;

public class Solution {

    public static int solution(String s) {

        int strLen = s.length();
        // optimization: 애초에 홀수 문자열이 들어온 경우에는 정답이 없음
        if (strLen % 2 != 0) {
            return 0;
        }

        Map<Character, Character> map = new HashMap<>();

        // 각 닫힘 괄호에 대해 열림 괄호를 mapping시킴
        // 따라서 닫힘 괄호를 key로 찾아서 그 value가 알맞는 열림 괄호인지 판별 가능해진다
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // *원본 문자열을 이어붙여 2배로 만들어줌 -> 이를 통해 왼쪽으로 1칸씩 이동 구현*
        s += s;
        int answer = 0;

        // *label 기능 활용하기*
        A: for (int i = 0; i < strLen; i++) {   // outer loop: valid bracket 검사 시작 인덱스 지정
            Deque<Character> stack = new ArrayDeque<>();    // 매 반복문 시마다 스택 새로 생성
            for (int j = i; j < i + strLen; j++) {  // inner loop: 문자열 시작 지점부터 끝 지점까지 bracket 검사
                // 순서대로 bracket 하나씩 꺼내기
                char ch = s.charAt(j);
                // 열린 괄호인 경우 스택에 넣기
                if (!map.containsKey(ch)) {
                    stack.push(ch);
                    // 닫힌 괄호인 경우 스택에 열린 괄호가 이미 존재했는지 확인.
                } else {
                    // 스택이 비어있거나 스택에서 꺼내온 값이 닫힌 괄호에 매칭되는 열림괄호가 아닌 경우 바깥loop로 빠져나오기
                    if (stack.isEmpty() || !stack.pop().equals(map.get(ch))) {
                        continue A;
                    }
                }
            }
            // 앞서 과정 동안 continue A 미실행 시 정답
            answer++;
        }
        return answer;
    }

}

