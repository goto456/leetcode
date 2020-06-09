import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by goto456 on 2020/6/9.
 */
public class _0532_KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        // 存储已经访问过的
        Set<Integer> visited = new HashSet<>();
        // 存储结果的最小的数
        Set<Integer> diff = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                diff.add(num - k);
            }
            visited.add(num);
        }
        return diff.size();
    }
}
