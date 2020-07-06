import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈解此题
 * Created by goto456 on 2020/7/5.
 */
public class _0503_NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        // 存储的是索引index
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        // 由于是循环数组,对于末位元素,要往后循环考虑到其前一位数也就是倒数第二个数
        for (int i = 0; i < 2 * n; i++) {
            // 对于当前元素,弹出栈中小于当前元素的元素,这些被弹出的元素的"下一个更大元素"就是当前元素
            // 一个元素只有入栈后再被弹出,才能得到该元素的"下一个更大元素",否则无"下一个更大元素",res[i]默认为-1
            // 例如,对于最大的元素,其一直留在栈中无法被弹出,因此其"下一个更大元素"默认为-1
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
