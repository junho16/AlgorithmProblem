package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 *
 * @author Junho
 * @date 2022/6/15 23:02
 */
public class Main890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        String orgStr = getStr(pattern);
        for(int i = 0 ; i < words.length ; i++){
            if(orgStr.equals(getStr(words[i]))){
                list.add(words[i]);
            }
        }
        return list;
//        System.out.println(getStr(pattern));
//        System.out.println();
//        for(int i = 0 ; i < words.length ; i++){
//            System.out.println(getStr(words[i]));
//        }
//        return null;
    }
    public String getStr(String pattern){
        Map<Character , Character> orgMap = new HashMap<>();
        int orgIdx = 0 ;
        String res = "";
        for(int i = 0 ; i < pattern.length() ; i++){
            if(orgMap.containsKey(pattern.charAt(i))){
                res += orgMap.get(pattern.charAt(i));
            }else{
                orgMap.put(pattern.charAt(i) , (char) ('a' + orgIdx++));
                res += orgMap.get(pattern.charAt(i));
            }
        }
        return res;
    }
}
