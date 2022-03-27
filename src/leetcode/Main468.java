package leetcode;

/**
 * 468. 验证IP地址
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 *
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 *
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 *
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 * @author Junho
 * @date 2022/3/26 11:17
 */
public class Main468 {
    public static void main(String[] args) {
//        String[] ipv4Arr = "172.16.254.1".split("\\.");
//        for(String s : ipv4Arr){
//            System.out.println(s);
//        }
        System.out.println(validIPAddress(
                "2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
    public static String validIPAddress(String queryIP) {
        if(queryIP.endsWith(":") || queryIP.endsWith("."))
            return "Neither";
        String[] ipv4Arr = queryIP.split("\\.");
        String[] ipv6Arr = queryIP.split(":");
//        for(int i =0 ; i< ipv4Arr.length;i++){
//            System.out.println(ipv4Arr[i]);
//        }
//        for(int i =0 ; i< ipv6Arr.length;i++){
//            System.out.println(ipv6Arr[i]);
//        }
        if(ipv4Arr.length != 1){
            if(ipv4Arr.length != 4)
                return "Neither";
            for(int i = 0 ;i < ipv4Arr.length ; i++){
                if(ipv4Arr[i].equals(""))
                    return "Neither";
//                if(ipv4Arr[i].length() == 1 && ipv4Arr[i].charAt(0) == '0')
//                    continue;
                if(ipv4Arr[i].length() > 1 && ipv4Arr[i].charAt(0) == '0'){
                    System.out.print(1);
                    return "Neither";
                }
                int num = 0;
                for(int j = 0 ; j < ipv4Arr[i].length() ; j++ ){
                    if(! (ipv4Arr[i].charAt(j) >= '0' && ipv4Arr[i].charAt(j) <= '9')){
                        System.out.print(2);
                        return "Neither";
                    }
                    num = num * 10 + (ipv4Arr[i].charAt(j) - '0');
                }
                if(num < 0 || num > 255){
                    System.out.print(3);
                    return "Neither";
                }

            }
            return "IPv4";
        }else{
            if(ipv6Arr.length != 8)
                return "Neither";
            for(int i = 0 ; i < ipv6Arr.length ; i++){
                if(ipv6Arr[i].equals("") || ipv6Arr[i] == null)
                    return "Neither";
                if(ipv6Arr[i].length() < 0  || ipv6Arr[i].length() > 4 ){
                    System.out.print(4);
                    return "Neither";
                }
                for(int j = 0 ; j < ipv6Arr[i].length() ; j++ ){
                    if(! ((ipv6Arr[i].charAt(j) >= '0' && ipv6Arr[i].charAt(j) <= '9')
                            || (ipv6Arr[i].charAt(j) >= 'A' && ipv6Arr[i].charAt(j) <= 'F')
                            || (ipv6Arr[i].charAt(j) >= 'a' && ipv6Arr[i].charAt(j) <= 'f')) ){
                        System.out.print(5);
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}