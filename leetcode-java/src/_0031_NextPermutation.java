/**
 * Created by goto456 on 2018/12/3.
 */
public class _0031_NextPermutation {
    public static void nextPermutation(int[] nums) {
        // 先从后往前找到第一次出现升序的2个数，i指向前一个数
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 然后从后往前找到第一个大于nums[i]的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换2个下标对应的元素
            swap(nums, i, j);
        }
        // 逆置i之后的所有元素
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
