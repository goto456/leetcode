import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解此题
 *
 * Created by goto456 on 2020/5/15.
 */
public class _0113_PathSum2 {
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, sum, track);
        return result;
    }

    private void backtrack(TreeNode root, int sum, LinkedList<Integer> track) {
        // 叶子节点，且加上其值正好等于sum，则找到一个解
        if (root.left == null && root.right == null && root.val == sum) {
            track.add(root.val);
            result.add(new LinkedList<>(track));
            // 切记这一步不能少
            track.removeLast();
            return;
        }

        // 以下是回溯法的固定套路
        if (root.left != null) {
            track.add(root.val);
            backtrack(root.left, sum - root.val, track);
            track.removeLast();
        }

        if (root.right != null) {
            track.add(root.val);
            backtrack(root.right, sum - root.val, track);
            track.removeLast();
        }
    }
}
