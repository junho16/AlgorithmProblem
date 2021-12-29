package offer;

import java.io.StringReader;
import java.util.*;

/**
 * 还未过的代码
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Main38 {
    public Set<String> resSet;
    public boolean[] flag;
    //    public String path = "";
    public String s;
    public String[] permutation(String sss) {
        s = sss;
        resSet = new HashSet<>();
        flag = new boolean[s.length()];
//        flag[0] = true;
        dfs(0 , "");

        String[] res = new String[resSet.size()];
        int idx = 0;
        for(String ss : resSet)
            res[idx++] = ss;
        return res;
    }
    public void dfs(int idx  , String path){


        if(idx == s.length()){
//            path += s.charAt(x);
            resSet.add(path);
            return;
        }
//        path += s.charAt(x);
        for(int i = 0; i < s.length() ; i++){
            if(!flag[i]){
                flag[i] = true;
                dfs(idx + 1 , path+s.charAt(i));
                flag[i] = false;
//                path = path.substring(0 , path.length()-1);
            }
        }
//        path = path.substring(0 , path.length()-1);
    }
}
