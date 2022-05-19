package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * @author Junho
 * @date 2022/5/17 21:58
 */
public class Main658 {
    public class Node{
        //值
        int val;
        //差值
        int dif;
        public Node(int val, int dif){
            this.dif = dif;
            this.val = val;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int left = 0 , right = arr.length - 1;
//        while(left < right){
//            int mid = left + right >> 1;
//            if(arr[mid] > x){
//                right = mid - 1;
//            }else{
//                left = mid;
//            }
//        }
//        System.out.println(left + " " + right + " " + arr[left]);



        List<Node> res = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            res.add(new Node(arr[i] , Math.abs(arr[i] - x)));
        }
        Collections.sort(res, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.dif != o2.dif){
                    return o1.dif - o2.dif;
                }else{
                    return o1.val - o2.val;
                }
            }
        });
        res = res.subList(0, k);
        List<Integer> ress = new ArrayList<>();
        for(Node n : res){
            ress.add(n.val);
        }
        Collections.sort(ress);
        return ress;
    }

}
