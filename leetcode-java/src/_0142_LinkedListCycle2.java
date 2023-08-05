/**
 * @Description:
 * @Author: wangbiwen
 * @Date: 2023/8/5 11:26 下午
 */
public class _0142_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 表示没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 表示有环，快慢指针相遇了
        // 相遇的地方在环中的某个节点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
