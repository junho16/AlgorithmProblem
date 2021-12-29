package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Main35 {
    public Node copyRandomList(Node head) {

        Map<Node , Node> hashmap = new HashMap<Node , Node>();
        Node pummy = new Node(-1);
        Node p = pummy;
        Node q = head;
        while(q!=null){
            Node node = new Node(q.val);
            hashmap.put(q,node);
            p.next = node;
            p = p.next;
            q = q.next;
        }
        p = pummy.next;
        q = head;
        while(q!=null){
            if(q.random == null){
                p.random = null;
            }else{
                Node node = hashmap.get(q);
                p.random = node;
            }
            p = p.next;
            q = q.next;
        }
        // while(pummy != null){
        //     System.out.print(pummy.val+" ");
        //     pummy = pummy.next;
        // }
        return pummy;
    }
}
