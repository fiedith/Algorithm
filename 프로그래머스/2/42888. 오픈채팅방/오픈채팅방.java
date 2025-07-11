import java.util.*;

class Solution {

    private static final Map<String, String> uidMap = new HashMap<>();
    private static final Map<String, List<Integer>> enterIndexMap = new HashMap<>();
    private static final Map<String, List<Integer>> leaveIndexMap = new HashMap<>();
    private static final List<String> chatHistory = new ArrayList<>();

    public static String[] solution(String[] record) {
        for(String command : record){
            String[] splitted = command.split(" ");
            if(splitted.length == 3){
                changeableOp(splitted);
            } else{
                leave(splitted);
            }
        }
        fillIn();
        return chatHistory.toArray(new String[0]);
    }

    private static void changeableOp(String[] splitted){
        String command = splitted[0];
        String uid = splitted[1];
        String name = splitted[2];

        if(!enterIndexMap.containsKey(uid)){
            enterIndexMap.put(uid, new ArrayList<Integer>());
        }

        switch(command){
            case "Enter":
                uidMap.put(uid, name);  // 이름 갱신
                chatHistory.add("");    // 채팅 리스트 늘리기
                List<Integer> enterIndexes = enterIndexMap.get(uid);
                enterIndexes.add(chatHistory.size() - 1);    // 현재 입장 인덱스 위치를 기록
                break;
            case "Change":
                uidMap.put(uid, name);  // 이름 변경
                break;
        }
    }

    private static void leave(String[] splitted){
        String uid = splitted[1];
        if(!leaveIndexMap.containsKey(uid)){
            leaveIndexMap.put(uid, new ArrayList<Integer>());
        }
        List<Integer> leaveIndexes = leaveIndexMap.get(uid);
        chatHistory.add("");    // 채팅 리스트 늘리기
        leaveIndexes.add(chatHistory.size() - 1);   // 현재 퇴장 인덱스 위치를 기록
    }

    private static void fillIn(){
        Set<String> keys = uidMap.keySet();
        for(String key : keys){
            String name = uidMap.get(key);
            List<Integer> enterIndexes = enterIndexMap.get(key);
            List<Integer> leaveIndexes = leaveIndexMap.get(key);

            for(Integer index : enterIndexes){
                StringBuilder sb = new StringBuilder();
                sb.append(name).append("님이 들어왔습니다.");
                chatHistory.set(index, sb.toString());
            }

            if (leaveIndexes != null) {
                for(Integer index : leaveIndexes){
                    StringBuilder sb = new StringBuilder();
                    sb.append(name).append("님이 나갔습니다.");
                    chatHistory.set(index, sb.toString());
                }
            }
        }
    }
}