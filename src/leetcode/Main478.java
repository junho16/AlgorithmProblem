package leetcode;

import java.util.Random;

/**
 * 这居然还是一个算法 -- 拒接采样
 * --> 具体为在一个更大的可控范围内采样 如果其不在目标采样区内 则不断重试
 *
 * 478. 在圆内随机生成点
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 *
 * 实现 Solution 类:
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 *
 * @author Junho
 * @date 2022/6/6 16:20
 */
public class Main478 {

    Double x;
    Double y;
    Double r;
    public Main478(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.r = radius;
    }

    public double[] randPoint() {
        while (true){
            double a = new Random().nextDouble() * (2 * r) - r;
            double b = new Random().nextDouble() * (2 * r) - r;
            if(a * a + b * b <= r * r){
                return new double[]{x + a , y + b};
            }
        }
    }
}