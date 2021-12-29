package offer;

import java.util.*;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Main45 {
    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ;i++ ){
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String o1Str = o1+"";
                String o2Str = o2+"";
                return (o1Str + o2Str).compareTo(o2Str + o1Str);
            }
        });
        String res = "";
        for(int i = 0; i < list.size() ;i++){
            System.out.println(list.get(i));
            res += list.get(i);
        }
        return res;
    }
}
