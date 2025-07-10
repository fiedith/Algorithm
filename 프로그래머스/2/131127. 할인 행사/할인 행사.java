import java.util.*;

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {

        Map<String, Integer> wMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wMap.put(want[i], number[i]);
        }

        // initiate first 9 items
        Map<String, Integer> dMap = new HashMap<>();
        for(int i = 0; i < 9; i++){
            dMap.put(discount[i], dMap.getOrDefault(discount[i], 0) + 1);
        }

        int result = 0;

        for(int i = 9; i < discount.length; i++){
            // 맨 앞(인덱스 9번)부터 하나씩 추가
            dMap.put(discount[i], dMap.getOrDefault(discount[i], 0) + 1);
            boolean b = true;
            for(String item : wMap.keySet()){
                if(dMap.getOrDefault(item, 0) != wMap.get(item)){
                    b = false;
                    break;
                }
            }
            if(b){ result++; }
            // 맨 뒤(인덱스 0번)에서부터 하나씩 제거
            dMap.put(discount[i - 9], dMap.get(discount[i - 9]) - 1);
        }

        return result;
    }
}