package leetcode;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 *
 * @author Junho
 * @date 2022/4/13 16:05
 */
public class Main380 {

    int[] nums;
    Map<Integer ,Integer> map;
    int idx;

    public Main380() {
        idx = 0 ;
        map = new HashMap<>();
        nums = new int[200001];
    }
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            nums[idx] = val;
            map.put(val , idx++);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int x = map.get(val);
            map.remove(val);

            //将最后一个元素拿过来
            int last = nums[idx - 1];
            nums[x] = nums[--idx];
            if(x != idx)
                map.put(last , x);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        return nums[new Random().nextInt(idx)];
    }
}












//class RandomizedSet {
//    static int[] nums = new int[200010];
//    Random random = new Random();
//    Map<Integer, Integer> map = new HashMap<>();
//    int idx = -1;
//    public boolean insert(int val) {
//        if (map.containsKey(val)) return false;
//        nums[++idx] = val;
//        map.put(val, idx);
//        return true;
//    }
//    public boolean remove(int val) {
//        if (!map.containsKey(val)) return false;
//        int loc = map.remove(val);
//        if (loc != idx) map.put(nums[idx], loc);
//        nums[loc] = nums[idx--];
//        return true;
//    }
//    public int getRandom() {
//        return nums[random.nextInt(idx + 1)];
//    }
//}