package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 * @author Junho
 * @date 2022/4/1 22:23
 */
public class Main954 {
    public static void main(String[] args) {
//        System.out.println(canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));
        System.out.println(canReorderDoubled(new int[]{2, 4, 0, 0, 8, 1}));
    }

    public static boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr, 0, arr.length);
        Map<Float, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put((float) arr[i], map.getOrDefault((float) arr[i], 0) + 1);
        }
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey((float) arr[i]) && map.containsKey((float) arr[i] * 2)) {
                int val_2 = map.get((float) arr[i] * 2);
                if (val_2 - 1 == 0) {
                    map.remove((float) arr[i] * 2);
                    count -= 1;
                } else {
                    map.put((float) arr[i] * 2, map.get((float) arr[i] * 2) - 1);
                    count -= 1;
                }

                if (map.containsKey((float) arr[i])) {
                    int val_1 = map.get((float) arr[i]);
                    if (val_1 - 1 == 0) {
                        map.remove((float) arr[i]);
                        count -= 1;
                    } else {
                        map.put((float) arr[i], map.get((float) arr[i]) - 1);
                        count -= 1;
                    }
                }
            } else if (map.containsKey((float) arr[i]) && map.containsKey((float) arr[i] / 2)) {
                int val_2 = map.get((float) arr[i] / 2);
                if (val_2 - 1 == 0) {
                    map.remove((float) arr[i] / 2);
                    count -= 1;
                } else {
                    map.put(((float) arr[i] / 2), map.get((float) arr[i] / 2) - 1);
                    count -= 1;
                }
                if (map.containsKey((float) arr[i])) {
                    int val_1 = map.get((float) arr[i]);
                    if (val_1 - 1 == 0) {
                        map.remove((float) arr[i]);
                        count -= 1;
                    } else {
                        map.put((float) arr[i], map.get((float) arr[i]) - 1);
                        count -= 1;
                    }
                }
            }
        }
        return count == 0;
    }
}