import java.util.Stack;

/**
 * Created by goto456 on 2020/6/11.
 */
public class _0739_DailyTemperatures {
    /**
     * 暴力解法
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    break;
                }
                count++;
            }
            if (i + count >= T.length) {
                result[i] = 0;
            } else {
                result[i] = count;
            }
        }
        return result;
    }

    /**
     * 单调栈解法
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        // 递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            // 与栈顶元素比较，如果比栈顶大，则下标之差即为相应下标对应的值
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
