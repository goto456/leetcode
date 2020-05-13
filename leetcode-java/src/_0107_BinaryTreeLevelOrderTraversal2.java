import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by goto456 on 2020/5/12.
 */
public class _0107_BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            // len 一定要先算出来，因为queue的size一直在变化
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            // 采用头插法，使结果逆序
            result.add(0, tmp);
        }
        return result;
    }
}
