/**
 * Created by goto456 on 2020/6/27.
 */
public class _0041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将非正整数置为 N + 1，方便加负号打标记
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 对于出现过的正整数，在对应的下标上的数加个负号作为标记
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 没有打负号标记的下标加1即为所求
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 都打负号标记了，则 n + 1 为所求
        return n + 1;
    }
}
