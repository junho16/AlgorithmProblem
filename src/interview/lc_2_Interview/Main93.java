package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class Main93 {
    List<String> res;
    String s;
    public List<String> restoreIpAddresses(String ss) {
        s = ss;
        res = new ArrayList<>();
        dfs(0 ,  0 , "");
        return res;
    }
    void dfs(int idx , int size , String path){
        if(size == 4){
            if(idx == s.length()){
                res.add(path.substring(1 , path.length()));
                return;
            }else
                return;
        }
        for(int i = idx ; i < s.length() ; i++){

            String tmp = s.substring(idx , i + 1);
            if(tmp.equals(""))
                continue;
            if(i > idx && s.charAt(idx) == '0')
                break;
            if(tmp.length() <= 3 && Integer.parseInt(tmp) >= 0 && Integer.parseInt(tmp) <= 255){
                dfs(i + 1 , size + 1 , path + "." + tmp);
            }else
                break;
        }
    }
//    这种一遍扫过去就行的 就不需要path了 可以直接用变量记录 下面是错误解法
//    List<String> res;
//    List<String> path;
//    String s;
//    public List<String> restoreIpAddresses(String ss) {
//        res = new ArrayList();
//        path = new ArrayList();
//        s = ss;
//        dfs(0);
//        return res;
//    }
//    void dfs(int idx){
//        if(idx == s.length()){
//            if(path.size() == 4){
//                String pathStr = "";
//                for(String str : path){
//                    pathStr += str + ".";
//                }
//                res.add(pathStr.substring(0 , pathStr.length() - 1));
//                return;
//            }
//        }
//        if(idx > s.length())
//            return;
//        if(path.size() > 4)
//            return;
//        if(s.charAt(idx) == '0')
//            return;
//        for(int i = 1 ;i <= 3 ; i++){
//            String item = s.substring(idx , idx + i >= s.length()? s.length() : idx + i );
//            if(Integer.parseInt(item) < 255){
//                path.add(item);
//                dfs(idx + i + 1 );
//                path.remove(path.size() - 1);
//            }
//        }
//    }
}
