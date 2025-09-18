import java.util.*;

class Solution {
    private static StringBuilder sb;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb = new StringBuilder();

        // k - 최소 거리 = 잉여 거리
        int remaining = k - (Math.abs(r - x) + Math.abs(c - y));
        // 잉여 거리가 0이거나, 홀수인 경우 (lr이나 du처럼 왕복 불가)
        if(remaining < 0 || remaining % 2 != 0){
            return "impossible";
        }
        
        while(k > 0){
            k--;
            int[] nextPos = move(n, m, x, y, r, c, k);
            x += nextPos[0];
            y += nextPos[1];
        }
        
        return sb.toString();
    }
    
    /** 
    * d > l > r > u 순서대로 이동 가능한 경우 이동해야 한다
    * return {dx, dy}
    */
    private static int[] move(int n, int m, int x, int y, int r, int c, int k){
        // down 이동시 경계 이내이며, 이동 후 목적지까지의 남은 거리 수가 k 이내인 경우 이동
        if(x + 1 <= n && (Math.abs(x + 1 - r) + Math.abs(y - c)) <= k){
            sb.append("d");
            return new int[]{1, 0};
        } 
        // 이하 동일
        else if(y - 1 >= 1 && (Math.abs(x - r) + Math.abs(y - 1 - c)) <= k){
            sb.append("l");
            return new int[]{0, -1};
        }
        else if(y + 1 <= m && Math.abs(x - r) + Math.abs(y + 1 - c) <= k){
            sb.append("r");
            return new int[]{0, 1};
        }
        // 단 d, l, r 모두 수행 불가능한 경우에만 u
        else{
            sb.append("u");
            return new int[]{-1, 0};
        }
    }
}