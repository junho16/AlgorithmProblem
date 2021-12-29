package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Main51 {
    public int[] nums;
    public int reversePairs(int[] n) {
        nums = n;
        return merge(0,nums.length-1);
    }
    public int merge(int l , int r){
        int mid = (l + r) >> 1;
        int res = merge(l , mid - 1) + merge(mid + 1 , r);
        ArrayList<Integer> list = new ArrayList();
        int leftIdx = l;
        int rightIdx = mid+1;
        while( leftIdx <= mid && rightIdx <= r){
            if(nums[leftIdx] <= nums[rightIdx]){
                list.add(nums[rightIdx++]);
            }else{
                list.add(nums[leftIdx++]);
                res += mid - leftIdx + 1;
            }
        }
        while (leftIdx <= mid){
            list.add(nums[leftIdx++]);
        }
        while (rightIdx <= mid){
            list.add(nums[rightIdx++]);
        }
        for(Integer i : nums){
            nums[l++] = i;
        }
        return res;
    }
}