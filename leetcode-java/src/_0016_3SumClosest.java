import java.util.Arrays;

/**
 * Created by goto456 on 2018/11/18.
 */
public class _0016_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == target) {
                    return threeSum;
                }

                if (threeSum < target) {
                    left++;
                }

                if (threeSum > target) {
                    right--;
                }

                int curDistance = Math.abs(threeSum - target);
                if (curDistance < minDistance) {
                    minDistance = curDistance;
                    result = threeSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
