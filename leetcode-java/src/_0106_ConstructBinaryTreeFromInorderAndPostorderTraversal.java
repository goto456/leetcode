/**
 * 递归解法，思路解释参照我的105题的思路解释
 *
 * Created by goto456 on 2020/5/11.
 */
public class _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pEnd]);
        int rightCount = 0;
        for (int i = iEnd; i >= iStart; i--) {
            if (inorder[i] == postorder[pEnd]) {
                break;
            }
            rightCount++;
        }
        root.right = helper(inorder, iEnd - rightCount + 1, iEnd, postorder, pEnd - rightCount, pEnd - 1);
        root.left = helper(inorder, iStart, iEnd - rightCount - 1, postorder, pStart, pEnd - rightCount - 1);
        return root;
    }
}
