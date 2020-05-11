import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by goto456 on 2020/5/10.
 */
public class _0102_BinaryTreeLevelOrderTraversal {

    /**
     * 非递归解法，用队列
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelResult = new LinkedList<>();
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelResult);
        }
        return result;
    }
}
