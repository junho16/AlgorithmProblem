package interview.huawei.L5_11;

import java.util.Scanner;

/**
 * @author Junho
 * @date 2022/5/11 22:59
 */
public class Main_02 {
    static int white = 0;
    static int black = 0;
    static boolean[][] flag;
    static boolean[][] qiflag;
    static int[] fx_x = {0,1,-1,0};
    static int[] fx_y = {1,0,0,-1};
    static int n;
    static char[][] map ;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        String nStr = "";
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9')
            nStr += s.charAt(idx++);

        n = Integer.parseInt(nStr);
        map = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            String tmp = s.substring(idx , idx + n);
            for(int j = 0 ; j < n ; j++ ){
                map[i][j] = tmp.charAt(j);
            }
            idx += n;
        }
        flag = new boolean[n][n];
        for(int i = 0; i < n ;i++){
            for(int j = 0 ; j < n; j++ ){
                qiflag = new boolean[n][n];
                if(map[i][j] == 'N')
                    continue;
                else {
                    if(!flag[i][j]){
                        flag[i][j] = true;
                        dfs(i , j , 1 , 0 , map[i][j] == 'B' ? 0 : 1 , true );
                    }

                }
            }
        }
        System.out.println(black +" " +white);
//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < n ; j++ ){
//                System.out.print(map[i][j] +" ");
//            }
//            System.out.println();
//        }
    }

    /**
     * 3WWWNBBBNN
     * 5NNWBWBBWBBWWWBBNWWWBWNNWB
     * color: 0：黑 ； 1：白
     * isFirst：判定是否是第一次添加数量
     * @param x
     * @param y
     * @param count
     * @param qi
     * @param color
     * @param isFirst
     */
    static void dfs(int x , int y , int count , int qi , int color , boolean isFirst) {
//        System.out.println(x + " " + y +" " +count+" " + qi + " " + color +" " + isFirst);
        int newQi = 0;
        //算气
        for (int k = 0; k < 4; k++) {
            int q_a = x + fx_x[k];
            int q_b = y + fx_y[k];
            if (q_a >= 0 && q_a < n && q_b >= 0 && q_b < n && !qiflag[q_a][q_b] && map[q_a][q_b] == 'N') {
                newQi++;
                qiflag[q_a][q_b] = true;
            }
        }
        qi += newQi;
        if (qi >= 2) {
            if (isFirst) {
                isFirst = false;
                if (color == 0) {
                    black += count;
                    System.out.println(x + " " + y +" " +count+" " + qi + " " + color +" " + isFirst);

                } else {
                    white += count;
                    System.out.println(x + " " + y +" " +count+" " + qi + " " + color +" " + isFirst);
                }
            } else {
                if (color == 0) {
                    black += 1;
                    System.out.println(x + " " + y +" " +count+" " + qi + " " + color +" " + isFirst);

                } else {
                    white += 1;
                    System.out.println(x + " " + y +" " +count+" " + qi + " " + color +" " + isFirst);

                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int a = x + fx_x[i];
            int b = y + fx_y[i];
            if (a >= 0 && a < n && b >= 0 && b < n && !flag[a][b]) {
                if((color == 0 && map[a][b] == 'B' )|| (color == 1 && map[a][b] == 'W')){
                    flag[a][b] = true;
                    dfs(a, b, count + 1, qi , color, isFirst);
                }
            }
        }
    }
}
