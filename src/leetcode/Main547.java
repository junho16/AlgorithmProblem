package leetcode;

/**
 * DFS、BFS、并查集都可以 找连通图的数量
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连
 * 返回矩阵中 省份 的数量。
 */
public class Main547 {
    public boolean[] visited;
    public int res = 0;
    public int[][] iscon;
    public int findCircleNum(int[][] isConnected) {
        iscon = isConnected;
        visited = new boolean[isConnected.length];
        for(int i = 0 ; i < isConnected.length ; i++){
            if(!visited[i]){
                res++;
                dfs(i);
            }
        }
        return res;
    }
    public void dfs(int idx){
        visited[idx] = true;
        for(int i = 0 ;i < visited.length ; i++){
            if(!visited[i] && iscon[idx][i] == 1){
                dfs(i);
            }
        }
    }
}
