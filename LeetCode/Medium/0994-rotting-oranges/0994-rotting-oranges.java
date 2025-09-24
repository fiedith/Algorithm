class Solution {
    private class Node{
        public int row;
        public int col;
        public int val;

        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int INF = 987654321;

        int[][] cost = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(cost[i], INF);
        }

        Deque<Node> q = new ArrayDeque<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    q.addLast(new Node(i, j, 0));
                }
            }
        }

        int[] dx = new int[]{1, -1, 0, 0};  // rows
        int[] dy = new int[]{0, 0, 1, -1};  // cols

        while(!q.isEmpty()){
            Node now = q.pollFirst();
            cost[now.row][now.col] = Math.min(cost[now.row][now.col], now.val);

            for(int i = 0; i < 4; i++){
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                // if out of bounds or not fresh tomato(=already rotten at first place, or empty)
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] != 1) {
                    continue;
                }

                // add to q only if existing min cost of the adjacent block contains larger value
                if(cost[nx][ny] > now.val + 1){
                    q.addLast(new Node(nx, ny, now.val + 1));
                }
            }
        }

        int result = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                // if exists fresh orange unvisited, return -1
                if(grid[i][j] == 1 && cost[i][j] == INF){
                    return -1;
                }

                if(cost[i][j] != INF){
                    result = Math.max(result, cost[i][j]);
                }
            }
        }

        return result;
    }
}