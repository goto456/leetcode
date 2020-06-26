import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by goto456 on 2020/6/26.
 */
public class _0225_ImplementStackUsingQueues {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public _0225_ImplementStackUsingQueues() {
        queue = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
