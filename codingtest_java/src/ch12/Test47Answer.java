package ch12;

public class Test47Answer {
    private static int maxDiff;     // ryan과 apeach의 최대 점수차 (양수 = ryan 승)
    private static int[] answer;
    private static int[] apeach;

    private static void updateScore(int[] ryan){
        // 점수 = ryan과 apeach의 점수 차이
        int score = 0;

        // 0번 인덱스 = 10점, 10번 인덱스 = 0점
        for(int i = 0; i < ryan.length; i++){
            if(ryan[i] + apeach[i] > 0){    //
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }

        // 최대 점수차 갱신
        // 최대 점수차를 갱신시킨 현재 ryan 배열을 정답으로 복사
        if(score > maxDiff){
            maxDiff = score;
            answer = ryan.clone();
        } else if(maxDiff > 0 && score == maxDiff){    // 점수차가 동일한 경우, 가장 낮은 점수를 더 많이 적중한게 정답
            for(int i = ryan.length - 1; i >= 0; i--){
                if(ryan[i] > answer[i]){
                    answer = ryan.clone();
                    break;
                }
            }
        }
    }

    private static void dfs(int remaining, int index, int[] ryan){
        // 화살을 전부 소모함 -> 최대 숫자와 배열 갱신
        if(remaining == 0){
            updateScore(ryan);
            return;
        }

        // 넘어온 index부터 끝까지
        // 현 인덱스값에 적중해야 하는 숫자는 apeach가 적중한 숫자 + 1
        for(int i = index; i < ryan.length; i++){
            int target = Math.min(remaining, apeach[i] + 1);
            ryan[i] = target;
            dfs(remaining - target, i + 1, ryan);
            ryan[i] = 0;    // backtrack
        }
    }

    public static int[] solution(int n, int[] info){
        apeach = info;
        maxDiff = 0;
        dfs(n, 0, new int[11]);
        return maxDiff <= 0 ? new int[]{-1} : answer;
    }

}