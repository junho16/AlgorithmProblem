package leetcode;

/**
 * 942. 增减字符串匹配
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * @author Junho
 * @date 2022/5/10 9:38
 */
public class Main942 {
    public int[] diStringMatch(String s) {

        int[] res = new int[s.length()+1];
        int bigIdx = s.length();
        int smallIdx = 0;
        int idx = 0;
        for(int i = 0 ;i < s.length() ; i++){
            if(s.charAt(i) == 'I'){
                res[idx++] = smallIdx++;
            }else{
                res[idx++] = bigIdx--;
            }
        }
        if(s.length() - 1 == 'I'){
            res[idx++] = bigIdx--;
        }else{
            res[idx++] = smallIdx++;
        }
        return res;
    }
}
