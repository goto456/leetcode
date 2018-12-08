import java.util.Stack;

/**
 * Created by goto456 on 2018/12/4.
 */
public class _0032_LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // 为了方便计算push一个匹配开始位置的前一个位置
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) { // 表示未匹配，重新push下一次匹配开始位置的前一个位置
                    stack.push(i);
                } else {
                    // i-stack.peek()表示当前匹配的长度
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
}
