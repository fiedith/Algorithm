import java.util.*;

class Solution {
    
    private static class Node{
        int row, col, cost;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int solution(int[][] maps) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        int rows = maps.length;
        int cols = maps[0].length;
        
        // 위치값만 저장할 별도의 distance 배열 활용
        int[][] distance = new int[rows][cols];
        distance[0][0] = 1;
        
        int answer = -1;
        Node src = new Node(0, 0);
        
        Deque<Node> q = new ArrayDeque<>();
        q.add(src);
        
        // y = row, x = col. element at row 1 col 2 = maps[1][2] -> maps[y][x]
        while(!q.isEmpty()){
            // poll one node
            Node now = q.pollFirst();
            
            // for polled node, check 4 directions & add nodes
            for(int i = 0; i < 4; i++){
                int ny = dy[i] + now.row;
                int nx = dx[i] + now.col;
                // check boundary & wall
                if(nx < 0 || nx >= cols || ny < 0 || ny >= rows || maps[ny][nx] == 0){
                    continue;
                } 
                
                // not visited if distance value is 0
                if(distance[ny][nx] == 0){
                    q.addLast(new Node(ny, nx));    // enqueue only if unvisited
                    distance[ny][nx] = distance[now.row][now.col] + 1;
                }
            }
        }
        
        return (distance[rows-1][cols-1] == 0) ? -1 : distance[rows-1][cols-1];
    }
}