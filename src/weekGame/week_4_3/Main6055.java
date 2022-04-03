package weekGame.week_4_3;

/**
 * 6055. 转化时间需要的最少操作数 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 *
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 *
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 *
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * @author Junho
 * @date 2022/4/3 10:33
 */
public class Main6055 {
    public static void main(String[] args) {
        System.out.println(convertTime("02:30" , "04:35"));
    }
    public static int convertTime(String current, String correct) {
        String[] str_cur = current.split(":");
        String[] str_cor = correct.split(":");
        int cur_sum = Integer.parseInt(str_cur[0]) * 60 + Integer.parseInt(str_cur[1]);
        int cor_sum = Integer.parseInt(str_cor[0]) * 60 + Integer.parseInt(str_cor[1]);
        int sum = 0;
        if(cur_sum <= cor_sum ){
            sum = cor_sum - cur_sum;
        }else{
            sum = 24 * 60 - cur_sum + cor_sum;
        }
        int res = 0;
        res += sum / 60;
        sum = sum % 60;
        res += sum / 15;
        sum = sum % 15;
        res += sum / 5;
        sum = sum % 5;
        res += sum;
        return res;
    }
}
