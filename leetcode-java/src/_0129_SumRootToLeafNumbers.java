/**
 * Created by goto456 on 2020/5/18.
 */
public class _0129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    /**
     * 递归进行累加
     */
    private int helper(TreeNode root, int tmpResult) {
        if (root == null) {
            return 0;
        }
        tmpResult = tmpResult * 10 + root.val;
        if (root.left == null && root.right == null) {
            return tmpResult;
        }
        return helper(root.left, tmpResult) + helper(root.right, tmpResult);
    }
}
