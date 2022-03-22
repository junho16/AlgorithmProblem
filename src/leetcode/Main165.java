package leetcode;

import java.util.*;

/**
 * 165. 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 *
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * @author Junho
 * @date 2022/3/21 22:36
 */
public class Main165 {
    public static void main(String[] args) {
        String s1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        String s2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        compareVersion(s1 , s2);
    }
    public static int compareVersion(String version1, String version2) {
        Queue<Integer> versions_1 = new LinkedList<>();
        Queue<Integer> versions_2 = new LinkedList<>();
        for(int i =  0; i < version1.length() ; i++){
            if(version1.charAt(i) >= '0' && version1.charAt(i) <= '9'){
                int k = i + 1;
                while (k < version1.length() && version1.charAt(k) >= '0' && version1.charAt(k) <= '9'){
                    k++;
                }
                String tmp = version1.substring(i , k);
                versions_1.add(Integer.parseInt(tmp));
                i = k;
            }else{
                i++;
            }
        }
        for(int i =  0; i < version2.length() ; ){
            if(version2.charAt(i) >= '0' && version2.charAt(i) <= '9'){
                int k = i + 1;
                while (k < version2.length() && version2.charAt(k) >= '0' && version2.charAt(k) <= '9'){
                    k++;
                }
                String tmp = version2.substring(i , k);
                versions_2.add(Integer.parseInt(tmp));
                i = k;
            }else{
                i++;
            }
        }
        // while(!versions_1.isEmpty()){
        //     System.out.print(versions_1.poll()+" ");
        // }
        // System.out.println("");
        // while(!versions_2.isEmpty()){
        //     System.out.print(versions_2.poll()+" ");
        // }
        while (!versions_1.isEmpty() && !versions_2.isEmpty()){
            if(versions_1.peek() > versions_2.peek()){

                return 1;
            }

            if(versions_1.peek() < versions_2.peek()){
                return -1;
            }
            versions_1.poll();
            versions_2.poll();
        }
        while(!versions_1.isEmpty() ){
            if(versions_1.poll() != 0)
                return 1;
        }
        while(!versions_2.isEmpty() ){
            if(versions_2.poll() != 0)
                return -1;
        }
        return 0;
    }
}
