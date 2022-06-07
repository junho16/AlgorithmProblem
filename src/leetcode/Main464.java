package leetcode;

import java.util.Arrays;

/**
 * 464. 我能赢吗
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 *
 * @author Junho
 * @date 2022/5/26 21:40
 */
public class Main464 {
    int maxInteger;
    int desired;

    //flag位置 0输了 1赢了 -1未处理
    int[] flag;

    /**
     * x代表第几位
     * 返回输赢 true赢了 false输了
     * @param x
     * @return
     */
    boolean dp(int x){
        if(flag[x] != -1){
            return flag[x] == 1;
        }
        int sum = 0;
        for(int i = 0 ; i < maxInteger ; i++){
            sum += (1 >> i & 1);
        }
        for(int i = 0 ; i < maxInteger ; i++){
            if((1 >> i & 1) == 0 ){
                continue;
            }
            if(sum + i + 1 >= desired ){
                flag[x] = 1;
                return true;
            }
            int tmp = x + (1 << i);
            if(! dp(tmp)){
                flag[x] = 1;
                return true;
            }
        }
        flag[x] = 0;
        return false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if( maxInteger * (maxInteger + 1) / 2 < desiredTotal )
            return false;
        flag = new int[1 << maxChoosableInteger];
        Arrays.fill(flag , -1 );
        maxInteger = maxChoosableInteger;
        desired = desiredTotal;
        //从第0位开始
        return dp(0);
    }
}
