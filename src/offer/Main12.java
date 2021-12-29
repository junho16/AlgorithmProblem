package offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 * 这一直超时，不停剪枝剪了很久。。剪了好几次。。。
 */
public class Main12 {
    public int m;
    public int n;
    public boolean[][] flag;
    public char[][] board;
    public String word;
    public boolean exist(char[][] b, String w) {
        word = w;
        board = b;
        m = board.length;
        n = board[0].length;
        //flag[0][0] = true;
        flag = new boolean[m][n];
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                if(board[i][j] == word.charAt(0) ){
                    System.out.println(i +" "+j);
                    if(dfs(0 , i , j , "" )){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs(int u , int x ,int y , String path){

        path += board[x][y];
        flag[x][y] = true;

        System.out.println(path);
        if(u == word.length())
            return false;

        if(path.charAt(u) != word.charAt(u))
            return false;

        if (path.equals(word))
            return true;

        boolean res = false;
        int[] fx_x = {0,1,0,-1};
        int[] fx_y = {-1,0,1,0};
        for(int i = 0 ;i < 4 ; i++){
            int a = x+fx_x[i];
            int b = y+fx_y[i];
            if(a >=0 && a < m && b>=0 && b < n && !flag[a][b]){
                // boolean p = dfs(u+1 , a , b , path + board[a][b]);
                boolean p = dfs(u+1 , a , b , path );
                if(p){
                    // res = true;
                    return true;
                }
                flag[a][b] = false;
            }
        }
        flag[x][y] = false;
        return res;
    }
}
