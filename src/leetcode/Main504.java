package leetcode;

/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 */
public class Main504 {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        boolean isfu = false;
        if(num < 0){
            isfu = true;
            num = -num;
        }
        String s = "";
        while(num != 0){
            s += num % 7;
            num = num / 7;
        }
        return isfu ? "-"+new StringBuilder(s).reverse().toString()
                : new StringBuilder(s).reverse().toString();
    }
}
