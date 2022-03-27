package leetcode;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * @author Junho
 * @date 2022/3/26 21:30
 */
public class Main720 {
    public int[][] son;
    public int[] isExist;
    public int idx;
    /**
     * 模板题 trie
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        idx = 0;
        son = new int[150005][30];
        isExist = new int[150005];
        for(int i= 0 ; i < words.length ; i++)
            add(words[i]);
        String res = "";
        for(int i = 0 ; i < words.length ; i++){
            if(words[i].length() < res.length() )
                continue;
            if(words[i].length() == res.length() && res.compareTo(words[i]) < 1 ) {
                continue;
            }
            if(query(words[i])){
                res = words[i];
            }
        }
        return res;
    }
    public void add(String word){
        int p = 0;
        for(int i = 0 ; i < word.length() ; i++ ){
            int k = word.charAt(i) - 'a';
            if(son[p][k] == 0)
                son[p][k] = ++idx;
            p = son[p][k];
        }
        isExist[p]++;
    }
    public boolean query(String word){
        int p = 0;
        for(int i = 0 ; i < word.length() ;i++){
            int k = word.charAt(i) - 'a';
            p = son[p][k];
            if(isExist[p] == 0)
                return false;
        }
        return true;
    }
}
