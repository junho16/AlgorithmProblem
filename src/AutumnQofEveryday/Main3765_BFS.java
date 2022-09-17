package AutumnQofEveryday;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 3675. 逃离迷宫
 * 给定一个 m×n (m 行, n 列)的迷宫，迷宫中有两个位置，gloria 想从迷宫的一个位置走到另外一个位置，当然迷宫中有些地方是空地，gloria 可以穿越，有些地方是障碍，她必须绕行，从迷宫的一个位置，只能走到与它相邻的 4 个位置中，当然在行走过程中，gloria 不能走到迷宫外面去。
 * 令人头痛的是，gloria 是个没什么方向感的人，因此，她在行走过程中，不能转太多弯了，否则她会晕倒的。
 * 我们假定给定的两个位置都是空地，初始时，gloria 所面向的方向未定，她可以选择 4 个方向的任何一个出发，而不算成一次转弯。
 * gloria 能从一个位置走到另外一个位置吗？
 *
 * 0-1 BFS问题(0-1最短路问题 用双端队列做（其实就是迪杰斯特拉）)
 * DFS 题解：https://www.acwing.com/solution/content/134087/
 * @author Junho
 * @date 2022/9/13 20:30
 */
class Node {
    int x , y ,z ;
    public Node(int x , int y  ,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main3765_BFS {

    //    static int N = 110 , M = N * N * 4;
    static String[] map;
    static int[][][] dist;
    static boolean[][][] flag;
    static int n , m ;
    static int k , sx ,sy, ex, ey;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt  = sc.nextInt();
        while (cnt-- > 0){

            m = sc.nextInt();
            n = sc.nextInt();
            map = new String[m];
            dist = new int[m][n][4];
            flag = new boolean[m][n][4];
            for(int i = 0 ;i < m ;i++){
                map[i] = sc.next();
            }
            k = sc.nextInt();
            sy = sc.nextInt();
            sx = sc.nextInt();
            ey = sc.nextInt();
            ex = sc.nextInt();
            sx--;sy--;ex--;ey--;
            if(bfs()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
    static boolean bfs(){
        int[] fx_x = {-1 , 0 , 1, 0};
        int[] fx_y = {0 , 1 , 0 ,-1};
        Deque<Node> deque = new LinkedList();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n  ;j++){
                for(int u = 0 ; u < 4 ; u++){
                    dist[i][j][u] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0 ; i < 4 ; i++ ){
            deque.addFirst(new Node(sx , sy , i));
            dist[sx][sy][i] = 0;
        }


        while(!deque.isEmpty()){
            Node node = deque.poll();
            //判断是否已经经过了此点
            if(flag[node.x][node.y][node.z])
                continue;
            flag[node.x][node.y][node.z] = true;
            int distance = dist[node.x][node.y][node.z];
            if(distance > k)
                continue;
            if(node.x == ex && node.y == ey)
                return true;
            for(int i = 0; i < 4 ;i++){
                int a = node.x + fx_x[i];
                int b = node.y + fx_y[i];
                int w = 0;
                if(i != node.z) w = 1;
                if(a >= 0 && a < m  && b >= 0 && b < n && map[a].charAt(b) == '.'){
                    if(dist[a][b][i] > distance + w){
                        dist[a][b][i] = distance + w;
                        if(w == 0){
                            //方向没变 加入到队头
                            deque.addFirst(new Node(a , b, i));
                        }else{
                            //方向变了 加入到队尾
                            deque.addLast(new Node(a ,b , i));
                        }
                    }
                }
            }
        }
        return false;
    }
}
