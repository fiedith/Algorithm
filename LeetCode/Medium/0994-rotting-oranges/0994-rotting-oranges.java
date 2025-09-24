class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int INF = 987654321;
        int fresh = 0;

        int[][] cost = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] != 2){
                    cost[i][j] = INF;
                    if(grid[i][j] == 1){
                        fresh++;
                    }
                }
            }
        }

        // init queue, fill up with rotten
        Deque<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    q.addLast(new int[]{i, j});
                }
            }
        }

        int[] dx = new int[]{1, -1, 0, 0};  // rows
        int[] dy = new int[]{0, 0, 1, -1};  // cols

        int result = 0;
        while(!q.isEmpty()){
            int[] now = q.pollFirst();
            result = Math.max(result, cost[now[0]][now[1]]);
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // if out of bounds or not fresh tomato(=already rotten at first place, or empty)
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] != 1) {
                    continue;
                }

                // add to q only if existing min cost of the adjacent block contains larger value
                if(cost[nx][ny] > cost[now[0]][now[1]] + 1){
                    q.addLast(new int[]{nx, ny});
                    cost[nx][ny] = cost[now[0]][now[1]] + 1;
                    fresh--;
                }
            }
        }

        return fresh == 0 ? result : -1;
    }
}