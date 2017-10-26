import java.util.HashMap;
import java.util.Map;

/**
 * FileName: TowSum_1.java
 * Description:
 * Authors: wangbiwen
 * Date: 17-10-26
 */
public class TowSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> itemToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (itemToIndex.containsKey(temp)) {
                return new int[] {itemToIndex.get(temp), i};
            }
            itemToIndex.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 5, 3, 5};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int item : result) {
            System.out.println(item);
        }
    }

}
