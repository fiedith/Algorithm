import java.util.*;

class Solution {
    // name-index
    private static Map<String, Integer> hashMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i = 0; i < amount.length; i++){
            amount[i] *= 100;
        }
        
        for(int i = 0; i < enroll.length; i++){
            hashMap.put(enroll[i], i);
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < seller.length; i++){
            distribute(seller[i], amount[i], referral, answer);
        }
        
        return answer;
    }
    
    private static void distribute(String current, int amount, String[] referral, int[] answer){
        int idx = hashMap.get(current);
        int distAmount = amount / 10;
        
        if(distAmount == 0){    // 나눌 금액이 없는 경우 원 금액 합산 후 종료
            answer[idx] += amount;
        } else{     // 나눌 금액이 있는 경우 원 금액에서 10% 감산 
            answer[idx] += amount - distAmount;
            if(!referral[idx].equals("-")){     // referral이 있는 경우 재귀호출
                distribute(referral[idx], distAmount, referral, answer);
            }
        }
    }
}