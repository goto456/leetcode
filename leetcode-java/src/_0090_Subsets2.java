import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解子集
 * @author goto456
 * @date 20-5-3 上午10:06
 */
public class _0090_Subsets2 {

    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return result;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        result.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 剪枝，防止重复
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}