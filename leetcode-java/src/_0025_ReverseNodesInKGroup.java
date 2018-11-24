/**
 * Created by goto456 on 2018/11/23.
 */
public class _0025_ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 构建一个头结点，方便连接最后结果
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 指向翻转区间第一个节点的前一个节点
        ListNode pre = dummy;
        // 指向翻转区间的第一个节点
        ListNode first = pre.next;
        // 用于遍历的当前节点指针
        ListNode cur = first;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            if (cnt == k) {
                ListNode last = cur;
                pre.next = reverseOneGroup(first, last);
                // 注意此处的first节点已经是翻转后的最后一个节点了
                pre = first;
                first = pre.next;
                cur = first;
                cnt = 0;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 用于翻转一个区间内的链表
     */
    private static ListNode reverseOneGroup(ListNode first, ListNode last) {
        while (first != last) {
            ListNode cur = first;
            first = first.next;
            cur.next = last.next;
            // last节点作为翻转后的第一个节点
            last.next = cur;
        }
        return last;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 打印链表用于调试
     */
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 6; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        printList(head);
        System.out.println("------");
        printList(reverseKGroup(head, 3));
    }
}
