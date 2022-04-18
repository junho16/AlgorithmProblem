package weekGame.week_4_17;

/**
 * 6070. 计算字符串的数字和 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个由若干数字（0 - 9）组成的字符串 s ，和一个整数。
 *
 * 如果 s 的长度大于 k ，则可以执行一轮操作。在一轮操作中，需要完成以下工作：
 *
 * 将 s 拆分 成长度为 k 的若干 连续数字组 ，使得前 k 个字符都分在第一组，接下来的 k 个字符都分在第二组，依此类推。注意，最后一个数字组的长度可以小于 k 。
 * 用表示每个数字组中所有数字之和的字符串来 替换 对应的数字组。例如，"346" 会替换为 "13" ，因为 3 + 4 + 6 = 13 。
 * 合并 所有组以形成一个新字符串。如果新字符串的长度大于 k 则重复第一步。
 * 返回在完成所有轮操作后的 s 。
 *
 * @author Junho
 * @date 2022/4/17 10:31
 */
public class Main6070 {
    public static void main(String[] args) {
        System.out.println(digitSum( "11111222223",  3));
        System.out.println(digitSum( "00000000",  3));
    }
    public static String digitSum(String s, int k) {
        while (s.length() > k){
            String tmp = "";
            int tmpNum = 0;
            for(int i = 0 , j = 0 ; i < s.length() ; ){
                for( ; j < k && i + j < s.length(); j++){
                    tmpNum += (s.charAt(i + j) - '0');
                }
                i += j;
                j = 0;
//                System.out.println(i);
                tmp += (tmpNum + "");

                tmpNum = 0;
            }
            s = tmp;
//            System.out.println(s);
        }
        return s;
    }
}
