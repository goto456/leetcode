/**
 * Created by goto456 on 2018/11/28.
 */
public class _0035_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return nums.length - 1;
            }
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return nums.length;
    }
}
