package AutumnQofEveryday;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 1656. 设计有序流
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 *
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * @author Junho
 * @date 2022/9/12 16:21
 */
public class Main1656 {
    TreeMap<Integer , String> treeMap;

    int idx;

    public Main1656(int n) {
        treeMap = new TreeMap<Integer , String>();
        idx = 1;
    }

    public List<String> insert(int idKey, String value){
        treeMap.put(idKey , value);
        List<String> res = new ArrayList<>();
        if(! treeMap.containsKey(idKey)){
            return res;
        }else{
            while (treeMap.containsKey(idx)){
                res.add(treeMap.get(idx));
                idx++;
            }
            return res;
        }
    }
}
