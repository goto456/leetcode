import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by goto456 on 2018/11/20.
 */
public class _0018_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // 用于去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for(int j = i + 1; j < nums.length - 2; j++) {
                // 用于去重
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int fourSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (fourSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // 用于去重
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (fourSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }


}
