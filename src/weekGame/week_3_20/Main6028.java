package weekGame.week_3_20;

import java.util.Stack;

/**
 * 6028. 统计道路上的碰撞次数
 * 在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置。
 *
 * 给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S' 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同 。
 *
 * 碰撞次数可以按下述方式计算：
 *
 * 当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。
 * 当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。
 * 碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。
 *
 * 返回在这条道路上发生的 碰撞总次数 。
 * @author Junho
 * @date 2022/3/20 13:49
 */
public class Main6028 {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for(int i = 0;i < directions.length() ;i++){
            if(stack.isEmpty() || directions.charAt(i) =='R'){
                stack.push(directions.charAt(i));
                continue;
            }else if(directions.charAt(i) =='S'){
                if(stack.peek() == 'L' || stack.peek() == 'S'){
                    stack.push(directions.charAt(i));
                }else if(stack.peek() == 'R'){
                    res += 1;
                    stack.pop();
                    while(!stack.isEmpty() && stack.peek() == 'R'){
                        stack.pop();
                        res++;
                    }
                    stack.push('S');
                }
            }else{
                if(stack.peek() == 'L'){
                    stack.push(directions.charAt(i));
                }else if(stack.peek() == 'R'){
                    res += 2;
                    stack.pop();
                    while(!stack.isEmpty() && stack.peek() == 'R'){
                        stack.pop();
                        res++;
                    }
                    stack.push('S');
                }else if(stack.peek() == 'S'){
                    res += 1;
                    stack.pop();
                    while(!stack.isEmpty() && stack.peek() == 'R'){
                        stack.pop();
                        res++;
                    }
                    stack.push('S');
                }
            }
        }
        return res;

    }
}
//"SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"