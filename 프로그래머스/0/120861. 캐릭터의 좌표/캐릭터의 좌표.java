class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int minX = -(board[0] / 2);
        int maxX = board[0] / 2;
        int minY = -(board[1] / 2);
        int maxY = board[1] / 2;
        
        int currX = 0;
        int currY = 0;
        
        for(String input : keyinput){
            switch(input){
                case "left":
                    if(currX != minX){
                        currX--;
                    }
                    break;
                case "right":
                    if(currX != maxX){
                        currX++;
                    }
                    break;
                case "up":
                    if(currY != maxY){
                        currY++;
                    }
                    break;
                case "down":
                    if(currY != minY){
                        currY--;
                    }
                    break;
            }
        }
        
        return new int[]{currX, currY};
    }
}