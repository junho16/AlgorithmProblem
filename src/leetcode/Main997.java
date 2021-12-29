package leetcode;

import java.util.ArrayList;

/**
 *  997. 找到小镇的法官
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 *
 * 如果小镇法官真的存在，那么：
 *
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 *
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 */
public class Main997 {
    public int findJudge(int n, int[][] trust) {
        int[] toArr = new int[n];
        int[] fromArr = new int[n];
        for(int i = 0; i < trust.length ; i++){
            int from = trust[i][0] - 1 ;
            int to = trust[i][1] - 1 ;
            fromArr[from]++;
            toArr[to]++;
        }
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0 ;i < toArr.length ;i++ ){
            if(toArr[i] == n-1 && fromArr[i] == 0){
                list.add(i);
            }
        }
        if(list.size() == 1){
            return list.get(0)+1;
        }else {
            return -1;
        }
    }
}
