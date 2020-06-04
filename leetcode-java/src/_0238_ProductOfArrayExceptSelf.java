/**
 * Created by goto456 on 2020/6/4.
 */
public class _0238_ProductOfArrayExceptSelf {
    /**
     * 时间 O(n)
     * 空间 O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        // 用于存储每个数左边所有数的乘积
        int[] left = new int[nums.length];
        // 用于存储每个数右边所有数的乘积
        int[] right = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = k;
            k *= nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 结果为左边的乘积乘上右边的乘积
            result[i] = left[i] * right[i];
        }
        return result;
    }

    /**
     * 时间 O(n)
     * 空间 O(1)
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        int k = 1;
        // 存储当前数左边所有数的乘积
        for (int i = 0; i < nums.length; i++) {
            result[i] = k;
            k *= nums[i];
        }
        k = 1;
        // 左边所有数乘积乘上右边所有数乘积，即为所求结果
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= k;
            k *= nums[i];
        }
        return result;
    }
}
