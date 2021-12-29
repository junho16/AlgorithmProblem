package offer;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Main6 {
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode pre = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
            len++;
        }
        int[] res = new int[len];
        int index = 0;
        while(pre != null){
            res[index++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
