/**
 * Created by goto456 on 2018/12/9.
 */
public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int leftIndex = indexSearch(nums, target, true);
        // 表示未找到target
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }

        result[0] = leftIndex;
        // 因为返回的是最右位置的下一个位置，需要进行减 1 操作
        result[1] = indexSearch(nums, target, false) - 1;
        return result;
    }

    /**
     * 类似于二分查找，用于查找target对应数值的最左位置和最右位置的下一个位置
     * isLeft 表示当次查找是最左位置，还是最右位置的下一个位置
     */
    private int indexSearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target && isLeft) { // 如果是查最左位置，则应继续在左半部分查找，否则在右半部分查找
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
