/**
 * @Description:
 * @Author: wangbiwen
 * @Date: 2023/8/5 11:43 下午
 */
public class _0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode p1 = headA;
        while (p1 != null) {
            lenA ++;
            p1 = p1.next;
        }
        int lenB = 0;
        ListNode p2 = headB;
        while (p2 != null) {
            lenB ++;
            p2 = p2.next;
        }
        // 长的链表先走差值步数，最终相遇的节点为相交的首节点
        p1 = headA;
        p2 = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
