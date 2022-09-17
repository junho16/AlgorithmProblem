package AutumnQofEveryday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * @author Junho
 * @date 2022/9/16 21:36
 */
public class Main670 {
    public int maximumSwap(int num) {
        String str = num + "";
        char[] strs = str.toCharArray();
        List<String> list = new ArrayList<>();
        int maxV = Integer.MIN_VALUE;
        for(int i = 0 ; i < strs.length ; i++){
            for(int j = i ; j < strs.length ; j++){
                char ch = strs[i];
                strs[i] = strs[j];
                strs[j] = ch;
//                list.add(new String(strs));
                int v = Integer.parseInt(new String(strs));
                maxV = Math.max(maxV  ,v);

                ch = strs[i];
                strs[i] = strs[j];
                strs[j] = ch;
            }
        }
        return maxV;
//        Collections.sort(list);
//        return Integer.parseInt(list.get(list.size() - 1));
    }
}
