package leetcode;

/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 */
public class Main405 {
    public String toHex(int num) {
        //分成8组，每组4位  （取4位，删除4位）
        if(num==0) return "0";
        String hex = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.append(hex.charAt(num&0xf));
            num>>>=4;  //无符号右移
        }
        return sb.reverse().toString();
        // if(num == 0)return "0";
        // String res = "";
        // String nums = "0123456789abcdef";
        // while(num != 0){
        //     res += nums.charAt(num & 0xf);
        //     num = num >>> 4;
        // }
        // return new StringBuilder(res).reverse().toString();

    }
}
