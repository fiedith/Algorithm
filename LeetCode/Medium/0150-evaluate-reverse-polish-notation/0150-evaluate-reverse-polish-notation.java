class Solution {
    public static int evalRPN(String[] tokens) {
        // edge case
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }

        // stack to push all ints
        Deque<Integer> stack = new ArrayDeque<>();

        // charset to identify operators
        Set<String> charSet = new HashSet<>();
        charSet.add("+");
        charSet.add("-");
        charSet.add("*");
        charSet.add("/");

        for(String s : tokens){
            // if current s is an int
            if(!charSet.contains(s)){
                stack.push(Integer.parseInt(s));
            // if initial operation not done yet
            } else {
                int top = stack.pop();
                int prev = stack.pop();
                stack.push(calculate(s, top, prev));
            }
        }

        return stack.pop();
    }

    private static int calculate(String operator, int top, int prev){
        int result = 0;
        switch(operator){
            case "+":
                result = prev + top;
                break;
            case "-":
                result = prev - top;
                break;
            case "*":
                result = prev * top;
                break;
            case "/":
                result = prev / top;
                break;
        }

        return result;
    }
}