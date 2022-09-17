package leetcode;

import java.util.List;

/**
 * Trie经典算法 需要注意的是需要返回最短匹配的字符串（假设树中已存有当前字符结尾的字符串，则直接返回）
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 */
public class Main648 {
    int[][] son = new int[100005][26];
    int[] count = new int[100005];
    int idx = 0;
    public void insert(String s){
        int p = 0;
        for(int i = 0 ; i < s.length() ; i++){
            int u = s.charAt(i) - 'a';
            if(son[p][u] != 0){
                p = son[p][u];
            }else{
                son[p][u] = ++idx;
                p = son[p][u];
            }
        }
        count[p]++;
    }
    String query(String s){
        String res = "";
        int p = 0;
        for(int i = 0 ; i < s.length(); i++){
            int u = s.charAt(i) - 'a';
            if(son[p][u] == 0){
                break;
            }else{
                res += s.charAt(i);
                p = son[p][u];
                if(count[p] != 0){
                    return res;
                }
            }
        }
        return count[p] == 0 ? "" : res;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(int i = 0 ; i < dictionary.size() ; i++){
            insert(dictionary.get(i));
        }
        String[] strings = sentence.split(" ");
        String res = "";
        for(int i = 0 ; i < strings.length ; i++){
            String queryStr = query(strings[i]);
            res += (queryStr.equals("")? strings[i] + " " : queryStr + " ");
        }
        return res.substring(0 , res.length() - 1);

    }
//    public int index = 0;
//    public int[][] son = new int[100006][30];
//    public char[] code = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//    public int[] count = new int[100006];
//    public String replaceWords(List<String> dictionary, String sentence) {
//        for(String s : dictionary){
//            insert(s);
//        }
//        // for(int i = 0 ; i < index ;i++){
//        //     for(int j = 0 ;j < 26 ;j++){
//        //         System.out.print(son[i][j]);
//        //     }
//        //     System.out.println();
//        // }
//        String[] strs = sentence.split(" ");
//        String res = "";
//        // System.out.println("======"+ get("aaaa") +"======");
//        for(String s : strs){
//            res += ((get(s).equals("")?s:get(s) )+" ");
//        }
//        return res.substring(0,res.length()-1);
//    }
//
//    public void insert(String s) {
//        int p = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int x = s.charAt(i) - 'a';
//            if (son[p][x] == 0) {
//                son[p][x] = ++index;
//            }
//            p = son[p][x];
//        }
//        count[p]++;
//    }
//
//    public String get(String s) {
//        int p = 0;
//        String res = "";
//        for (int i = 0; i < s.length(); i++) {
//            int x = s.charAt(i) - 'a';
//            if(son[p][x] == 0) {
//                break;
//            }else{
//                //     System.out.println(x);
//                res += (code[x] );
//                p = son[p][x];
//                if(count[p] != 0){
//                    return res;
//                }
//            }
//        }
//        if(count[p] == 0){
//            return "";
//        }else{
//            return res;
//        }
//    }
}