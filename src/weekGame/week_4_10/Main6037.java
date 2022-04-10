package weekGame.week_4_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 6037. 按奇偶性交换后的最大数字 显示英文描述
 * 通过的用户数1982
 * 尝试过的用户数2484
 * 用户总通过次数1988
 * 用户总提交次数3034
 * 题目难度Easy
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 *
 * 返回交换 任意 次之后 num 的 最大 可能值。
 *
 * @author Junho
 * @date 2022/4/10 10:47
 */
public class Main6037 {
    /**
     * 247
     * 输出：
     * 742
     * 预期：
     * 427
     */
    public static void main(String[] args) {
        System.out.println(largestInteger(247));
        System.out.println(largestInteger(1234));
        System.out.println(largestInteger(65875));
    }
    public static  int largestInteger(int num) {

        List<String> j_list = new ArrayList<>();
        List<String> o_list = new ArrayList<>();
        List<Integer> j_idxlist = new ArrayList<>();
        List<Integer> o_idxlist = new ArrayList<>();
        String s = num + "";
        for (int i = 0; i < s.length(); i++) {
            if (Integer.parseInt(s.charAt(i) + "") % 2 == 0) {
                o_list.add((s.charAt(i) + ""));
                o_idxlist.add(i);
            } else {
                j_list.add((s.charAt(i) + ""));
                j_idxlist.add(i);
            }
        }
        Collections.sort(o_list);
        Collections.sort(j_list);

        int[] res = new int[s.length()];
        int j_idx = j_list.size() - 1;
        int o_idx = o_list.size() - 1;
        for (int i = 0; i < j_idxlist.size(); i++) {
            res[j_idxlist.get(i)] = Integer.parseInt(j_list.get(j_idx--));
        }
        for (int i = 0; i < o_idxlist.size(); i++) {
            res[o_idxlist.get(i)] = Integer.parseInt(o_list.get(o_idx--));
        }
        String resStr = "";
        for (int i = 0; i < res.length; i++) {
            resStr += res[i];
        }
        return Integer.parseInt(resStr);
    }
}
