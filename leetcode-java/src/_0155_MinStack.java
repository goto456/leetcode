import java.util.Stack;

/**
 * Created by goto456 on 2020/6/23.
 */
public class _0155_MinStack {
    // 存数据
    private Stack<Integer> valueStack;
    // 存最小值
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public _0155_MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valueStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
