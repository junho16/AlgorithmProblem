package leetcode;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 */
public class Main470 {
    //已定义
    public int rand7(){
        return 0;
    }
    public int rand10() {
        int k = (rand7() - 1 ) * 7 + rand7();
        if(k > 40)
            return rand10();
        else{
            return (k % 10) + 1;
        }
    }
}
