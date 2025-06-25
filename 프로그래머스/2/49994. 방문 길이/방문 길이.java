import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        char[] commands = dirs.toCharArray();

        Map<Character, Integer[]> moves = new HashMap<>();
        moves.put('U', new Integer[]{0, 1});
        moves.put('D', new Integer[]{0, -1});
        moves.put('R', new Integer[]{1, 0});
        moves.put('L', new Integer[]{-1, 0});

        Integer x = 0;
        Integer y = 0;
        
        int dx = 0;
        int dy = 0;

        Set<List<Integer>> visited = new HashSet<>();

        for(char command : commands){
            Integer[] posDiff = moves.get(command);
            dx = x + posDiff[0];
            dy = y + posDiff[1];

            // if next move is in map range
            if(dx >= -5 && dx <= 5 && dy >= -5 && dy <= 5){
                // 해당 경로를 표현하기 위한 값으로 넣기 (그러면 그 경로는 유일함)
                visited.add(Arrays.asList(x+dx, y+dy));
                x = dx;
                y = dy;
            }
        }

        int answer = visited.size();
        return answer;
    }
}
