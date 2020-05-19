import java.util.LinkedList;
import java.util.Queue;

/**
 * 层次遍历解此题，思路参考102题
 * Created by goto456 on 2020/5/16.
 */
public class _0116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 同一层的前一个节点
            Node pre = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                pre = cur;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}