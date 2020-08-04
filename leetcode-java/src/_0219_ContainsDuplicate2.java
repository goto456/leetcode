import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by goto456 on 2020/8/4.
 */
public class _0219_ContainsDuplicate2 {
    /**
     * 自己的解法，用map
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numIndexMap.containsKey(nums[i])) {
                numIndexMap.put(nums[i], i);
                continue;
            }
            int abs = Math.abs(i - numIndexMap.get(nums[i]));
            if (abs <= k) {
                return true;
            }
            numIndexMap.put(nums[i], i);
        }
        return false;
    }

    /**
     * 官方解法，用滑动窗口和set
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // 使窗口始终保持K的大小
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
