/**
 * @Description:
 * @Author: wangbiwen
 * @Date: 2023/8/6 12:04 上午
 */
public class _0083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            // 注意该行不能放在if前面
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
