package cxymainshijingdian;

/**
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * @author Junho
 * @date 2022/5/27 10:12
 */
public class Main1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        for(int i = 0 , index_1 = -1 , index_2 = -1 ; i < words.length ; i++){
            if(words[i].equals(word1)){
                index_1 = i;
            }
            if(words[i].equals(word2)){
                index_2 = i;
            }
            if(index_1 != -1 && index_2 != -1){
                res = Math.min(res , Math.abs(index_1 - index_2));
            }
        }
        return res;
    }
}
