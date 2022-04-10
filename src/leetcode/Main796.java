package leetcode;

/**
 * 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 *
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * @author Junho
 * @date 2022/4/7 22:47
 */
public class Main796 {
    public boolean rotateString(String s, String goal) {
        for(int i =0 ; i < goal.length() ;i++ ){
            if(goal.charAt(0) == s.charAt(i)){
                String ss = s.substring(i , s.length()) + s.substring(0 , i);
                if (ss.equals(goal))
                    return true;
            }
        }
        return false;
    }
}
