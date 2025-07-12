package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 간결하게 푸는 방법
public class Test21Answer {

    public static String[] solution(String[] record) {

        Map<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        Map<String, String> uids = new HashMap<>();

        // Enter, Change인 경우 uid를 갱신해야 한다
        for (String s : record) {
            String[] command = s.split(" ");
            if (command.length == 3) {
                uids.put(command[1], command[2]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String s : record) {
            String[] command = s.split(" ");
            if (msg.containsKey(command[0])) {
                StringBuilder sb = new StringBuilder();
                String name = uids.get(command[1]);
                String message = msg.get(command[0]);
                result.add(sb.append(name).append(message).toString());
            }
        }
        return result.toArray(new String[0]);
    }
}
