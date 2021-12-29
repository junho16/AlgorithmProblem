package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 519. 随机翻转矩阵
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 *
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 *
 * 实现 Solution 类：
 *
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 */
public class Main519 {

    public Random random;
    public int numcount;
    public int row;
    public int col;
    public Map<Integer , Integer> map ;
    public Main519(int m, int n) {
        random = new Random();
        map = new HashMap<>();
        numcount = m * n;
        row = m;
        col = n;
    }

    public int[] flip() {
        int x = random.nextInt(numcount);
        System.out.println(x);
        int res = x;
        if(map.containsKey(x)){
            //如果存在x值说明什么呢？说明x位置已经无法使用了，而hash(x)存了一个可以使用的空间
            res = map.get(x);
        }
        //不存在x值说明x位置可以使用，请使用完后做一个可以使用的下一个位置在map里
        //而无论是否随机的x是使用x位置还是使用新的hashmap存放的位置，都需要创建一个新的位置给下一个随机位置使用
        if(map.containsKey(numcount - 1)){
            //如果最后一个位置无法使用
            map.put(x , map.get(numcount - 1));
            //========这一点需要特别注意，确实要减去这个numcount - 1位置，因为这个numcount - 1在map中存放的空余位置已经被使用了
            //如果不删除掉此位置，那么下一个随机到numcount - 1位置的数就没有空余位置可以使用了
            map.remove(numcount - 1);
        }else{
            //假设最后一个位置可以使用
            map.put(x , numcount - 1);
        }
        numcount --;

        int[] resArr = new int[2];
        resArr[0] = res / row;
        resArr[1] = res % col;
        return resArr;
    }

    public void reset() {
        numcount = row * col;
        map.clear();
    }
}
