/**
 * Created by goto456 on 2018/11/22.
 */
public class _0023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int length = lists.length;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i < length - interval; i += 2 * interval) {
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private static ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }

        if (list2 != null) {
            cur.next = list2;
        }

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
