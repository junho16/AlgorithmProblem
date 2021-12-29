package max;

/**
 * 快排-递归和非递归
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class Main912 {
    public int[] nums;
    public int[] sortArray(int[] n) {
        nums = n;
        quick_sort(0 , n.length - 1);
        return nums;
    }
    public void quick_sort(int l , int r){
        if(l >= r)
            return;
        int left = l - 1 ;
        int right = r + 1;
        int x = nums[(left + right) >> 1];
        while (left < right){
            do{
                left++;
            }while (nums[left] < x);
            do{
                right--;
            }while (nums[right] > x);
            if(left < right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }
        quick_sort(l , right );
        quick_sort(right + 1  , r);
    }


    
}
