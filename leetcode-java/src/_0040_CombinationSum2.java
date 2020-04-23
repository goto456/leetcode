import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by goto456 on 2020/4/23.
 */
public class _0040_CombinationSum2 {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序，为了避免结果中有重复的list
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, target, 0, track);
        return result;
    }

    public void backtrack(int[] candidates, int target, int startIndex, LinkedList<Integer> track) {
        if (getListSum(track) == target) {
            result.add(new LinkedList<>(track));
            return;
        }

        // 从startIndex开始防止结果重复
        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝
            if (getListSum(track) > target) {
                continue;
            }

            // 避免结果重复，这句是精华所在
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.add(candidates[i]);
            backtrack(candidates, target, i + 1, track);
            track.removeLast();
        }
    }

    public int getListSum(List<Integer> track) {
        int sum = 0;
        for (int item : track) {
            sum += item;
        }
        return sum;
    }
}
