package leetcode;

import javax.swing.plaf.IconUIResource;

/**
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * @author Junho
 * @date 2022/4/24 19:56
 */
public class Main868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(5));
    }
    public static int binaryGap(int n) {
        int res = 0 ;
        int count = 0;
        int last = -1;
        while (n != 0 ){
            int x = n & 1;
            if(x == 1){
                if(last != -1)
                    res = Math.max(res , count - last);
                last = count;
            }
            n >>= 1;
            count++;
        }
        return res;
    }
}
