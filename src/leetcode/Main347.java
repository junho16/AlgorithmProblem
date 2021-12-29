package leetcode;

import sun.applet.Main;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Main347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> map = new TreeMap<>();
        //自定义比较器
        Comparator<Map.Entry<Integer, Integer>> valCmp = new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(map.get(nums[i]) , map.get(nums[i]+1));
            }else{
                map.put(nums[i] , 1);
            }
        }
        //将map转成List，map的一组key，value对应list一个存储空间
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet()); //传入maps实体
        Collections.sort(list,valCmp); // 注意此处Collections 是java.util包下面的,传入List和自定义的valCmp比较器
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++) {
            res[i] = list.get(i).getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        Main347 main347 = new Main347();
        int[] nums = {1,2,3};
        main347.topKFrequent(nums , 1);
    }
}
