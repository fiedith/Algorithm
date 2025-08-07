import java.util.*;

class Solution {
    private static class Node{
        int row, col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    private static int[][] distance;
    private static char[][] graph;
    private static int rows;
    private static int cols;
    private static boolean[][] visited;
    
    public int solution(String[] maps) {
        graph = Arrays.stream(maps)
            .map(String::toCharArray)
            .toArray(char[][]::new);
        
        rows = graph.length;
        cols = graph[0].length;
        
        distance = new int[rows][cols];
        visited = new boolean[rows][cols];
        
        Node start = null;
        Node exit = null;
        Node lever = null;
        
        // O(N^2)
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(graph[i][j] == 'S'){
                    start = new Node(i, j);
                } else if(graph[i][j] == 'E'){
                    exit = new Node(i, j);
                } else if(graph[i][j] == 'L'){
                    lever = new Node(i, j);
                }
            }
        }
        
        // assign visited array & start from start
        visited[start.row][start.col] = true;
        bfs(start, lever);
        if(distance[lever.row][lever.col] == 0){
            return -1;
        }
        
        // reassign visited array & start from lever
        visited = new boolean[rows][cols];
        visited[lever.row][lever.col] = true;
        bfs(lever, exit);
        return (distance[exit.row][exit.col] == 0) ? -1 : distance[exit.row][exit.col];
    }
    
    
    private static void bfs(Node src, Node dest){
        Deque<Node> q = new ArrayDeque<>();
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        
        q.add(src);
        while(!q.isEmpty()){
            Node now = q.pollFirst();
            if(now.row == dest.row && now.col == dest.col){
                return;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                // check boundary and walls
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || graph[nr][nc] == 'X'){
                    continue;
                }
                // if next is unvisited, visit and update dist
                if(!visited[nr][nc]){
                    distance[nr][nc] = distance[now.row][now.col] + 1;
                    q.addLast(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
    }
    
    
}