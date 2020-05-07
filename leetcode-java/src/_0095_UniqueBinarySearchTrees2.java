import java.util.ArrayList;
import java.util.List;

/**
 * Created by goto456 on 2020/5/7.
 */
public class _0095_UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        return generateChildTrees(1, n);
    }

    private List<TreeNode> generateChildTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        // 此处不可少
        if (start > end) {
            result.add(null);
            return result;
        }

        if (start == end) {
            TreeNode root = new TreeNode(start);
            result.add(root);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateChildTrees(start, i - 1);
            List<TreeNode> rightTrees = generateChildTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    // root不能放在外出循环中
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
}

