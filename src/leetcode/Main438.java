package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 经典双指针算法
 */
public class Main438 {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character , Integer> oriMap = new HashMap<>();
        for(int i = 0 ; i < p.length() ;i++ ){
            oriMap.put(p.charAt(i), oriMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        for(Character ss : oriMap.keySet() ){
            System.out.println(ss+" " + oriMap.get(ss));
        }
        int flag = oriMap.size();
        List<Integer> res = new ArrayList();
        for(int i = 0 , j = 0 , sum = 0; i < s.length() ; i++ ){
            if(oriMap.containsKey(s.charAt(i))){
                int t = oriMap.get(s.charAt(i));
                oriMap.put(s.charAt(i) , t - 1);
                if(oriMap.get(s.charAt(i)) == 0){
                    sum++;
                }
            }
            if(i - j + 1 > p.length() ){
                if(oriMap.containsKey(s.charAt(j))){
                    if(oriMap.get(s.charAt(j)) == 0 ){
                        sum--;
                    }
                    int t = oriMap.get(s.charAt(j));
                    oriMap.put( s.charAt(j) ,   t + 1);
                }
                j++;
            }
            if(sum == flag){
                res.add(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
