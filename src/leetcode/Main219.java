package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j]
 * 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * @author Junho
 * @date 2022/4/9 13:53
 */
public class Main219 {
    class Node{
        int idx ;
        int val;
        public Node(int idx , int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Node[] nodes = new Node[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            nodes[i] = new Node(i , nums[i]);
        }
        Arrays.sort(nodes , new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0 ; i < nodes.length ; i++){
            int kk = i + 1;
            while (kk < nodes.length && nodes[kk].val == nodes[i].val){
                if(Math.abs(nodes[kk].idx - nodes[i].idx) <= k)
                    return true;
                kk++;
            }
        }
        return false;
    }

}
