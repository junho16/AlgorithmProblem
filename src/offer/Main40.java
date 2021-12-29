package offer;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Main40 {
    public int[] arr;
    public int k;
    public int[] getLeastNumbers(int[] a, int kk) {
        arr = a;
        k = kk;
        quickSort(0, arr.length - 1 );
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = arr[i];
        }
        return res;
    }
    void quickSort(int l , int r){
        //============这里需要注意 需要使用 l >= r ==========
        if(l >= r)
            return;
        //============这里需要注意 需要使用l-1和r+1来配合下面的do while==========
        int left = l - 1;
        int rigth = r + 1;
//        int left = l ;
//        int rigth = r ;
        int midNum = arr[(left + rigth) >> 1];
//        int midNum = arr[ l + 1 ];

        while (left < rigth){
            //============这里需要注意 需要使用 do while ==========
            do{
                left++;
            }while (arr[left] < midNum);

            do{
                rigth--;
            }while (arr[rigth] > midNum);
            //============这里需要注意 需要使用 判断 left<right ==========
            //此处可以想一下 如果不判断的话 则你left > right 时交换
            //则会出现交换过后的元素又换回来了，等于吗没换
            if(left < rigth){
                int t = arr[rigth];
                arr[rigth] = arr[left];
                arr[left] = t;
            }

        }

        //============这里需要注意 需要使用right==========
        quickSort(l , rigth  );
        quickSort(rigth + 1 , r);
    }
}
