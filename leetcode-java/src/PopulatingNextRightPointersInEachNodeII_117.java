/**
 * Authors: wangbiwen
 * Date: 17-11-15
 */
public class PopulatingNextRightPointersInEachNodeII_117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode nextLevelHead = null;
        TreeLinkNode nextLevelCur = null;

        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (nextLevelCur == null) {
                        nextLevelHead = cur.left;
                        nextLevelCur = cur.left;
                    } else {
                        nextLevelCur.next = cur.left;
                        nextLevelCur = nextLevelCur.next;
                    }
                }
                if (cur.right != null) {
                    if (nextLevelCur == null) {
                        nextLevelHead = cur.right;
                        nextLevelCur = cur.right;
                    } else {
                        nextLevelCur.next = cur.right;
                        nextLevelCur = nextLevelCur.next;
                    }
                }
                cur = cur.next;
            }
            cur = nextLevelHead;
            nextLevelHead = null;
            nextLevelCur = null;
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
