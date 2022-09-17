package AutumnQofEveryday;

/**
 * 1344. 时钟指针的夹角
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * @author Junho
 * @date 2022/9/14 20:31
 */
public class Main1344 {
    public static void main(String[] args) {
        System.out.println(angleClock(12 , 30));
    }
    public static double angleClock(int hour, int minutes) {
        // 分钟度数
        double minD =  360 / 60 * minutes;
        //小时度数
        double hourD = ((hour % 12) + (minutes / 60.0)) * 360 / 12;
        return Math.min(Math.abs(minD - hourD) , 360 - (Math.abs(minD - hourD)));
    }
}
