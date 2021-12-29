package offer;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 */
public class Main20 {
    public boolean isNumber(String s) {
        /**
         * 先去掉所有空格
         * 判断是否为数字 .   + - e E
         * 记录数字个数 若为0则报错
         * 如果是. 记录个数或者修改标记 超出就报错
         *
         * 如果出现的是+/- 判断其出现的位置是否为第一个 如果不是第一个 则判断前面是否有E、e
         *
         *
         */
        s = s.replace(" " , "");
        int pointNum = 0;
        int szNum = 0;
        for(int i = 0 ; i < s.length() ;i++){
            char c = s.charAt(i);
            if( c != '.' && c != '+' && c != '-' && c != 'e' && c != 'E' && !(c >= '0' && c <= '9')){
                return false;
            }
            if(c == '.'){
                if(++pointNum > 1)
                    return false;
            }
            if(c >= '0' && c <= '9'){
                szNum++;
            }
            if(c == '+' || c == '-'){
                if(i != 0 && i>0 && (s.charAt(i-1)!='e'||s.charAt(i-1)!='E') )
                    return false;
            }
        }
        if(szNum == 0)
            return false;
        else return true;
    }

    public static void main(String[] args) {
        Main20 main20 = new Main20();
        String[] strings = {"+100", "5e2", "-123", "3.1416", "-1E-16", "0123"};
        String[] strings2 = { "12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
        for(int i = 0 ;i < strings.length ;i++){
            System.out.println(main20.isNumber(strings[i]));
        }
        System.out.println("========");
        for(int i = 0 ;i < strings2.length ;i++){
            System.out.println(main20.isNumber(strings2[i]));
        }
    }
}
