/**
 * @author goto456
 * @date 2020/5/22 下午11:52
 */
public class _0075_SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        int tmp;
        // 注意此处结束条件是<=
        while (cur <= right) {
            if (nums[cur] == 0) {
                tmp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = tmp;
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                tmp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = tmp;
                // 注意此处cur并没有++，是因为nums[right]还没有遍历过，所以不能跳过
                right--;
            } else {
                cur++;
            }
        }
    }
}
