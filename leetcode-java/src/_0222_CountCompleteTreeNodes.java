/**
 * Created by goto456 on 2020/5/20.
 */
public class _0222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
