package interview.lc_2_Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    public class Node {
        int key;
        int value;
        Node last;
        Node next;
        public Node(){}
        public Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }

    public Map<Integer , Node > map;
    public Node l;
    public Node r;
    public int capacity;
    public void insert(int key , int value){

        Node node = new Node(key , value);
        map.put(key , node);

        node.next = l.next;
        node.last = l;
        l.next.last = node;
        l.next = node;
    }

    public void delete(int key){
        Node node = map.get(key);
        node.next.last = node.last;
        node.last.next = node.next;
        map.remove(key);
    }

    public LRUCache(int cap) {
        capacity = cap;
        map = new HashMap();
        l = new Node();
        r = new Node();
        l.next = r;
        r.last = l;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        delete(key);
        insert(key , node.value);
        return node.value;
    }

    public void put(int key, int value) {
        //先看有没有
        if(map.containsKey(key)){
            //有这个元素
            Node node = map.get(key);
            delete(key);
            insert(key , value);
        }else{
            //没有这个元素则要添加 加之前先判断是否需要删除一个
            if(map.size() == capacity){
                //满了需要删除
                int deleteKey = r.last.key;
                delete(r.last.key);
                map.remove(deleteKey);
            }
            insert(key , value);
        }
    }
}
