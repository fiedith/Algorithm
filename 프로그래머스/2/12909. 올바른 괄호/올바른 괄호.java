import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] characters = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        // 시작부터 닫힌 괄호면 올바르지 않음
        if(characters[0] == ')') { return false; }
        stack.push(characters[0]);
        
        for(int i = 1; i < characters.length; i++){
            
            if(characters[i] == ')'){
                // 닫힘 괄호가 등장했으나 스택이 비어있다면 올바른 괄호 아님
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
                // 열림 괄호는 스택에 push
            } else{
                stack.push(characters[i]);
            }
        }
        
        // 중간에 리턴되지 않고 끝까지 반복문을 수행한 결과 스택이 비어있다면 올바른 문자열
        return stack.isEmpty();
        
    }
}