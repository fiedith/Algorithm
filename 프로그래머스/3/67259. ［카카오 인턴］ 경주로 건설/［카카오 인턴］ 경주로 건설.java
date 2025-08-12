import java.util.*;

class Solution {
    private static final int INF = 987654321;
    private static final int VERTICAL = 0;
    private static final int HORIZONTAL = 1;
    
    private class Node {
        int row, col, direction, cost;
        
        public Node(int row, int col, int direction, int cost) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        int boardSize = board.length;
        
        // 하 우 상 좌
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        
        // [row][col][direction], direction = VERTICAL or HORIZONTAL
        int[][][] prices = new int[boardSize][boardSize][2];
        
        // 모든 위치를 INF로 초기화
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                prices[i][j][VERTICAL] = INF;
                prices[i][j][HORIZONTAL] = INF;
            }
        }
        
        // dijkstra 우선순위큐
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        
        // 시작점에서 이동 가능한 방향으로 우선 이동
        if(board[0][1] == 0) { // 우(수평)
            pq.add(new Node(0, 1, HORIZONTAL, 100));
            prices[0][1][HORIZONTAL] = 100;
        }
        if(board[1][0] == 0) { // 하(수직)
            pq.add(new Node(1, 0, VERTICAL, 100));
            prices[1][0][VERTICAL] = 100;
        }
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            
            // 이미 더 저렴한 비용으로 방문했다면 스킵
            if(current.cost > prices[current.row][current.col][current.direction]) {
                continue;
            }
            
            // 하 우 상 좌 4방향
            for(int i = 0; i < 4; i++) {
                int nr = current.row + dr[i];
                int nc = current.col + dc[i];
                
                // check boundary and walls
                if(nr < 0 || nr >= boardSize || nc < 0 || nc >= boardSize || board[nr][nc] == 1) {
                    continue;
                }
                
                int nextDir = i % 2; // even: vertical, odd: horizontal
                int nextCost = current.cost + 100;
                
                // 방향이 달라지면 비용 추가
                if(current.direction != nextDir) {
                    nextCost += 500;
                }
                
                // 다음 비용이 현재 비용보다 저렴할 시 갱신
                if(nextCost < prices[nr][nc][nextDir]) {
                    prices[nr][nc][nextDir] = nextCost;
                    pq.add(new Node(nr, nc, nextDir, nextCost));
                }
            }
        }
        
        // 도착점에서 두 방향 중 최소 비용 반환
        return Math.min(prices[boardSize-1][boardSize-1][VERTICAL], 
                       prices[boardSize-1][boardSize-1][HORIZONTAL]);
    }
}
