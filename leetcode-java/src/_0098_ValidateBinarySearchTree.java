import java.util.Stack;

/**
 * Created by goto456 on 2020/5/8.
 */
public class _0098_ValidateBinarySearchTree {

    /**
     * 递归法解此题
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (!helper(root.left, lower, root.val)) {
            return false;
        }
        if (!helper(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }

    /**
     * 中序遍历解此题，参照94题的颜色标记法解中序遍历
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<ColorTreeNode> stack = new Stack<>();
        stack.push(new ColorTreeNode(0, root));
        // 注意此处要用double类型，用int不行
        double curVal = -Double.MAX_VALUE;
        while (stack.size() != 0) {
            ColorTreeNode node = stack.pop();
            if (node.treeNode == null) {
                continue;
            }
            if (node.color == 0) {
                stack.push(new ColorTreeNode(0, node.treeNode.right));
                stack.push(new ColorTreeNode(1, node.treeNode));
                stack.push(new ColorTreeNode(0, node.treeNode.left));
            } else {
                if (node.treeNode.val <= curVal) {
                    return false;
                }
                curVal = node.treeNode.val;
            }
        }
        return true;
    }
}
