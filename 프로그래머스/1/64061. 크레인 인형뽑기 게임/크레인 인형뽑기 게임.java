import java.util.*;

class Solution {
    
    private static final Deque<Integer> stack = new ArrayDeque<>();
    
    /**
    * pick one toy in boards at given position
    * given NxN boards, pos= 1 ~ N
    * return picked value (0 if none)
    */
    private static int pick(int[][] boards, int pos){
        int result = 0;
        for (int[] row : boards){
            if(row[pos - 1] != 0){
                result = row[pos - 1];  // 담고
                row[pos - 1] = 0;       // 0으로 대체
                break;
            }
        }
        return result;  // 0 if none
    }
    
    // check if poppable and push
    private static int pushAndPop(int toy){
        // if top num equals current pushable toy, pop & do not push
        if(!stack.isEmpty() && stack.peek() == toy){
            stack.pop();
            return 2;
        } else{
            stack.push(toy);
            return 0;
        }
    }
    
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        for(int move : moves){
            int picked = pick(board, move);
            if(picked != 0){
                answer += pushAndPop(picked);
            }
        }
        
        return answer;
    }
}