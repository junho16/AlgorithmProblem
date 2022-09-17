package AutumnQofEveryday;

/**
 * 1342. 将数字变成 0 的操作次数
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * @author Junho
 * @date 2022/9/14 14:48
 */
public class Main1342 {
    public int numberOfSteps(int num) {
        int res = 0;
        while(num != 0 )
        {
            if(num == 1)
                res = res+1;
            else if((num & 1) != 0)
                res = res+2;
            else
                res = res+1;
            num = num >> 1 ;
        }
        return res;
    }
}
