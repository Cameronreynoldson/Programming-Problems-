public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        
        if(min.isEmpty() || (!min.isEmpty() && x <= min.peek()))
        {
            min.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if(val == min.peek())
        {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
