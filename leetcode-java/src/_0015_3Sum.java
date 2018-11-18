import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by goto456 on 2018/11/18.
 */
public class _0015_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 用于去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 转化成Two Sum 问题
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(triplets);
                    left++;
                    right--;

                    // 用于去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        int[] nums2 = {0, 0, 0};
        System.out.println(threeSum(nums2));
    }
}
