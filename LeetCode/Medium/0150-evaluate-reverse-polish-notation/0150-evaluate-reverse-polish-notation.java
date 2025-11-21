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

        int result = 0;

        // whether first operation did occur or not
        boolean init = false;

        for(String s : tokens){
            // if current s is an int
            if(!charSet.contains(s)){
                stack.push(Integer.parseInt(s));
            // if initial operation not done yet
            } else if(!init){
                int a = stack.pop();
                int b = stack.pop();
                result = calculate(s, a, b);
                init = true;
            } else{
                int popped = stack.pop();
                result = calculate(s, result, popped);
            }
        }

        return result;
    }

    private static int calculate(String operator, int res, int popped){
        int result = 0;
        switch(operator){
            case "+":
                result = popped + res;
                break;
            case "-":
                result = popped - res;
                break;
            case "*":
                result = popped * res;
                break;
            case "/":
                result = popped / res;
                break;
        }

        return result;
    }
}