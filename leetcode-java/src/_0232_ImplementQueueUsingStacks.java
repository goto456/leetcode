import java.util.Stack;

/**
 * Created by goto456 on 2020/7/3.
 */
public class _0232_ImplementQueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    /** Initialize your data structure here. */
    public _0232_ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        throw new  RuntimeException("no element");
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        throw new  RuntimeException("no element");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
