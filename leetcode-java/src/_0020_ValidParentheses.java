import java.util.Stack;

/**
 * Created by goto456 on 2018/11/21.
 */
public class _0020_ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果是左括号，则入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else { // 如果是右括号，则比较其与栈顶元素是否配对
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.peek() != '(') {
                    return false;
                }
                if (ch == ']' && stack.peek() != '[') {
                    return false;
                }
                if (ch == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        // 最后栈为空则表示完全匹配完毕
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
        s = "([)]";
        System.out.println(isValid(s));
    }
}
