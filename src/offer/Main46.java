package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * @author Junho
 * @date 2022/4/12 21:27
 */
public class Main46 {
    public static void main(String[] args) {
        Main46 main46 = new Main46();
        System.out.println(main46.translateNum(12258));
        System.out.println(main46.translateNum(25));

    }
    Set<String> set;
    String numStr;
    public int translateNum(int num) {
        set = new HashSet<>();
        numStr = num + "";
        dfs(0 , "");
        return set.size();
    }
    void dfs(int idx , String path){
        //    System.out.println(idx + " " + path);
        if(idx == numStr.length()){
            set.add(path);
            return;
        }
        for(int i = idx + 1; i <= numStr.length() ; i++){
            if(!((numStr.substring(idx , i)).equals("0")) && numStr.substring(idx , i).startsWith("0"))
                continue;
            int n = Integer.parseInt(numStr.substring(idx , i));
            // System.out.println(n);
            if(n > 25 )
                return;
            else
                dfs(i , path + (char)('a' + n));
        }
    }
}
