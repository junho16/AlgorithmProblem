package offer;

/**
 * 数组遍历两遍 从前到后 从后到前 分别是
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Main66 {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int[] pre = new int[a.length];
        int[] post = new int[a.length];
        if(a.length == 0)
            return res;
        pre[0] = 1; post[a.length-1] = 1;
        for(int i = 1 ; i < a.length ; i++){
            pre[i] = pre[i-1] * a[i-1];
        }
        for(int i = a.length-2 ; i >=0 ;i-- ){
            post[i] = post[i+1] * a[i+1];
        }
        // for(int i = 0 ;   i < a.length ; i++){
        //     System.out.print(pre[i]+" ");
        // }
        // System.out.println();
        // for(int i = 0 ;  i < a.length ; i++){
        //     System.out.print(post[i]+" ");
        // }
        // System.out.println();
        for(int i = 0; i < res.length ; i++){
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}
