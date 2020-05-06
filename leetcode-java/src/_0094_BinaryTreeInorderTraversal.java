import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by goto456 on 2020/5/6.
 */
public class _0094_BinaryTreeInorderTraversal {
    /**
     * 递归解法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    /**
     * 非递归解法，颜色标记法
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<ColorTreeNode> stack = new Stack<>();
        stack.push(new ColorTreeNode(0, root));
        while (stack.size() != 0) {
            ColorTreeNode colorTreeNode = stack.pop();
            if (colorTreeNode.treeNode == null) {
                continue;
            }
            if (colorTreeNode.color == 0) {
                stack.push(new ColorTreeNode(0, colorTreeNode.treeNode.right));
                stack.push(new ColorTreeNode(1, colorTreeNode.treeNode));
                stack.push(new ColorTreeNode(0, colorTreeNode.treeNode.left));
            } else {
                result.add(colorTreeNode.treeNode.val);
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ColorTreeNode {
    TreeNode treeNode;
    int color;

    ColorTreeNode(int color, TreeNode treeNode) {
        this.color = color;
        this.treeNode = treeNode;
    }
}