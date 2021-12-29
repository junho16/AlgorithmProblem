package leetcode;

/**
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 */
public class Main677 {
    public Main677() {
        N = 10000;
        son = new int[N][26];
        V = new int[N];
        S = new int[N];
        idx = 0;
    }
    static int N  ;
    static int[][] son  ;
    static int[] V ;
    static int[] S ;
    static int idx ;
    public void add(String s , int value , int last){
        int p = 0;
//        for(int i = 0; i < s.length() ; i++){
        for (char c:s.toCharArray()){
            int u = (c) - 'a';
            if(son[p][u] == 0){
                son[p][u] = ++idx;
            }
            p = son[p][u];
            S[p] = S[p] - last + value;
        }
//        Query[p] = V[p];
        V[p] = value;
    }
    public int query(String s){
        int p = 0;
//        for(int i = 0; i < s.length() ; i++){
        for (char c:s.toCharArray()){
            int u = (c) - 'a';
            if(son[p][u] == 0)  return 0;
            p = son[p][u];
        }
        return p;
    }
    public void insert(String key, int val) {
        add(key , val , V[query(key)]);
    }

    public int sum(String prefix) {
        return S[query(prefix)];
    }
}
