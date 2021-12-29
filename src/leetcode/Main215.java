package leetcode;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Main215 {

    public int findKthLargest(int[] nums, int k) {

        //数组元素转换为数值流
        IntStream stream = Arrays.stream(nums);
        //流中元素全部装箱
        Stream<Integer> st = stream.boxed();
        //将流转换为数组
        Integer[] num = st.toArray(Integer[]::new);
        Arrays.sort(num , Collections.reverseOrder());
        // for(int i = 0 ; i< num.length ;i++)
        //     System.out.print(num[i]+ " ");


        return num[k-1];

        // int idx = 0 ;
        // for(int i = 0 ; i < num.length ;i++){
        //     idx++;
        //     if(idx == k)
        //         return num[i];
        //     while(i+1 < num.length && num[i] == num[i+1])
        //         i++;
        // }
        // return idx;
    }
    //=====================
    //以下是使用大根堆
    public int findKthLargests(int[] nums, int k) {
        PriorityQueue queue = new PriorityQueue<Integer>((a,b)->{return b-a;});
        for(int i = 0 ; i < nums.length; i++){
            queue.add(nums[i]);
        }
        for(int i = 0 ; i < k-1 ; i++){
            queue.poll();
        }
        return (int) queue.peek();
    }
    //=====================
    //以上是使用库函数做的，但是实际情况下应该选择写一个快排，因为这个快选的基础就是快排
    static int kk;
    static int[] numss;
    public int findKthLargestss(int[] nums, int k) {
        kk = k - 1;
        numss = nums;
        return quick_sort( 0, nums.length - 1  );
    }
    public int quick_sort(  int l , int  r  ){
        if(l == r)   return numss[kk];
        int x = numss[l];
        int i = l-1;
        int j = r+1;
        while (i < j){
            do i++; while (numss[i] > x);
            do j--; while (numss[j] < x);
            if(i < j){
                int tmp = numss[j];
                numss[j] = numss[i];
                numss[i] = tmp;
            }
        }
        if(kk <= j)
            return quick_sort( l , j );
        else
            return quick_sort(j+1 , r );
    }
}
