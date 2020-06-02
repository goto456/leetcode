/**
 * Created by goto456 on 2020/6/1.
 */
public class _0061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int n = 1;
        ListNode oldTail = head;
        while (oldTail.next != null) {
            n++;
            oldTail = oldTail.next;
        }
        // 先让链表形成环
        oldTail.next = head;
        // 注意此处要取模
        k = k % n;
        ListNode newTail = head;
        for (int i = 1; i <= n - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        // 在新位置断开链表
        newTail.next = null;
        return newHead;
    }
}
