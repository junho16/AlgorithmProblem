package leetcode;

import java.util.*;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class Main406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] o1, int[] o2) ->{
            if(o2[0] == o1[0]){
                return o2[1] - o1[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        /**
         * input
         * [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
         * stdout
         * [[4, 4], [5, 2], [5, 0], [6, 1], [7, 1], [7, 0]]
         */
        // System.out.println(Arrays.deepToString(people));
        int[][] res = new int[people.length][2];

        boolean[] flag = new boolean[people.length+1000];

        for(int i = 0; i < people.length ;i++){
            int num = people[i][1];
            int idx = 0;
            // System.out.println(people[i][0]+" "+people[i][1]);

            for(int j = 0 ,f = -1 ; j < people.length ; j++){
                if(!flag[j]) f++;
                if(f == num){
                    idx = j;
                    break;
                }

            }
            // System.out.println(idx + " ");
            // System.out.println(Arrays.deepToString(res));
            flag[idx] = true;
            res[idx][0] = people[i][0];
            res[idx][1] = people[i][1];
            // System.out.println(idx+1+" ");
            // System.out.println(Arrays.deepToString(res));
            // flag[idx+1] = true;
            // res[idx+1][0] = people[i][0];
            // res[idx+1][1] = people[i][1];
        }
        return res;









//        Map map = new TreeMap<Integer , Integer>();
//        for(int i = 0 ; i < people.length ; i++){
//            for(int j = 0 ; j < people[0].length ; j++){
//
//            }
//        }
//        //这里将map.entrySet()转换成list
//        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
//        //然后通过比较器来实现排序
//        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
//            //升序排序
//            public int compare(Map.Entry<Integer, Integer> o1,
//                               Map.Entry<Integer, Integer> o2) {
//                if(o1.getKey() > o2.getKey()){
//                    return 1;
//                }else if(o1.getKey() < o2.getKey()){
//                    return 0;
//                }else{
//                    return o2.getValue() - o1.getValue();
//                }
//            }
//        });
//        for(Map.Entry<Integer,Integer> m:list){
//            System.out.println(m.getKey()+":"+m.getValue());
//        }
//        return null;
    }
}
