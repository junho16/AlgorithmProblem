package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @author Junho
 * @date 2022/4/23 10:15
 */
public class Main91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("10"));
    }
    public static  int numDecodings(String s) {

        Map<String , String> map = new HashMap<>();
        for(int i = 1 ; i <= 26 ; i++){
            map.put( i + "" , "A" + (i-1) );
        }
        if(s.length() == 1){
            return map.containsKey(s.charAt(0)+"")?1:0;
        }
//        dp[i] : i 之前可以映射的最多数
        int[] dp = new int[s.length()];
        dp[0] = map.containsKey(s.charAt(0)+"")?1:0;
//        dp[1] += map.containsKey(s.charAt(0) +"" + s.charAt(1))?2
        if(map.containsKey(s.charAt(1)+"")){
            dp[1] += (dp[0]);
        }
        if(map.containsKey(s.charAt(0) + "" + s.charAt(1))){
            dp[1] += 1;
        }

//        if(map.containsKey(s.charAt(0) + "" + s.charAt(1))){
//            dp[1] = 1 + dp[0];
//        }else{
//            dp[1] = dp[0];
//        }
        for(int i = 2 ;i < s.length() ;i++){
            if(map.containsKey(s.charAt(i)+"")){
                dp[i] += (dp[i-1]);
            }
            if(map.containsKey(s.charAt(i-1) + "" + s.charAt(i))){
//                dp[i] = Math.max(dp[i-2] + 1 , dp[i]);
                dp[i] += (dp[i-2] );
            }
        }
        return dp[s.length()-1];
    }
}
//class Solution {
//    public int numDecodings(String s) {
//        int n = s.length();
//        int[] f = new int[n + 1];
//        f[0] = 1;
//        for (int i = 1; i <= n; ++i) {
//            if (s.charAt(i - 1) != '0') {
//                f[i] += f[i - 1];
//            }
//            if (i > 1 && s.charAt(i - 2) != '0' &&
//            ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
//                f[i] += f[i - 2];
//            }
//        }
//        return f[n];
//    }
//}
