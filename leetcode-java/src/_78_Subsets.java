import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解子集问题
 * Created by goto456 on 2020/4/29.
 */
public class _78_Subsets {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return result;
    }

    public void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        result.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}
