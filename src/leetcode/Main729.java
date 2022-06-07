package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 729. 我的日程安排表 I
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 *
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
 *
 * 实现 MyCalendar 类：
 *
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * @author Junho
 * @date 2022/6/6 22:42
 */
public class Main729 {

    class Node{
        int start;
        int end;
        public Node(int s , int e){
            this.start = s;
            this.end = e;
        }
    }

    TreeSet<Node> treeSet;

    public Main729() {
        treeSet = new TreeSet(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start - o2.start;
            }
        });
        treeSet.add(new Node((int) -1e9 , (int) -1e9));
        treeSet.add(new Node((int) 1e9 , (int) 1e9));
    }

    boolean check(Node nodeNow , Node nodeCheck){
        if((nodeNow.end <= nodeCheck.start ) ||
                (nodeNow.start >= nodeCheck.end)
        ){
            //没有交集
            return false;
        }
        return true;
//        下面这个判别方式是错误的。。。虽然我也不知道哪里错了
//        if((nodeNow.start < nodeCheck.start && nodeNow.end < nodeCheck.end) ||
//                (nodeNow.start > nodeCheck.start && nodeNow.end > nodeCheck.end)
//        ){
//            //没有交集
//            return false;
//        }
//        return true;
    }

    public boolean book(int start, int end) {
        Node now = new Node(start , end);
        Node leftNode = treeSet.floor(now);
        Node rightNode = treeSet.ceiling(now);


        if(check(now , leftNode) || check(now , rightNode)){
            return false;
        }
        treeSet.add(now);
        return true;
    }
}
