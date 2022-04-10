package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * @author Junho
 * @date 2022/4/9 11:32
 */
public class Main290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character , String> map = new HashMap<>();
        Map<String , Character> dogToC = new HashMap<>();
        String[] strings = s.split(" ");
        if(pattern.length() != strings.length)
            return false;
        for(int i = 0 ; i < pattern.length() ;i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(dogToC.containsKey(strings[i]))
                    return false;
                dogToC.put(strings[i] , pattern.charAt(i));
                map.put(pattern.charAt(i) , strings[i]);
            }else{
                if(!strings[i].equals(map.get(pattern.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }
}
