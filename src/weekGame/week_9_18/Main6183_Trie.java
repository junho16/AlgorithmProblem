package weekGame.week_9_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 没过的
 * @author Junho
 * @date 2022/9/18 11:31
 */
public class Main6183_Trie {
    public int son[][];
    public int cnt[];
    public int idx = 0;

    public int[] sumPrefixScores(String[] words) {
        son = new int [1000001][26];
        cnt = new int[1000001];
        Map<Integer , List<String>> preMap = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            String s = "";
            for(int j = 0 ; j < words[i].length() ; j++){
                s += words[i].charAt(j);
                insert(s);

                List<String> list = preMap.getOrDefault(i , new ArrayList<>());
                list.add(s);
                preMap.put(i , list);
            }
        }
        int[] res = new int[words.length];
        for(int i = 0 ; i < words.length ; i++){
            int sum = 0;
            List<String> preList = preMap.get(i);
            for(int j = 0 ; j < preList.size() ; j++){
                sum += query(preList.get(j));
            }
            res[i] = sum;
        }
        return res;

    }


    void insert(String str)
    {
        int p = 0;
        for (int i = 0; i < str.length() ; i ++ )
        {
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0)
                son[p][u] = ++ idx;
            p = son[p][u];
        }
        cnt[p] ++ ;
    }

    int query(String str)
    {
        int p = 0;
        for (int i = 0; i < str.length() ; i ++ )
        {
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }



}
