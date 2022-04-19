package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * @author Junho
 * @date 2022/4/19 11:03
 */
public class Main819 {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {

        TreeMap<String , Integer> treeMap = new TreeMap();
        Comparator comparator = new Comparator<Map.Entry<String , Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        for(int i = 0 ; i < paragraph.length() ; ){
            if((paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z')
                    || (paragraph.charAt(i) >= 'A' && paragraph.charAt(i) <= 'Z')){
                int k = i;
                while (k < paragraph.length() && ((paragraph.charAt(k) >= 'a' && paragraph.charAt(k) <= 'z')
                        || (paragraph.charAt(k) >= 'A' && paragraph.charAt(k) <= 'Z')))
                    k++;
                String tmp = paragraph.substring(i , k).toLowerCase();
                treeMap.put(tmp , treeMap.getOrDefault(tmp , 0) + 1);
                i = k;
            }else{
                i++;
            }
        }
        List<Map.Entry<String , Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list , comparator);

        List<String> ban = new ArrayList();
        for(int i = 0; i < banned.length ; i++){
            ban.add(banned[i].toLowerCase());
        }
        for(Map.Entry<String ,Integer> i : list){
            if( !ban.contains(i.getKey()) ){
                return i.getKey();
            }
//            System.out.println(i.getKey() +" " + i.getValue());
        }
        return "";
    }
}