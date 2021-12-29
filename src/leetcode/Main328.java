package leetcode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class Main328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode res = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddHead = odd;
        ListNode evenHead = even;
        while(odd != null && even != null ){
            if(odd.next == null)
                break;
            odd.next = odd.next.next;
            odd = odd.next;
            if(even.next == null)
                break;
            even.next = even.next.next;
            even = even.next;
        }
        ListNode p = oddHead;
        while(p.next != null){
            p = p.next;
        }
        p.next = evenHead;
        // while(oddHead != null ){
        //     System.out.print(oddHead.val+" ");
        //     oddHead = oddHead.next;
        // }
        // System.out.println();
        // while(evenHead != null ){
        //     System.out.print(evenHead.val+" ");
        //     evenHead = evenHead.next;
        // }
        return oddHead;
    }
}
