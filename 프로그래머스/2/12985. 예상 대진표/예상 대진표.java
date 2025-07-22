class Solution {
    public int solution(int n, int a, int b) {
        boolean met = false;
        int answer = 1;
        
        while(!met){
            
            // set odd numbers to even
            if(a % 2 != 0){
                a++;
            }
            if(b % 2 != 0){
                b++;
            }

            // a and b are unmet if evenly set numbers are different
            // if unmet, move to next
            if(a != b){
                a /= 2;
                b /= 2;
                answer++;
            } else{
                met = true;
            }
        }
        return answer;
        
    }
}