/**
 * Authors: wangbiwen
 * Date: 17-11-15
 */
public class _0021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (cur == null) {
                    result = l1;
                    cur = l1;
                } else {
                    cur.next = l1;
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (cur == null) {
                    result = l2;
                    cur = l2;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return result;
    }
}


/*
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
*/