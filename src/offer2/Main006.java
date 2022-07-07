package offer2;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * @author Junho
 * @date 2022/6/21 19:10
 */
public class Main006 {
    public int[] twoSum(int[] numbers, int target_) {
        int[] res = new int[2];
        for(int i = 0; i < numbers.length ; i++){
            int target = target_ - numbers[i];
            int l = 0, r = numbers.length - 1;
            while (l < r){
                int mid = l + r + 1>> 1;
                if(numbers[mid] <= target){
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            // System.out.println(l +" " +r  + "  "+ i);
            if(l == r && l != i && numbers[l] == target){
                res[0] = Math.min(l , i);
                res[1] = Math.max(l , i);
                return res;
            }
        }
        return new int[]{-1,-1};
    }
}
