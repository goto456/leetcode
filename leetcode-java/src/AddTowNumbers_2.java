/**
 * FileName: AddTowNumbers_2.java
 * Description:
 * Authors: wangbiwen
 * Date: 17-11-1
 */
public class AddTowNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        ListNode cur = result;
        int temp = 0;
        while (l1 != null && l2 != null) {
            temp = temp + l1.val + l2.val;
            cur.val = temp % 10;
            temp /= 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if (l1 == null) {
            cur = l2;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode cur = l1;
        cur.next = new ListNode(4);
        cur.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        cur = l2;
        cur.next = new ListNode(6);
        cur.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
}
