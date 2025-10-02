class Solution {
    // grid = n x n grid
    public int swimInWater(int[][] grid) {
        final int n = grid.length;

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        // int[] = [x, y, cost]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[n][n];
        int result = 0;

        pq.add(new int[]{0, 0, grid[0][0]});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            result = Math.max(result, node[2]);
            if(node[0] == n - 1 && node[1] == n - 1){
                break;
            }

            visited[node[0]][node[1]] = true;

            for(int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }

                if(visited[nx][ny]){
                    continue;
                }

                pq.add(new int[]{nx, ny, grid[nx][ny]});
            }
        }

        return result;
    }
}