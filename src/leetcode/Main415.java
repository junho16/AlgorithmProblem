package leetcode;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class Main415 {
    public String addStrings(String num1, String num2) {
        int[] nums = new int[100000];
        int idx = 0;
        int i = num1.length()-1 , j = num2.length()-1;
        for( ; (i >=0 ) &&  (j >=0 ); i-- ,j--){
            int x =  Integer.parseInt(""+num1.charAt(i));
            int y =  Integer.parseInt(""+num2.charAt(j));
            int a= (nums[idx] + x + y) % 10;
            int b = nums[idx+1] + ((nums[idx] + x + y)/10);
            // System.out.println(a+" "+b);
            nums[idx] = a;
            nums[idx+1] = b;

            // if( nums[idx+1] > 10){
            //     nums[idx+2] ++;
            //     nums[idx+1] %= 10;
            // }
            idx++;
        }
        // for(int s = 10 ;s >= 0 ; s-- ){
        //     System.out.print(nums[s]);
        // }
        while (i >= 0 ){
            int a = (nums[idx] + Integer.parseInt(num1.charAt(i)+"")) % 10;
            int b = nums[idx+1] + ((nums[idx] + Integer.parseInt(num1.charAt(i)+""))/10);
            // nums[idx] += Integer.parseInt(num1.charAt(i)+"");
            nums[idx] = a;
            nums[idx+1] =b;
            idx++;
            i--;
        }

        while (j >= 0 ){
            // nums[idx] += Integer.parseInt(num2.charAt(j)+"");
            int a = (nums[idx] + Integer.parseInt(num2.charAt(j)+"")) % 10;
            int b = nums[idx+1] + ((nums[idx] + Integer.parseInt(num2.charAt(j)+""))/10);
            // nums[idx] += Integer.parseInt(num1.charAt(i)+"");
            nums[idx] = a;
            nums[idx+1] =b;
            idx++;
            j--;
        }

        String res = "";
        int k = (nums[idx] == 0)?idx-1:idx;
        for( ; k >= 0 ; k-- ){
            res += nums[k];
        }
        return res;
    }
    /**
     * 剩下的一种方法，思想差不多，唉 反正也不用什么思想
     * //           StringBuilder res = new StringBuilder("");
     * //         int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
     * //         while(i >= 0 || j >= 0){
     * //             int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
     * //             int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
     * //             int tmp = n1 + n2 + carry;
     * //             carry = tmp / 10;
     * //             res.append(tmp % 10);
     * //             i--; j--;
     * //         }
     * //         if(carry == 1) res.append(1);
     * //         return res.reverse().toString();
     */
}
