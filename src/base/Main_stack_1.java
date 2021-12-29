package base;

import java.util.Scanner;
import java.util.Stack;

public class Main_stack_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        Stack<Integer> stack = new Stack();
        for(int i = 0 ; i < n ;i++){
            nums[i] = scanner.nextInt();
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!stack.empty() && nums[stack.peek()] >= nums[i]){
                while (!stack.empty() && nums[stack.peek()] >= nums[i]){
                    stack.pop();
                }
            }
//            stack.add(i);
            if(stack.empty()){
                System.out.print("-1 ");
            }else{
                System.out.print(nums[stack.peek()] + " ");
            }
            stack.add(i);
        }
    }
}
