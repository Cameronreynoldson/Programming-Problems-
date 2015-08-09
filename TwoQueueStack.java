import java.util.*;
public class TwoQueueStack {
    
    Queue one = new LinkedList<Integer>();
    Queue two = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        while(!one.isEmpty())
        {
            two.offer(one.poll());
        }
        one.add(x);
         while(!two.isEmpty())
        {
            one.offer(two.poll());
        }
    }
    
    // Removes the element on top of the stack.
    public void pop() {
        one.poll();
    }

    // Get the top element.
    public int top() {
        return (int)one.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }
}
