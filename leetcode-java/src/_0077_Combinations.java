import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解组合问题
 * Created by goto456 on 2020/4/28.
 */
public class _0077_Combinations {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return result;
    }

    public void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }
}
