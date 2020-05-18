/**
 * Created by goto456 on 2020/5/16.
 */
public class _0114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树最右的一个节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将右子树接到左子树最右的节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 继续处理下一个节点
                root = root.right;
            }
        }
    }
}
