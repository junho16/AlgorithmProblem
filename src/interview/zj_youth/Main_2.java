package interview.zj_youth;

import java.util.HashSet;
import java.util.Set;

/**
 * 【编程题】数组两数求和
 * 描述
 *
 * 从给定的无序、不重复的数组A中，取出2个数，使其相加和为M。
 *
 * 输出该数组内所有满足上述条件的解的个数。
 *
 *
 * 输入
 * 第一行两个数 N 和 M，N 为数组长度，M 为相加之和。
 *
 * 第二行为实际的数组元素。
 *
 *
 * 输出
 * 解的个数
 *
 *
 * 输入样例 1
 *
 * 2 4
 * 1 3
 * 输出样例 1
 *
 * 1
 * 输入样例 2
 *
 * 10 7
 * 0 1 2 3 4 5 6 7 8 9
 * 输出样例 2
 *
 * 4
 * 输入样例 3
 *
 * 3 9
 * 1 2 3
 * 输出样例 3
 *
 * 0
 *
 * @author Junho
 * @date 2022/4/24 16:24
 */
public class Main_2 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 3} , 2, 4));
        System.out.println(solve(new int[]{1,2,3} , 3,9));
        System.out.println(solve(new int[]{0 ,1, 2, 3, 4, 5, 6, 7, 8, 9 } , 10, 7));

    }
    static int solve(int[] arr, int n, int m) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n ; i++){
            set.add(arr[i]);
        }
        int res = 0;
        for(int i = 0; i < n ; i++){
            if(set.contains(m - arr[i]))
                res++;
        }
        return res/2;
    }
}
