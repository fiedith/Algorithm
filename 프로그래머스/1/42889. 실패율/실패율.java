import java.util.*;

// N = all stages count
// stages = array of players
// each values in stages = current index's player's stage no.
class Solution { 
    public int[] solution(int N, int[] stages) {
        int totalPlayers = stages.length;
        int[] playersCountAtStage = new int[N + 2];  // 스테이지 전부 다 완료한 플레이어는 N+1 위치까지 가므로 N+2의 배열
        
        for(int i = 0; i < totalPlayers; i++){
            int pos = stages[i];
            playersCountAtStage[pos]++;
        }
        
        int failRateDenominator = stages.length;
        double[] failRates = new double[N + 1];
        
        Map<Integer, Double> failRatesMap = new HashMap<>();
        for(int i = 1; i < N + 1; i++){
            if(failRateDenominator == 0){
                failRatesMap.put(i, 0.0);
            } else{
                double failRate = (double) playersCountAtStage[i] / failRateDenominator;
                failRateDenominator -= playersCountAtStage[i];
                failRatesMap.put(i, failRate);
            }
        }
        
        // keyset
        List<Integer> keys = new ArrayList<>(failRatesMap.keySet());
        
        keys.sort((a, b) -> {
            int cmp = Double.compare(failRatesMap.get(b), failRatesMap.get(a));  // value 비교해서 descending
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(a, b);  // value 동일하면 key값 ascending
        });

        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            answer[i] = keys.get(i);
        }
            
        return answer;
    }
}