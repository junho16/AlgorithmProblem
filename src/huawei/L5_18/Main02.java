package huawei.L5_18;

import java.util.Scanner;

/**
 * @author Junho
 * @date 2022/5/18 19:28
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] map = new char[m][n];
        for(int i = 0 ;i < m ; i++){
            String s = sc.next();
            for(int j = 0 ; j < s.length() ; j++){
                map[i][j] = s.charAt(j);
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i< 4 ;i++ ){
            if(map[x][y] =='.'){
                System.out.println(x +" "+ y);
                return;
            }
            if(map[x][y] == '^'){
                if(x - 1 < 0 || map[x-1][y] == '#'){
                    System.out.println(x +" "+ y);
                    return;
                }else{
                    if(map[x-1][y] == 'v'){
                        if((k-i)% 2 == 0){
                            System.out.println(x +" " + y);
                            return;
                        }else{
                            System.out.println(x-1 +" " + y);
                            return;
                        }
                    }
                    x = x-1;
                    continue;
                }
            }
            if(map[x][y] == 'v'){
                if(x + 1 >= m || map[x+1][y] == '#'){
                    System.out.println(x +" "+ y);
                    return;
                }else{
                    if(map[x+1][y] == '^'){
                        if((k-i)% 2 == 0){
                            System.out.println(x +" " + y);
                            return;
                        }else{
                            System.out.println(x+1 +" " + y);
                            return;
                        }
                    }
                    x = x+1;
                    continue;
                }
            }
            if(map[x][y] == '<'){

                if(y - 1 < 0 || map[x][y-1] == '#'){
                    System.out.println(x +" "+ y);
                    return;
                }
                if(map[x][y-1] == '>'){
                    if((k-i)% 2 == 0){
                        System.out.println(x +" " + y);
                        return;
                    }else{
                        System.out.println(x +" " +( y-1));
                        return;
                    }
                }
                y = y-1;
                continue;
            }
            if(map[x][y] == '>'){
                if(y + 1 >= n || map[x][y+1] == '#'){
                    System.out.println(x +" "+ y);
                    return;
                }
                if(map[x][y+1] == '<'){
                    if((k-i)% 2 == 0){
                        System.out.println(x +" " + y);
                        return;
                    }else{
                        System.out.println(x +" " +( y+1));
                        return;
                    }
                }
                y = y+1;
                continue;
            }
        }
        System.out.println(x+" "+y);
    }
}



//        for(int i = 0 ;i < map.length ;i++){
//            for(int j =  0; j < map[0].length ;j++){
//                System.out.print( map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(startX + " " + startY +" " +k);
