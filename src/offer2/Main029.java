package offer2;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * @author Junho
 * @date 2022/6/18 21:51
 */
public class Main029 {
    /**
     *

[1,3,5]
3
[1,3,5]
5
[1]
1
[1,3,5]
2
[3,3,3]
0
[3,4,1]
2
[]
1
[1]
0
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node pre = new Node(insertVal);
            pre.next = pre;
            return pre;
        }
        if(head.next == head){
            Node pre = new Node(insertVal);
            head.next = pre;
            pre.next = head;
            return head;
        }
        int minValue = head.val;
        int maxValue = head.val;
        Node cur = head.next;
        while(cur != head){
            minValue = Math.min(minValue , cur.val);
            maxValue = Math.max(maxValue , cur.val);
            cur = cur.next;
        }
        while(cur.val != minValue){
            cur = cur.next;
        }
        Node pre = cur;
        while(pre.next != cur){
            pre = pre.next;
        }
        if(minValue >= insertVal || maxValue <= insertVal){
            Node tmp = new Node(insertVal);
            pre.next = tmp;
            tmp.next = cur;
        }else {
            while (cur.next.val < insertVal){
                cur = cur.next;
            }
            Node tmp = new Node(insertVal);
            tmp.next = cur.next;
            cur.next = tmp;
        }
        return head;
    }
}
