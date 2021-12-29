package offer;

public class Main4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
         if(matrix.length == 0  || matrix[0].length ==0)
            return false;
        int x = 0;
        for(int i = matrix[0].length-1 ;i >= 0 ; i--){
            if(target >= matrix[0][i]){
                x = i;

                System.out.print(x);
                int l = 0;
                int r = matrix.length-1;
                while(l < r){
                    int mid = (l + r + 1) >> 1;
                    if(matrix[mid][x] > target){
                        r = mid-1;
                    }else{
                        l = mid;
                    }
                }
                if(matrix[l][x] == target)
                    return true;
            }
        }
        return false;
    }
}