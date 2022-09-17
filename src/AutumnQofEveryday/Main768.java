package AutumnQofEveryday;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 768. 最多能完成排序的块 II
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 我们最多能将数组分成多少块？
 *
 * 单调栈或者排序+hash==》不断添加和删除掉原数组和排序后的元素 若发现map的数量为0则说明可以分割为一段
 * @author Junho
 * @date 2022/9/12 11:15
 */
public class Main768 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{  2,1,3,4,4  }));
    }
    public static int maxChunksToSorted(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr , arr.length);
        Arrays.sort(sortedArr ,0 , sortedArr.length);
        Map<Integer , Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < sortedArr.length ; i++){
             map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
             if(map.get(arr[i]) == 0 ){
                map.remove(arr[i]);
             }
             map.put(sortedArr[i] , map.getOrDefault(sortedArr[i] , 0) - 1);
            if(map.get(sortedArr[i]) == 0 ){
                map.remove(sortedArr[i]);
            }

             if(map.size() == 0){
                 res++;
             }
        }
        return res;
    }
    //单调栈解法:
//    class Solution {
//        public int maxChunksToSorted(int[] arr) {
//            Deque<Integer> stack = new ArrayDeque<Integer>();
//            for (int num : arr) {
//                if (stack.isEmpty() || num >= stack.peek()) {
//                    stack.push(num);
//                } else {
//                    int mx = stack.pop();
//                    while (!stack.isEmpty() && stack.peek() > num) {
//                        stack.pop();
//                    }
//                    stack.push(mx);
//                }
//            }
//            return stack.size();
//        }
//    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/solution/zui-duo-neng-wan-cheng-pai-xu-de-kuai-ii-w5c6/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
