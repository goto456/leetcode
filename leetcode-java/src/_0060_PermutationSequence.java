import java.util.LinkedList;
import java.util.List;

/**
 * Created by goto456 on 2020/4/27.
 */
public class _0060_PermutationSequence {
    public LinkedList<Integer> result;
    public int count = 0;
    public String getPermutation(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, track);
        StringBuilder sb = new StringBuilder();
        for (Integer item : result) {
            sb.append(item);
        }
        return sb.toString();
    }

    public void backtrack(int n, int k, LinkedList<Integer> track) {
        if (track.size() == n) {
            count++;
            if (count == k) {
                result = new LinkedList<>(track);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.add(i);
            backtrack(n, k, track);
            track.removeLast();
        }
    }

}
