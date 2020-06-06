import java.util.HashSet;
import java.util.Set;

/**
 * Created by goto456 on 2020/6/6.
 */
public class _0128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 将查找时间复杂度降为O(1)
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxCount = 0;
        for (int num : numSet) {
            // 过滤重复查询与计算
            if (numSet.contains(num - 1)) {
                continue;
            }
            int curCount = 1;
            int curNum = num;
            // 由于过滤条件，所有每个元素只会最多进入内循环1次
            while (numSet.contains(curNum + 1)) {
                curCount++;
                curNum++;
            }
            maxCount = Math.max(maxCount, curCount);
        }
        return maxCount;
    }
}
