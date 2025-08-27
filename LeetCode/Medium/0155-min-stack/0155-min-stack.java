class MinStack {
    class Value{
        int val;
        int min;
        public Value(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Deque<Value> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int minVal = val;
        if(!stack.isEmpty()){
            minVal = Math.min(val, stack.peek().min);
        }
        stack.push(new Value(val, minVal));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
