/**
 * @Description:
 * @Author: wangbiwen
 * @Date: 2023/8/5 11:09 下午
 */
public class _0876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
