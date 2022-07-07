package weekGame.week_6_19;

/**
 * 5218. 个位数字为 K 的整数之和
 * 给你两个整数 num 和 k ，考虑具有以下属性的正整数多重集：
 *
 * 每个整数个位数字都是 k 。
 * 所有整数之和是 num 。
 * 返回该多重集的最小大小，如果不存在这样的多重集，返回 -1 。
 * 多重集与集合类似，但多重集可以包含多个同一整数，空多重集的和为 0 。
 * 个位数字 是数字最右边的数位。
 * @author Junho
 * @date 2022/6/19 13:25
 */
public class Main5218 {

    public int minimumNumbers(int num, int k) {

        int i;
        if(num == 0 ){
            return 0;
        }
        if(k == 0){
            return num % 10 == 0 ? 1 : -1;
        }

        for(i = 1 ;( num - k * i) % 10 != 0 && num >= k*i ; i++){

        }
        if((num - i * k) % 10 != 0 ){
            return -1;
        }else{
            return i;
        }


    }
}
