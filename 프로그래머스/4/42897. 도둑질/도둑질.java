// 두가지 경우로 나눠서 dp 구하기: money[0]을 고르는 경우와 money[0]을 안고르는 경우
class Solution {
    public int solution(int[] money) {
        int len = money.length;     // max idx = len - 1
        
        // dp starting at idx zero up to max idx - 1
        int[] dpOnZero = new int[len - 1];
        // dp starting at idx one up to max idx
        int[] dpOnOne = new int[len - 1];
        
        // init
        dpOnZero[0] = money[0];
        dpOnZero[1] = Math.max(money[0], money[1]);
        
        dpOnOne[0] = money[1];
        dpOnOne[1] = Math.max(money[1], money[2]);
        
        // (지금 집 + 전전 집 최대값) vs 지금 집 안고르고 직전 집까지 고른 최대값 택
        for(int i = 2; i < len - 1; i++){
            dpOnZero[i] = Math.max(dpOnZero[i - 1], money[i] + dpOnZero[i - 2]);
            dpOnOne[i] = Math.max(dpOnOne[i - 1], money[i + 1] + dpOnOne[i - 2]);
        }
        
        
        int zeroRes = Math.max(dpOnZero[len - 3], dpOnZero[len - 2]);
        int oneRes = Math.max(dpOnOne[len - 3], dpOnOne[len - 2]);
        
        return zeroRes > oneRes ? zeroRes : oneRes;
    }
}