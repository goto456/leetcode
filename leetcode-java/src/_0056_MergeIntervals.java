import java.util.Arrays;
import java.util.Comparator;

/**
 * 先排序
 * Created by goto456 on 2020/5/21.
 */
public class _0056_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        // 先按照第一位数排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 只有当结果区间中最右边的数小于当前区间的最左边数时，不能合并，直接加到结果集中
            if (result[idx][1] < intervals[i][0]) {
                result[++idx] = intervals[i];
            } else { // 否则可以合并
                result[idx][1] = Math.max(result[idx][1], intervals[i][1]);
            }
        }
        // 最后截取拷贝合并后所需的长度的数组
        return Arrays.copyOf(result, idx + 1);
    }
}
