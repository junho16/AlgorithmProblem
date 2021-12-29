package base;

public class Main_quickMi {
    int quicklMi(int a  , int b , int mod ){
        int res = 1;
        while(b != 0){
            if((b & 1) != 0){
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
//    int quickMi(int a , int b){
//        a %= mod;
//        int res = 1;
//        while(b != 0){
//            if((b & 1) != 0){
//                res = res * a % mod;
//            }
//            a = a * a % mod;
//            b >>= 1;
//        }
//        return res;
//    }
}
