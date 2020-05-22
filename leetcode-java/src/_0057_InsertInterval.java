import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wangbiwen
 * @date 2020/5/22 下午10:26
 */
public class _0057_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 最坏情况下是没有交集，则长度为length + 1
        int[][] result = new int[intervals.length + 1][2];

        // 临界情况判断
        if (intervals.length == 0) {
            result[0] = newInterval;
            return result;
        }
        if (newInterval.length == 0) {
            return intervals;
        }

        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            // 当前区间与新区间无交集且小于新区间，则直接加入结果集中
            if (intervals[i][1] < newInterval[0]) {
                result[idx++] = intervals[i];
                continue;
            }
            // 当前区间与新区间无交集且大于新区间，则先将新区间加入结果集，然后将所有剩余的区间加入
            if (intervals[i][0] > newInterval[1]) {
                result[idx++] = newInterval;
                for (int j = i; j < intervals.length; j++) {
                    result[idx++] = intervals[i++];
                }
                break;
            }
            // 当前区间和新区建有交集，则更新新区建的左右值
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        }
        // 如果新区间还未加入到结果集中，则加入
        if (idx == 0 || result[idx - 1][1] < newInterval[0]) {
            result[idx++] = newInterval;
        }
        // 返回所需要大小的数组
        return Arrays.copyOf(result, idx);
    }
}
