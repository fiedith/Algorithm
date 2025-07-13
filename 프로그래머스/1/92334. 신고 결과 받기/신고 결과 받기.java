import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // key = 유저, value = 유저를 신고한 유저들
        Map<String, Set<String>> reporteeMap = new HashMap<>();
        for(String s : report){
            String[] splitted = s.split(" ");   // [0] = reporter, [1] = reportee
            if(!reporteeMap.containsKey(splitted[1])){
                reporteeMap.put(splitted[1], new HashSet<>());
            }
            reporteeMap.get(splitted[1]).add(splitted[0]);
        }
        
        // key = 유저, value = 유저가 정지시킨 유저들의 수
        Map<String, Integer> countMap = new HashMap<>();
        // countMap 초기화 (효율성 탈락시 위 루프에서 처리 가능)
        for(String s : id_list){
            countMap.put(s, 0);
        }
        
        for(String key : reporteeMap.keySet()){
            Set<String> set = reporteeMap.get(key);
            if(set.size() >= k){    // 현재 키(유저)의 신고당한 횟수가 k 이상인 경우
                for(String s : set){
                    countMap.put(s, countMap.get(s) + 1);   // 나를 신고한 유저들의 정지 적중 횟수 증가
                }
            }
        }
        
        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            result[i] = countMap.get(id_list[i]);
        }
        
        return result;
        
    }
}