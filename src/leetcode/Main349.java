package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * @author Junho
 * @date 2022/4/9 16:42
 */
public class Main349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums1.length ; i++){
            set.add(nums1[i]);
        }
        Set<Integer> list = new HashSet<>();
        for(int i = 0 ; i < nums2.length ; i++ ){
            if(set.contains(nums2[i]))
                list.add(nums2[i]);
        }
        Object[] listArr = list.toArray();
        int[] res = new int[list.size()];
        for(int i = 0; i < listArr.length ;i++){
            res[i] = (int) listArr[i];
        }
        return res;
    }
}
