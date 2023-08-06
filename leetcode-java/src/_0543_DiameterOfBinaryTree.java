/**
 * @Description:
 * @Author: wangbiwen
 * @Date: 2023/8/6 8:34 上午
 */
public class _0543_DiameterOfBinaryTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        int myDiameter = maxLeft + maxRight;
        maxDiameter = Math.max(myDiameter, maxDiameter);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
