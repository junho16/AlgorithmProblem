package interview.lc_2_Interview;

/**
 * 需要注意一个点是：在两个链表没有相交的点的时候 最后二者都是null 也就是说还是会因为 A ！= B 出循环 并且返回的 A 也是 null
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class Main160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
