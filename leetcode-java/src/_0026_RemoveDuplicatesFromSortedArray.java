/**
 * Created by goto456 on 2018/11/24.
 */
public class _0026_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[preIndex]) {
                // 移动元素值
                nums[++preIndex] = nums[i];
            }
        }
        return preIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
