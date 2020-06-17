import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by goto456 on 2020/6/16.
 */
public class _0297_SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");

    }

    /**
     * 先序遍历实现序列化
     */
    private String serializeHelper(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = serializeHelper(root.left, str);
            str = serializeHelper(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        return deserializeHelper(list);

    }

    /**
     * 链表实现反序列化
     */
    private TreeNode deserializeHelper(List<String> list) {
        // 表示没有子树了
        if (list.get(0).equals("null")) {
            // 注意此处别漏了
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        return root;
    }
}
