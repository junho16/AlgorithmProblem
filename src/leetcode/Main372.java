package leetcode;

import java.util.Arrays;

/**
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 */
public class Main372 {

    public int mod = 1337;

    int quickMi(int a , int b){
        a %= mod;
        int res = 1;
        while(b != 0){
            if((b & 1) != 0){
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
    public int superPow(int a, int[] b) {
        if(b.length == 0){
            return 1;
        }
        int k = b[b.length-1];
        b = Arrays.copyOf(b , b.length-1);
        return quickMi( superPow(a, b) ,10) * quickMi(a , k)  % mod;
    }

//    public int superPow(int a, int[] b) {
//        return dfs(a , b , b.length-1);
//    }
//    public int dfs(int a , int[] b , int idx){
//        if(idx == 0){
//            return quickMi(a , b[0]);
//        }
//        return quickMi(dfs(a, b ,idx-1) , 10) * quickMi(a , idx)  % mod;
//    }

}
