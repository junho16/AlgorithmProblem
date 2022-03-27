package weekGame.week_3_27;

/**
 * @author Junho
 * @date 2022/3/27 10:41
 */
public class Main5236 {
    public static int minDeletion(int[] nums) {
        int res = 0 ;
        int idx = 0;
        int[] tmp = new int[nums.length];
        for(int i = 0 ;i < nums.length ;i++){
            if((idx) % 2 == 1 && idx >= 1 && nums[i] == tmp[idx - 1]){
                res++;
            }else{
                tmp[idx++] = nums[i];
            }
        }
        if(idx % 2 == 1)
            return res+1;
        else
            return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,5};
        System.out.println(minDeletion(arr));
    }
}
