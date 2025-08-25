class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        for(int i = 1; i <= yellow; i++){
            // if divisible, get height & width
            if(yellow % i == 0){
                int length = i;
                int width = yellow / i;
                if((width * 2 + length * 2) + 4 == brown){
                    result[0] = width + 2;
                    result[1] = length + 2;
                    return result;
                }
            }
        }
        // will always return within loop
        return result;
    }
}