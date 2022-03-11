package leetcode;

import java.util.Map;

/**
 * 一个简单的模拟 从前往后扫描一遍 从后往前扫描一遍 记录一下上一个字符c出现的位置并计算二者的差值， 最后取出最小的距离就可以
 * 821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 */
public class Main821 {
    public int[] shortestToChar(String s, char c) {
        int last = Integer.MIN_VALUE - 1 ;
        int[] res = new int[s.length()];
        for(int i = 0 ;i < s.length(); i++){

            if(s.charAt(i) == c){
                last = i;
                res[i] = 0;
            }else{
                res[i] = Math.abs(i - last);
            }

        }
        for(int i = 0 ; i < s.length() ; i++){
            System.out.println(res[i]);
        }
        last = Integer.MAX_VALUE;
        for(int i = s.length() - 1; i >= 0 ; i--){
            if(s.charAt(i) == c){
                last = i;
                res[i] = 0;
            }else{
                res[i] = Math.min(Math.abs(last - i) , res[i]);
            }
        }
        return res;
    }
}
