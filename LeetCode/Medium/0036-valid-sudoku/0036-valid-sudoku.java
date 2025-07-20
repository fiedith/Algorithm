class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> sets = new ArrayList<>();

        /** sets(0 ~ 8): squares 0 ~ 8
        * sets(10 ~ 18): rows 0 ~ 8
        * sets(20 ~ 28): cols 0 ~ 8
        */ 
        for(int i = 0; i < 29; i++){
            sets.add(new HashSet<>());
        }

        // i rows j cols
        for(int i = 0; i < 9; i++){
            Set<Integer> rowSet = sets.get(10 + i);
            for(int j = 0; j < 9; j++){
                Set<Integer> colSet = sets.get(20 + j);
                int squareIdx = (i / 3) * 3 + (j / 3);
                Set<Integer> squareSet = sets.get(squareIdx);
                if(board[i][j] == '.'){
                    continue;
                }
                int val = board[i][j];
                if(rowSet.contains(val) 
                || colSet.contains(val) 
                || squareSet.contains(val)
                ){
                    return false;
                }
                colSet.add(val);
                rowSet.add(val);
                squareSet.add(val);
            }
        }

        return true;
    }
}