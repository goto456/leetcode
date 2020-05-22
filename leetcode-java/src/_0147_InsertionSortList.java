/**
 * @author goto456
 * @date 2020/5/23 上午12:21
 */
public class _0147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // 新建一个假节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (cur.next == null || head.val < cur.next.val) {
                ListNode tmp = head.next;
                head.next = cur.next;
                cur.next = head;
                head = tmp;
                // 下一次又重头开始比较
                cur = dummy;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
