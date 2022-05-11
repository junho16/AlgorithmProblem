package lcCup;

/**
 * LCP 02. 分式化简
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 *
 * @author Junho
 * @date 2022/4/28 11:27
 */
public class Main02 {
    public int[] fraction(int[] cont) {

        int mu = 1;
        int zi = cont[cont.length - 1];
        for(int i = cont.length - 2 ; i >= 0 ; i--){
            int tmp = zi;
            zi = mu;
            mu = tmp;

            zi += cont[i] * mu;
        }
        return new int[]{zi , mu};

//        float res = 0;
//        for(int i = cont.length - 1; i >= 1 ; i--){
//            if(i == cont.length - 1){
//                res = 1 / cont[i];
//                System.out.println(cont[i]);
//                System.out.println(res);
//                // continue;
//            }else{
//                System.out.println(res);
//                res = 1 / (res + cont[i]);
//            }
//
//        }
//        int[] ans = new int[2];
//        ans[0] = (int)(cont[0] * (1 / res) + 1);
//        ans[1] = (int)res;
//        return ans;
    }
}
