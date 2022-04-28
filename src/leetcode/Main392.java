package leetcode;

/**
 * 不用dp了 双指针就做了
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * @author Junho
 * @date 2022/4/21 19:38
 */
public class Main392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0;
        while (i < s.length() && j < t.length() ){
            char c = s.charAt(i);
            while (j < t.length() && t.charAt(j) != c){
                j++;
            }
            if(j < t.length()){
                i++;
                j++;
            }
        }
        return (i == s.length());
    }
}