import java.util.List;

/**
 * Created by goto456 on 2020/6/4.
 */
public class _0234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode lastOfLeftHalf = findEndOfLeftHalf(head);
        // 反转后半部分
        ListNode firstOfRightHalf = reverse(lastOfLeftHalf.next);
        ListNode p1 = head;
        ListNode p2 = firstOfRightHalf;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 恢复被反转的后半部分，保证原始链表结构未变化
        lastOfLeftHalf.next = reverse(firstOfRightHalf);
        return result;
    }

    /**
     * 反转链表
     */
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    /**
     * 找到左半部分最后一个节点，奇数个节点时，找到中间节点
     */
    private ListNode findEndOfLeftHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 注意此处的条件
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
