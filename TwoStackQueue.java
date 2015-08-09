public class TwoStackQueue {
    Stack one = new Stack<Integer>();
    Stack two = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        one.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(two.isEmpty())
        {
            while(!one.isEmpty())
            {
                two.push(one.pop());
            }
        }
        
        two.pop();
    }

    // Get the front element.
    public int peek() {
        if(two.isEmpty())
        {
            while(!one.isEmpty())
            {
                two.push(one.pop());
            }
        }
        
        return (int)two.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }
}
