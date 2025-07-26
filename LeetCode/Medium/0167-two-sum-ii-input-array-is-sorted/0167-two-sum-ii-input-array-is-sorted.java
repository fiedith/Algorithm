class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] answer = new int[2];
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                answer[0] = l + 1;
                answer[1] = r + 1;
                break;
            } else if(sum > target){
                r -= 1;
            } else{
                l += 1;
            }
        }
        return answer;
    }
}