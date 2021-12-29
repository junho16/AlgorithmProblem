package leetcode;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class Main445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        ListNode pre = null;
        while (cur != null){
            ListNode til = cur.next;
            cur.next = pre;
            pre = cur;
            cur = til;
        }
        ListNode l1Head = pre;
        cur = l2;
        pre = null;
        while(cur != null){
            ListNode til = cur.next;
            cur.next = pre;
            pre = cur;
            cur = til;
        }
        ListNode l2Head = pre;


        ListNode res = new ListNode();
        ListNode reshead = res;
        int plus = 0;
        while (l1Head != null || l2Head != null){
            int num = (l1Head!=null?l1Head.val:0) + (l2Head!=null?l2Head.val:0) + plus;
            ListNode newNode = new ListNode(num % 10);
            plus = num / 10;
            res.next = newNode;
            res = res.next;
            if(l1Head != null)
                l1Head = l1Head.next;
            if(l2Head!=null)
                l2Head = l2Head.next;
        }
        if(plus == 1){
            ListNode newNode = new ListNode(1);
            res.next = newNode;
            res = res.next;
        }

        cur = reshead.next;
        pre = null;
        while (cur != null){
            ListNode til = cur.next;
            cur.next = pre;
            pre = cur;
            cur = til;
        }
//        while (pre != null){
//            System.out.print(pre.val+" ");
//            pre = pre.next;
//        }
//        System.out.println();

//        while (l1Head != null){
//            System.out.print(l1Head.val+" ");
//            l1Head = l1Head.next;
//        }
//        System.out.println();

//        while (l2Head != null){
//            System.out.print(l2Head.val+" ");
//            l2Head = l2Head.next;
//        }
//        System.out.println();



        return pre;
    }
}
