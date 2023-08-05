/**
 * @Description:
 * @Author: wangbiwen
 * @Date: 2023/8/5 7:53 上午
 */
public class _0086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        // 定义2个虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 需要将新链表和老链表之间断掉
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
