package leetcode;

import javax.management.QueryEval;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 经典拓扑排序==》一个图如果存在拓扑排序，则此图一定不存在环，则一定可以遍历完全
 * 1.统计一下入度
 * 2.将入度为0的点入队
 * 3.维护队列（入度为0的节点的队列）
 * 将队列的头节点取出，更新此节点可以去向哪些节点，更新是说将去向的节点的入度-- 如果发现入度减至0了，则将其加入队列
 */
public class Main207 {
     public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        int[] d = new int[n];//入度
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            g.add(new ArrayList<>());
        }

        for(int[] p: prerequisites){
            int b = p[0], a = p[1];
            g.get(a).add(b);//添加一条a连向b的边
            d[b]++;
        }

        for(int i = 0; i < n; i++){
            if(d[i] == 0) q.offer(i);
        }
        //从入度为0的点出发
        int cnt = 0;//统计遍历的点数
        while(q.size() != 0){
            int t = q.poll();
            cnt++;
            for(int m: g.get(t)){
                if(--d[m] == 0){
                    q.offer(m);
                }
            }
        }
        return cnt == n;
    }

//        int[][] courses = new int[numCourses][numCourses];
//        int[] sum = new int[numCourses];
//        int[] courseIdx = new int[numCourses];
//        for(int i = 0 ; i < prerequisites.length ;i++ ){
//             int from = prerequisites[i][0];
//             int to = prerequisites[i][1];
//             sum[to]++;
////             courses[from][courses[from].length] = to;
//
//            courses[from][courseIdx[from]++] = to;
//        }
//
//        // 记录并维护入度为0的点
//        Queue<Integer> queue = new LinkedList();
//        for(int i = 0 ; i < sum.length ; i++){
//            if(sum[i] == 0)
//                queue.offer(i);
//        }
//        int cnt = 0;
//        while(!queue.isEmpty()){
//            int top = queue.poll();
//            cnt++;
//            for(int i = 0 ; i < courses[top].length ;i++ ){
//                if(--sum[courses[top][i]] == 0){
//                    queue.offer(courses[top][i]);
//                }
//            }
//        }
//        return cnt == numCourses;
//
//
//    }
}
