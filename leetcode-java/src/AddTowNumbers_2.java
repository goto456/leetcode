/**
 * FileName: AddTowNumbers_2.java
 * Description:
 * Authors: wangbiwen
 * Date: 17-11-1
 */
public class AddTowNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        ListNode cur = l1;
        int temp = 0;

        while (l1 != null && l2 != null) {
            cur = l1;
            temp = temp + l1.val + l2.val;
            cur.val = temp % 10;
            temp /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (temp == 0) {
                break;
            }
            cur = l1;
            temp += l1.val;
            cur.val = temp % 10;
            temp /= 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            cur.next = l2;
            if (temp == 0) {
                break;
            }
            cur = l2;
            temp += l2.val;
            cur.val = temp % 10;
            temp /= 10;
            l2 = l2.next;
        }

        if (temp > 0) {
            cur.next = new ListNode(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode cur = l1;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        cur = l2;
        cur.next = new ListNode(6);
        cur = cur.next;
        cur.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
