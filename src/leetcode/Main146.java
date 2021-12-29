package leetcode;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class Main146 {
    public class Node {
        Node left;
        Node right;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node L, R;
    Map<Integer, Node> hashmap;
    int capacity;

    public Main146(int cap) {
        capacity = cap;
        hashmap = new HashMap<>();
        L = new Node(-1, -1);
        R = new Node(-1, -1);
        L.right = R;
        R.left = L;
    }

    public int get(int key) {
        if (hashmap.containsKey(key)) {
            int num = hashmap.get(key).val;
            remove(key);
            insert(key, num);
            check();
            System.out.println("--- " + hashmap.size());
            return hashmap.get(key).val;
        } else {
            check();
            System.out.println("--- " + hashmap.size());
            return -1;
        }

    }

    public void put(int key, int value) {

        if (hashmap.containsKey(key)) {
            remove(key);
            insert(key, value);
        } else {
            if (capacity == hashmap.size()) {
//                R.left = R.left.left;
//                R.left.right = R;
//                hashmap.remove();

                 remove(R.left.val);

                insert(key, value);
            } else {
                insert(key, value);
            }
        }
        check();
        System.out.println("--- " + hashmap.size());
    }

    public void remove(int key) {
        Node node = hashmap.get(key);
        node.left.right = node.right;
        node.right.left = node.left;
        hashmap.remove(key);

    }

    public void insert(int key, int value) {
        Node node = new Node(key,value);
        node.right = L.right;
        node.left = L;
        L.right.left = node;
        L.right = node;
        hashmap.put(key, node);

//        return node;
    }

    public void check() {
        Node head = L;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}
