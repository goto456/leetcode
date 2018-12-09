/**
 * Created by goto456 on 2018/12/9.
 */
public class _0033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 右边有序
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) { // target 定在右半部分
                    left = mid + 1;
                } else { // target 定在左半部分
                    right = mid - 1;
                }
            } else { // 左边有序
                if (nums[mid] > target && nums[left] <= target) { // target 定在左半部分
                    right = mid - 1;
                } else { // target 定在右半部分
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
