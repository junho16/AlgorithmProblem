package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * @author Junho
 * @date 2022/5/11 15:03
 */
public class Main93 {
    List<String> res = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String ss) {
        s = ss;
        dfs("" , 0 , 0);
        return res;
    }
    void dfs(String str , int count , int idx){
        if(count == 4){
            if(idx == s.length())
                res.add(str.substring( 0 , str.length() - 1));
        }
        for(int i = idx; i < s.length() ; i++){
            String tmp = s.substring(idx , i+1);
            if(tmp.equals("") || (tmp.length() > 1 && tmp.startsWith("0"))){
                break;
            }else{
                if( ( tmp.length() <= 3 && Integer.parseInt(tmp) >= 0 && Integer.parseInt(tmp) <= 255) )
                    //可加
                    dfs(str + tmp + "." , count + 1 , i + 1);
            }
        }
    }
}
