class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();  // stack contains idxs
        stack.push(0);

        int[] result = new int[temperatures.length];

        for(int i = 1; i < temperatures.length; i++){
            // if temp rise occurred between any two idxs, start popping from stack until temp rise stops
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int popped = stack.pop();
                result[popped] = i - popped;
            }
            stack.push(i);
        }

        return result;  // remain 0 for the rest
    }
}