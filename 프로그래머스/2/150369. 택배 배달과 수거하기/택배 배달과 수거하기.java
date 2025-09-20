class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        int del_idx = n - 1;
        int pick_idx = n - 1;
        
        while(del_idx >= 0 && deliveries[del_idx] == 0){
            del_idx--;
        }
        while(pick_idx >= 0 && pickups[pick_idx] == 0){
            pick_idx--;
        }
        
        long answer = 0;
        
        while(del_idx >= 0 || pick_idx >= 0){
            // 매 반복 시 최대 거리로 1회 왕복
            int max = Math.max(del_idx, pick_idx);
            answer += (max + 1) * 2L;
            del_idx = nextIdx(cap, del_idx, deliveries);
            pick_idx = nextIdx(cap, pick_idx, pickups);
        }
        
        return answer;
    }
    
    private static int nextIdx(int cap, int idx, int[] arr){
        // 인덱스 값이 0이상이고, 소모할 cap이 있거나 현재 위치내 값이 0인 경우
        while(idx >= 0 && (cap > 0 || arr[idx] == 0)){
            // 마지막 값이 cap보다 큰 경우, cap만치 배열 값을 차감하고, idx 변화없이 종료 
            if(arr[idx] > cap){
                arr[idx] -= cap;
                cap = 0;
            // 마지막 값이 cap보다 작거나 같은 경우, cap에서 배열 값 만치 차감하고, idx 감소해서 다음 집으로 이동
            } else{
                cap -= arr[idx];
                arr[idx] = 0;
                idx--;
            }
        }
        
        // 위 반복 후 계산된 최종 idx를 반환
        return idx; 
    }
}