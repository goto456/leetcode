import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by goto456 on 2020/4/24.
 */
public class _0047_Permutations2 {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,track, used);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 此处是剪枝的核心，避免结果中重复，!used[i - 1]是灵魂
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
