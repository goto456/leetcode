/**
 * Created by goto456 on 2018/11/21.
 */
public class _0019_RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        // 表示删除的是第一个节点
        if (p == null) {
            return head.next;
        }

        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        // q正好指向待删除节点的前一个节点
        q.next = q.next.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printNode(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            System.out.println(p.val);
            p = p.next;
        }
        System.out.println(p.val);
        System.out.println("-----");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }

        printNode(head);
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        printNode(result);
    }
}


