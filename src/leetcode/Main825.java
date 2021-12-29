package leetcode;

/**
 * 825. 适龄的朋友
 * 一个模拟题 虽然没有什么意义 但是需要打个卡
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 */
public class Main825 {
    public int numFriendRequests(int[] ages) {
        int[] f = new int[121];
        for(int i = 0; i < ages.length ; i++){
            f[ages[i]]++;
        }
        int res = ages.length * ages.length;
        for(int i = 0 ; i < 121 ; i++){
            for(int j = 0; j < 121 ; j++){
                if((i <= 0.5 * j + 7 || i > j)  ){
                    res -= f[i] * f[j];
                }else if (i == j){
                    res -= f[i];
                }
            }
        }
        return res;
    }
}
