import java.util.Stack;

/**
 * 中序遍历解此题，二叉搜索树中序遍历是有序的
 * Created by goto456 on 2020/5/20.
 */
public class _0173_BinarySearchTreeIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public _0173_BinarySearchTreeIterator(TreeNode root) {
        helper(root);
    }

    /**
     * 所有的左孩子节点都入栈，出栈配合中序遍历
     */
    private void helper(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode treeNode = stack.pop();
        if (treeNode.right != null) {
            helper(treeNode.right);
        }
        return treeNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
