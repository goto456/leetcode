//import com.sun.tools.classfile.ConstantPool;

/**
 * Created by goto456 on 2020/5/17.
 */
public class _0124_BinaryTreeMaximumPathSum {
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 防止子树最大和为负值，所以需要和0比较
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        // 如果根节点作为左右子树最大路径的连接点，与当前值比较是否更新
        result = Math.max(result, root.val + left + right);
        // 注意：此处的返回用于迭代返回，根节点只能作为子树与上层路径的连接点才能用于递归，如果根节点作为左右子树最大路径的连接点则递归返回给上层无法使用
        return Math.max(root.val + left, root.val + right);
    }
}
