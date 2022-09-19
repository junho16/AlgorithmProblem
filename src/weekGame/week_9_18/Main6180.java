package weekGame.week_9_18;

/**
 * 6180. 最小偶倍数
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * @author Junho
 * @date 2022/9/18 10:32
 */
public class Main6180 {
    public int smallestEvenMultiple(int n) {
        int gcd = 0;
        for(int i = 1; i <= 2 && i <= n ; i++) {
            // 判断最大公约数
            if(n % i == 0 && 2 % i == 0)
                gcd = i;
        }
        return (n * 2) / gcd;
    }
}
