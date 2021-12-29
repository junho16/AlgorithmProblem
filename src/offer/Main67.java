package offer;

import java.util.Enumeration;

/**
 * caonim 垃圾啊
 * 这个题目 完完全全的面向数据编程了属于是
 * 剑指 Offer 67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class Main67 {
    public int strToInt(String str) {
        char[] strArr = new char[str.length()];

        if(str.equals(""))
            return 0;
        boolean isZheng = true;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ')
            index++;
        if(index < str.length() && str.charAt(index) == '-' ) {isZheng = false;index++;}
        else if(index < str.length() && str.charAt(index) =='+' ) index++;



        // int zfnum = 0;
        int idx = 0;
        for(int i = index ; i < str.length() ; i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                strArr[idx++] = str.charAt(i);
            }else{
                break;
            }
            // if(str.charAt(i) == ' ')  {
            //     if(idx != 0)
            //         return 0;
            //     else
            //         continue;
            // }else{
            //     if(str.charAt(i) == '+' || str.charAt(i) == '-') {
            //         zfnum++;
            //         if(zfnum > 1 )
            //             return 0;
            //         else
            //             strArr[idx++] = str.charAt(i);
            //     }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            //         strArr[idx++] = str.charAt(i);
            //     }else{
            //         break;
            //     }
            // }
        }

        for(int i = index ; i < strArr.length ; i++){
            System.out.print(strArr[i]);
        }



        long resnum = 0L ;
        if(idx == 0 )
            return 0;
        else {

            long b = 0L; //代表已经乘到了哪一位
            // int startidx = 0;
            // if(strArr[0] == '+' || strArr[0] == '-')
            //     startidx = 1;
            for(int k = 0; k < idx ; k++){
                resnum = resnum * 10 + (strArr[k]-'0') ;
//                resnum = resnum + (10 * strArr[k]);
                if(resnum > Integer.MAX_VALUE){
                    if(!isZheng)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                    // if(strArr[0] == '-')
                    //     return Integer.MIN_VALUE;
                    // else
                    //     return Integer.MAX_VALUE;
                }
            }
//             for(int k = idx - 1; k >= 0 ; k--){
//                 resnum = resnum + ((strArr[k]-'0') * (long)Math.pow(10 , b++));
// //                resnum = resnum + (10 * strArr[k]);
//                 if(resnum > Integer.MAX_VALUE){
//                     if(!isZheng)
//                         return Integer.MIN_VALUE;
//                     else
//                         return Integer.MAX_VALUE;
//                     // if(strArr[0] == '-')
//                     //     return Integer.MIN_VALUE;
//                     // else
//                     //     return Integer.MAX_VALUE;
//                 }
//             }
        }
        // return strArr[0] == '-' ? (int)resnum * -1 : (int) resnum;
        return !isZheng ? (int)resnum * -1 : (int) resnum;
    }
}
