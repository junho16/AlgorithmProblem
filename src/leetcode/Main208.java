package leetcode;

/**
 208. 实现 Trie (前缀树)
 Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

 请你实现 Trie 类：

 Trie() 初始化前缀树对象。
 void insert(String word) 向前缀树中插入字符串 word 。
 boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Main208 {

    static int[][] son;
    static int[] count;
    static int idx = 0 ;


    public Main208() {
        son = new int[134010][30];
        count = new int[134010];
    }

    public void insert(String w) {
        int p = 0;
        char[] word = w.toCharArray();
        for(int i = 0 ;i < word.length ;i++){
            int u = word[i] - 'a';
            if(son[p][u] == 0){
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        count[p]++;
    }
    public int get(String w){
        int p = 0;
        char[] word = w.toCharArray();
        for(int i = 0 ;i < word.length ;i++){
            int u = word[i] - 'a';
            if(son[p][u] == 0)  return 0;
            p = son[p][u];
        }
        return p;
    }
    public boolean startsWith(String w) {
        int p = 0;
        int u = 0;
        char[] word = w.toCharArray();
        for(int i = 0 ;i < word.length ;i++){
            u = word[i] - 'a';
            if(son[p][u] == 0)  return false;
            p = son[p][u];
        }
        // return son[p][u] == 0;
        return true;
    }

    public boolean search(String word) {
        return count[get(word)] > 0;
        // if(get(word) == 0)
        //     return false;
        // else{
        //     int u = word.charAt(word.length() - 1 ) -'a';
        //     for(int i = 0 ; i < 26 ;i++ ){
        //         if(son[get(word)][i] != 0)
        //             return false;
        //     }
        //     return true;
        //     // return  [u] == 0;
        // }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
