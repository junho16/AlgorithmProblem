package leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * @author Junho
 * @date 2022/3/24 9:52
 */
public class Main97 {
    String s1;
    String s2;
    String s3;

    Map<String , Boolean> map = new HashMap<>();
    public boolean isInterleave(String s11, String s22, String s33) {
        if(s11.length() + s22.length() != s33.length())
            return false;
        s1 = s11;
        s2 = s22;
        s3 = s33;
        return dfs(0 ,0 , 0);
    }
    public boolean dfs(int idx_s1 , int idx_s2 , int idx_s3){
        if(idx_s3 == s3.length())
            return true;
        if(idx_s1 == s1.length()){
            return s2.substring(idx_s2).equals(s3.substring(idx_s3));
        }
        if(idx_s2 == s2.length()){
            return s1.substring(idx_s1).equals(s3.substring(idx_s3));
        }
        if(map.containsKey(idx_s1 + " " + idx_s2 + " " + idx_s3)){
            return map.get(idx_s1 + " " + idx_s2 + " " + idx_s3);
        }
        //如果没找到
        if(s3.charAt(idx_s3) != s2.charAt(idx_s2) && s3.charAt(idx_s3) == s1.charAt(idx_s1)){
            boolean res_1 = dfs(idx_s1 + 1 , idx_s2 , idx_s3 + 1);
            map.put(idx_s1 + 1 + " " + idx_s2 +" "+ idx_s3  +1  , res_1);
            return res_1;
        }
        if(s3.charAt(idx_s3) != s1.charAt(idx_s1) && s3.charAt(idx_s3) == s2.charAt(idx_s2)){
            boolean res_2 = dfs(idx_s1  , idx_s2 + 1 , idx_s3  +1);
            map.put(idx_s1  + " " + idx_s2 + 1 +" "+ idx_s3  +1 , res_2);
            return res_2;
        }
        boolean res = false;
        if(s3.charAt(idx_s3) == s1.charAt(idx_s1) && s3.charAt(idx_s3) == s2.charAt(idx_s2)){
            res = dfs(idx_s1 + 1, idx_s2 , idx_s3 + 1) || dfs(idx_s1 , idx_s2 + 1 , idx_s3 + 1);
        }
        map.put( idx_s1 + " " + idx_s2  +" "+ idx_s3   , res);
        // for(String node : map.keySet()){
        //     System.out.println(node + map.get(node));
        // }
        return res;
    }
}
