package weekGame.week_4_17;

import java.util.HashMap;
import java.util.Map;

/**
 * 6071. 完成所有任务需要的最少轮数 显示英文描述
 * 通过的用户数775
 * 尝试过的用户数889
 * 用户总通过次数775
 * 用户总提交次数1010
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 *
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 * 示例 2：
 *
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 *
 *
 * 提示：
 *
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 *
 * @author Junho
 * @date 2022/4/17 10:47
 */
public class Main6071 {
    /**
     * 61/78
     * 输入：
     * [69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69]
     * 输出：
     * 21
     * 预期：
     * 20
     */
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69}));
    }
    public static int minimumRounds(int[] tasks) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ;i < tasks.length ;i++){
            map.put(tasks[i] , map.getOrDefault(tasks[i] , 0) + 1);
        }
        int res = 0;
        for(Integer i : map.keySet()){

            int x = map.get(i);
//            if((x % 2 == 0 && x % 3 == 0) || (x % 3 == 0) ){
//                res += x / 3;
//                System.out.println(i + " "+ map.get(i)+" " +  x / 3);
//            }else if(x % 2 == 0){
//                res += x / 2;
//                System.out.println(i + " "+ map.get(i)+" " +  x / 2);
//            }else{
            int f = Integer.MAX_VALUE;
            for(int k = 0; k * 3 <= x ; k++ ){
                if((x - k * 3 ) % 2 == 0){
                    f = Math.min(f , k + ((x - k * 3) / 2) );
                }
            }
            for(int k = 0; k * 2 <= x ; k++ ){
                if((x - k * 2 ) % 3 == 0){
                    f = Math.min(f , k + ((x - k * 2) / 3) );
                }
            }
            // System.out.println(i + " "+ map.get(i)+" " +  f);
            if(f == Integer.MAX_VALUE)
                return -1;
            else{
                res += f;
            }
//            }
        }
        return res;
    }

}
//    for(Integer i : map.keySet()){
//        int x = map.get(i);
//        if(x % 2 != 0 && x % 3 != 0)
//            return -1;
//        else if((x % 2 == 0 && x % 3 == 0) || (x % 3 == 0) ){
//            res += x / 3;
//        }else{
//            res += x / 2;
//        }
//    }
