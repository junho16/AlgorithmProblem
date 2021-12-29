package offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Main65 {
    public int add(int a, int b) {
        //使用b来存储进位后的值 a存储答案
        while(b != 0){
            //首先不进位加
            int num1 = a ^ b;
            //记录下有进位的数并右移动1位也就是获得其进位的结果
            int carry = (a & b) << 1;
            //使用b存储进位结果 如果出现b == 0 的情况下 就说明已经没有进位可以使用了 a存储的就是res
            a = num1;
            b = carry;
        }
        return a;
    }
}
