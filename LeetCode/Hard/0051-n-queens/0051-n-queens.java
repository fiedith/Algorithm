class Solution {
    private static boolean[] isColVisited;
    private static Set<Integer> asc;    // ascending diagonal
    private static Set<Integer> desc;   // descending diagonal
    private static int N;
    private static int[] queenPos;  // idx = row, val = col, 0-based
    private static List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        isColVisited = new boolean[n];  // 0-based arr
        asc = new HashSet<>();
        desc = new HashSet<>();
        N = n;
        queenPos = new int[n];
        result = new ArrayList<>();

        dfs(0);
        return result;
    }

    private static void dfs(int row){
        if(row == N){
            List<String> board = new ArrayList<>();
            for(int pos : queenPos){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < N; i++){
                    if(i != pos){
                        sb.append(".");
                    } else{
                        sb.append("Q");
                    }
                }
                board.add(sb.toString());
            }
            result.add(board);
            return;
        }

        for(int col = 0; col < N; col++){
            if(!isColVisited[col] && !asc.contains(row + col) && !desc.contains(row - col)){
                isColVisited[col] = true;
                asc.add(row + col);
                desc.add(row - col);
                queenPos[row] = col;
                dfs(row + 1);
                // backtrack
                desc.remove(row - col);
                asc.remove(row + col);
                isColVisited[col] = false;
            }
        }
    }
}