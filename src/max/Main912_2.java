package max;

import java.util.Stack;

/**
 * 非递归 未通过测试。。。
 * 看的博客是：https://blog.csdn.net/qq_36528114/article/details/78667034
 */
public class Main912_2 {
    public int[] nums;
    public int[] sortArray(int[] n) {
        nums = n;
        quick_sort(0 , n.length - 1);
        return nums;
    }
    public void quick_sort(int l , int r){
        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(r);
        while (!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            int index = act(left , right);
            if(left + 1 < index){
                stack.push(left);
                stack.push(index - 1);
            }
            if(right - 1 > index){
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }
    public int act(int l , int r){
        int x = nums[r];
        while (l < r){
            while (l < r && nums[l] <= x){
                ++l;
            }
            nums[r] = nums[l];
            while (l < r && nums[r] >= x){
                --r;
            }
            nums[l] = nums[r];
        }
        nums[r] = x;
        return r;
    }
}