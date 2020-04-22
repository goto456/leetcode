import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解组合
 * Created by goto456 on 2020/4/20.
 */
public class _0039_CombinationSum {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            track.add(candidates[i]);
            backtrack(candidates, target, i, track);
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
