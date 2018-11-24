/**
 * Created by goto456 on 2018/11/23.
 */
public class _0024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempNode = head.next;
        head.next = swapPairs(tempNode.next);
        tempNode.next = head;
        return tempNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
