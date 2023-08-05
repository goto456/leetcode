//import apple.laf.JRSUIUtils;

/**
 * 递归法解此题
 * Created by goto456 on 2020/5/11.
 */
public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        // 前序遍历的第一个值即为树的根节点
        TreeNode root = new TreeNode(preorder[pStart]);
        // 在中序遍历数组中找到根节点的下标偏移，即为左子树节点个数
        int leftCount = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == preorder[pStart]) {
                break;
            }
            leftCount++;
        }
        // 中序遍历中根节点左边的均为左子树节点，根节点右边的均为右子树节点，则左子树节点数为：leftCount
        // 前序遍历中根节点后面紧跟的leftCount个节点，就是左子树的节点
        root.left = helper(preorder, pStart + 1, pStart + leftCount, inorder, iStart, iStart + leftCount - 1);
        root.right = helper(preorder, pStart + leftCount + 1, pEnd, inorder, iStart + leftCount + 1, iEnd);
        return root;
    }
}
