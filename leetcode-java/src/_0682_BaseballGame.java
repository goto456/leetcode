import java.util.Stack;

/**
 * Created by goto456 on 2020/7/7.
 */
public class _0682_BaseballGame {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                sum += newTop;
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("C")) {
                int top = stack.pop();
                sum -= top;
            } else if (op.equals("D")) {
                int newTop = 2 * stack.peek();
                sum += newTop;
                stack.push(newTop);
            } else {
                int newTop = Integer.valueOf(op);
                sum += newTop;
                stack.push(newTop);
            }
        }
        return sum;
    }
}
