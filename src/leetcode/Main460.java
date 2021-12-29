package leetcode;

import java.util.*;

/**
 * 460. LFU 缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 *
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * @author 花菜
 * @date 2021/11/21 22:05
 */
public class Main460 {
    public class Node{
        int key;
        int value;
        int count;
        public Node(int key , int value){
            this.count = 0;
            this.key = key;
            this.value = value;
        }
    }

    //记录每一个key值对应的节点
    public Map<Integer , Node> nodeMap;
    //记录每一个count值对应的LinkedHashSet
    public Map<Integer , LinkedHashSet<Node>> setMap;
    public Node L;
    public Node R;
    public int capacity;
    public Main460(int cap) {
        capacity = cap;
        nodeMap = new TreeMap<>();
        setMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null)
            return -1;
        else{
            //删除原节点，若size为0，则直接删掉count的set
            LinkedHashSet set = setMap.get(node.count);
            set.remove(node);
            if(set.size() == 0) {
                setMap.remove(node.count);
            }
            //添加（count++）,没有则先创建
            if(! setMap.containsKey(node.count+1)) {
                setMap.put(node.count+1 , new LinkedHashSet<>());
            }
            LinkedHashSet addSet = setMap.get(node.count+1);
            node.count++;
            addSet.add(node);
            // check();
            return node.value;
        }
    }

    public void put(int key, int value) {
        //如果此节点之前就存在
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);

            //删除原节点，若size为0，则直接删掉count的set
            LinkedHashSet set = setMap.get(node.count);
            set.remove(node);
            if(set.size() == 0) {
                setMap.remove(node.count);
            }
            //添加（count++）,没有则先创建
            if(! setMap.containsKey(node.count+1)) {
                setMap.put(node.count+1 , new LinkedHashSet<>());
            }
            LinkedHashSet addSet = setMap.get(node.count+1);
            node.count++;
            node.value = value;
            addSet.add(node);

        }else{
            if(capacity == 0){
                return;
            }
            //若之前未出现，判断是否已满
            if(nodeMap.size() == capacity){
                //如果满了
                //先删去最小的块的最小的元素
                Integer minCount = 0 ;
                LinkedHashSet minSet = null;
                Iterator<Map.Entry<Integer, LinkedHashSet<Node>>> blockItor = setMap.entrySet().iterator();
                while ( blockItor.hasNext()) {
                    Map.Entry<Integer, LinkedHashSet<Node>> entry = blockItor.next();
                    minCount = entry.getKey();
                    minSet = entry.getValue();
                    break;
                }
                Node deleteNode = (Node) minSet.iterator().next();
                minSet.remove(deleteNode);
                if(minSet.size() == 0){
                    setMap.remove(deleteNode.count);
                }
                nodeMap.remove(deleteNode.key);

                //再添加进入
                Node node = new Node(key, value);
                node.count++;
                if(! setMap.containsKey(1)){
                    setMap.put(1 , new LinkedHashSet<>());
                }
                LinkedHashSet addSet = setMap.get(1);
                addSet.add(node);
                nodeMap.put(key , node);
            }else{
                //如果没满
                Node node = new Node(key, value);
                node.count++;
                if(! setMap.containsKey(1)){
                    setMap.put(1 , new LinkedHashSet<>());
                }
                LinkedHashSet addSet = setMap.get(1);
                addSet.add(node);
                nodeMap.put(key , node);
            }
        }
        // check();
    }
    public void check(){
        System.out.println("node");
        Iterator it1 = nodeMap.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<Integer, Node> entry = (Map.Entry<Integer, Node>) it1.next();
            Integer i = entry.getKey();
            Node n = entry.getValue();
            System.out.println(i+":"+n.key+" " + n.value+" "+n.count+"|");
        }
        // System.out.println("-------------------");
        System.out.println("set");
        Iterator it2 = setMap.entrySet().iterator();
        while ( it2.hasNext()) {
            Map.Entry<Integer, LinkedHashSet<Node>> entry = (Map.Entry<Integer, LinkedHashSet<Node>>) it2.next();
            Integer i = entry.getKey();
            LinkedHashSet<Node> ls = entry.getValue();
            System.out.println(i+":");
            for(Node n : ls){
                System.out.println(+n.key+" " + n.value+" "+n.count+"|");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}