/**
 * FileName: AddTowNumbers_2.java
 * Description: 此解法的优势是复用了其中一个链表来存储结果，节省了空间
 * Authors: wangbiwen
 * Date: 17-11-1
 */
public class _0002_AddTowNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用l1来存储最后结果，节省空间
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

        // 如果l1比较长，继续沿着l1运算
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

        // 若l2比较长，先将指针指向l2，再沿着l2继续运算
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

        // 如果运算完，产生了进位，则需要新增一个结点
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
