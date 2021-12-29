package offer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class Main49 {
    public int nthUglyNumber(int n) {
        int[] f = new int[n];
//        Arrays.fill(f , 1);
        f[0] = 1;
        int pre2 = 0;
        int pre3 = 0;
        int pre5 = 0;
        for(int i = 1 ; i < n; i++){
            int k = Math.min(f[pre2]*2 , Math.min(f[pre3] * 3 , f[pre5] * 5) );
            f[i] = k;
            if(k == f[pre2]*2)
                pre2++;
            if(k == f[pre3]*3)
                pre3++;
            if(k == f[pre5]*5)
                pre5++;
        }
        return f[n-1];
    }
}
