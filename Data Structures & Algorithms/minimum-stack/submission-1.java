class MinStack {

    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        if (stack.size() == 0) {
            minStack.add(val);
        } else {
            int minValue = minStack.getLast() < val ? minStack.getLast() : val;
            minStack.add(minValue);
        }
        stack.add(val);

    }
    
    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
