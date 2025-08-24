import java.util.*;

class Solution {
    public int[] solution(String s) {
        int rmCounter = 0;  // removed 0s
        int opCounter = 0;  // performed op counter
        int[] result = new int[2];
        StringBuilder sb;
        
        while(!s.equals("1")){
            sb = new StringBuilder();
            // remove 0s
            for(char c : s.toCharArray()){
                if(c == '0'){
                    rmCounter++;
                } else{
                    sb.append(c);
                }
            }
            
            // get length
            int length = sb.length();
            sb = new StringBuilder();
            
            // turn length into binary
            while(length != 1){
                sb.insert(0, length % 2);   // append at first
                length /= 2;
            }
            sb.insert(0, 1);
            
            s = sb.toString();
            opCounter++;
        }
        
        result[0] = opCounter;
        result[1] = rmCounter;
        return result;
    }
}