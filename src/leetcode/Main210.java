package leetcode;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * @author Junho
 * @date 2022/3/22 14:26
 */
public class Main210 {
    /**
     3
     [[1,0],[1,2],[0,1]]
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0 ;i < numCourses; i++){
            map.add(new ArrayList());
        }
        Queue<Integer> queue = new LinkedList<>();
        //入度
        int[] into = new int[numCourses];
        for(int i = 0 ;i < prerequisites.length ; i++ ){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            map.get(b).add(a);
            into[a]++;
        }
        // for(List l : map){
        //     for(Object i : l){
        //         System.out.print((int)i+" ");
        //     }
        //     System.out.println();
        // }
        // for(int l : into){
        //     System.out.print((int)l+" ");
        // }
        List<Integer> reslist = new ArrayList<>();
        for(int i = 0 ; i < into.length ;i++ ){
            if(into[i] == 0){
                queue.add(i);
                reslist.add(i);
            }
        }

        while (!queue.isEmpty()){
            int x = queue.poll();
            for(Integer i : map.get(x) ){
                if(--into[i] == 0){
                    queue.add(i);
                    reslist.add(i);
                }
            }
        }
        //判断是否有环存在
        if(reslist.size() != numCourses){
            int[] res = new int[0];
            return res;
        }
        int[] res = new int[reslist.size()];
        for(int i = 0 ; i < reslist.size() ; i++ ){
            res[i] = reslist.get(i);
        }
        return res;
    }
}
