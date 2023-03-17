import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ipArr = new int[n];
        int netAddress = 0;
        int netMask = 0;

        for (int i=0; i<n; i++) {
            String[] ipAddressArr = br.readLine().split("\\.");
            int ipAddress = 0;
            for(String x : ipAddressArr) {
                ipAddress <<= 8;
                ipAddress += Integer.parseInt(x);
            }
            ipArr[i] = ipAddress;
        }

        //넷마스크
        for (int i=31; i>=0; i--) {
            int bit = 1<<i;
            boolean flag = false;

            for (int j=0; j<n; j++) {
                if ((ipArr[0]&bit) != (ipArr[j]&bit)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                netMask |= bit;
            }
        }

        netAddress = netMask&ipArr[0];
        StringBuilder addrSb = new StringBuilder();
        StringBuilder maskSb = new StringBuilder();

        int check = (1<<8)-1;
        int k = 3;
        while (k > -1) {
            int addressNum = netAddress >> (8*k) & check;
            int maskNum = netMask >> (8*k) & check;

            addrSb.append(addressNum).append(".");
            maskSb.append(maskNum).append(".");

            netAddress &= ((1 <<(8*k))-1);
            netMask &= ((1 <<(8*k))-1);
            k--;
        }

        System.out.println(addrSb.substring(0, addrSb.length()-1));
        System.out.println(maskSb.substring(0, maskSb.length()-1));
    }
}
