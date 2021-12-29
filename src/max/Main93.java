package max;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * DFS
 */
public class Main93 {
    public List<String> res;
    public String s;

    public List<String> restoreIpAddresses(String ss) {
        s = ss;
        res = new ArrayList<>();
        dfs(0, 0, "");
        return res;
    }


    void dfs(int start, int num, String path) {
        if (num == 4) {
            if (start == s.length()) {
                res.add(path.substring(1,path.length()));
                return;
            } else {
                return;
            }
        }
        for (int i = start ; i < s.length(); i++) {
            if(i > start && s.charAt(start) == '0')
                break;
            String tmp = s.substring(start, i+1);
            if(tmp.equals(""))
                continue;
            if(tmp.length() <= 3 ){
                // System.out.println(tmp);
                int tmpNum = Integer.parseInt(tmp);
                if (tmpNum >= 0 && tmpNum <= 255)
                    dfs(i+1 , num + 1, path + "." + tmp);
            }else{
                break;
            }
        }
    }
}
//        if(s.charAt(start) == '0')
//            return;
//        if(end - start + 1 > 3){
//            return;
//        }
//        if(Integer.parseInt(s.substring(start , end+1)) > 255){
//            return;
//        }
//        for(int i = start ; i < s.length() ; i++){
//            String tmp  = s.substring(start, i);
//            if(tmp.equals(""))
//                continue;
//            if(Integer.parseInt(tmp) >= 0 && Integer.parseInt(tmp) < 256){
//                path.add(tmp);
//                dfs(i+1);
//                path.remove(path.size()-1);
//            }
//        }

