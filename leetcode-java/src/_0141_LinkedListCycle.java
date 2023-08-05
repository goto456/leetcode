/**
 * Created by goto456 on 2020/6/2.
 */
public class _0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 快指针先到达终点，则表示没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 慢指针每次前进1步
            slow = slow.next;
            // 快指针每次前进2步
            fast = fast.next.next;
        }
        return true;
    }

    // 解法2，更简单易懂
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
