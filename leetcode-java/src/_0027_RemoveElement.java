/**
 * Created by goto456 on 2018/11/24.
 */
public class _0027_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int preIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[preIndex++] = nums[i];
            }
        }
        return preIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
