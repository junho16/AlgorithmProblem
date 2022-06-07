package leetcode;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * @author Junho
 * @date 2022/5/29 19:46
 */
public class Main202 {
    public int getSum(int x){
        int sum = 0 ;
        String s = x + "";
        for(int i = 0 ; i < s.length() ; i++){
            sum += Math.pow(s.charAt(i) - '0'  , 2) ;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slowNum = getSum(n);
        int fastNum = getSum(n);
        fastNum = getSum(n);
        while (fastNum != slowNum){
            slowNum = getSum(n);
            fastNum = getSum(n);
            fastNum = getSum(n);
        }
        return slowNum == 1;
    }
}
