import java.util.Stack;

/**
 * Created by goto456 on 2020/7/8.
 */
public class _0844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return rebuild(S).equals(rebuild(T));
    }

    private String rebuild(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
