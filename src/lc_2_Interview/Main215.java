package lc_2_Interview;

import java.util.ArrayList;

/**
 * 考快排 要是写不出来 就马上转到堆排 =.=
 *
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Main215 {
    public int[] nums;
    public int findKthLargest(int[] n, int k) {
        nums = n;
        quickSort(0 , nums.length - 1);
        // for(int i=0 ;i < nums.length; i++){
        //     System.out.print(nums[i] + " ");
        // }
        return nums[nums.length - k];
    }
    void quickSort(int l , int r){
        if(l >= r)
            return;
        int left = l - 1;
        int right = r + 1;
        int mid = nums[l];
        while (left < right){
            do{
                left++;
            }while (nums[left] < mid);
            do{
                right--;
            }while (nums[right] > mid);
            if(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        quickSort(l , right);
        quickSort(right + 1 , r);
    }
}
