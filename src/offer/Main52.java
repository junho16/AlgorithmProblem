package offer;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Main52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = (curA == null ) ? headB:curA.next;
            curB = (curB == null) ? headA:curB.next;
        }
        return curA;
    }
}
