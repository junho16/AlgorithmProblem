package base;

/**
 * @author Junho
 * @date 2022/5/11 9:38
 */

import java.util.HashSet;
import java.util.Set;

/**
 * (1)朴素并查集：
 *
 *     int p[N]; //存储每个点的祖宗节点
 *
 *     // 返回x的祖宗节点
 *     int find(int x)
 *     {
 *         if (p[x] != x) p[x] = find(p[x]);
 *         return p[x];
 *     }
 *
 *     // 初始化，假定节点编号是1~n
 *     for (int i = 1; i <= n; i ++ ) p[i] = i;
 *
 *     // 合并a和b所在的两个集合：
 *     p[find(a)] = find(b);
 *
 *
 * (2)维护size的并查集：
 *
 *     int p[N], size[N];
 *     //p[]存储每个点的祖宗节点, size[]只有祖宗节点的有意义，表示祖宗节点所在集合中的点的数量
 *
 *     // 返回x的祖宗节点
 *     int find(int x)
 *     {
 *         if (p[x] != x) p[x] = find(p[x]);
 *         return p[x];
 *     }
 *
 *     // 初始化，假定节点编号是1~n
 *     for (int i = 1; i <= n; i ++ )
 *     {
 *         p[i] = i;
 *         size[i] = 1;
 *     }
 *
 *     // 合并a和b所在的两个集合：
 *     size[find(b)] += size[find(a)];
 *     p[find(a)] = find(b);
 *
 *
 * (3)维护到祖宗节点距离的并查集：
 *
 *     int p[N], d[N];
 *     //p[]存储每个点的祖宗节点, d[x]存储x到p[x]的距离
 *
 *     // 返回x的祖宗节点
 *     int find(int x)
 *     {
 *         if (p[x] != x)
 *         {
 *             int u = find(p[x]);
 *             d[x] += d[p[x]];
 *             p[x] = u;
 *         }
 *         return p[x];
 *     }
 *
 *     // 初始化，假定节点编号是1~n
 *     for (int i = 1; i <= n; i ++ )
 *     {
 *         p[i] = i;
 *         d[i] = 0;
 *     }
 *
 *     // 合并a和b所在的两个集合：
 *     p[find(a)] = find(b);
 *     d[find(a)] = distance; // 根据具体问题，初始化find(a)的偏移量
 *
 * 作者：yxc
 * 链接：https://www.acwing.com/blog/content/404/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Main_UnionFind {
    /**
     * 以lc某题为例
     * 547. 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     *
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     *
     * 返回矩阵中 省份 的数量。
     */
    int find(int x){
        if(p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }
    int[] p;
    public int findCircleNum(int[][] isConnected) {
        p = new int[isConnected.length];
        for(int i = 0 ; i < p.length ; i++){
            p[i] = i;
        }
        Set isGo = new HashSet();
        for(int i = 0 ;i < isConnected.length ; i++){
            for(int j = 0 ; j < isConnected[0].length ; j++){
                if(isConnected[i][j] == 1 && !isGo.contains(i + " " + j) && !isGo.contains(j + " " + i)){
                    p[find(i)] = find(j);
                    isGo.add(i + " " + j);
                    isGo.add(j + " " + i);
                }

            }
        }
        int res = 0;
        for(int i = 0 ; i < p.length ; i++){
            res += p[i] == i ? 1 : 0 ;
        }
        return res;

    }
}
