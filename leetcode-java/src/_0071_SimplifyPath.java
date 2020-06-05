import java.util.Stack;

/**
 * 用栈解此题
 * Created by goto456 on 2020/5/30.
 */
public class _0071_SimplifyPath {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        // 分割后每部分只有这几种情况："", ".", "..", "xxx"
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals(".") && !strings[i].equals("..") && !strings[i].equals("")) {
                stack.push(strings[i]);
                continue;
            }
            // 别忘了判断栈是否为空
            if (strings[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append("/").append(stack.get(i));
        }
        return result.toString();
    }
}
