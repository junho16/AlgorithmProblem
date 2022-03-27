package weekGame.week_3_27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Junho
 * @date 2022/3/27 10:32
 */
public class Main5268 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set set_1 = new HashSet();
        Set set_2 = new HashSet();
        for(int i = 0 ; i < nums1.length ; i++){
            set_1.add(nums1[i]);
        }
        for(int i = 0 ;  i < nums2.length ; i++){
            set_2.add(nums2[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res_1 = new ArrayList<>();
        List<Integer> res_2 = new ArrayList<>();
        for(int i = 0 ; i < nums1.length ; i++){
            if(!set_2.contains(nums1[i]) && !res_1.contains(nums1[i])){
                res_1.add(nums1[i]);
            }
        }
        for(int i = 0 ; i < nums2.length ; i++){
            if(!set_1.contains(nums2[i]) && !res_2.contains(nums2[i])){
                res_2.add(nums2[i]);
            }
        }
        res.add(res_1);
        res.add(res_2);
        return res;
    }
}
