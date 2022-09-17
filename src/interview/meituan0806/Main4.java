package interview.meituan0806;

import java.util.*;

/**
 * @author Junho
 * @date 2022/8/6 10:29
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int typenum = sc.nextInt();
        Map<Integer , List> map = new HashMap<>();
        for(int i = 1 ; i <= n ; i++ ){
            int k = sc.nextInt();
            List list = map.getOrDefault(k , new ArrayList());
            list.add(i);
            map.put(k , list);
        }
        for(Map.Entry<Integer , List> entry : map.entrySet()){


        }
    }
}
