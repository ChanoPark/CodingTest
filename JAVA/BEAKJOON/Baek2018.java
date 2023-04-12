package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int lt = 1;
        int rt = 1;
        int sum = 0;
        int result = 0;

        while (lt <= n) {
            if (sum == n) {
                result++;
                sum -= lt++;
            } else if (sum > n) {
                sum -= lt++;
            } else {
                sum += rt++;
            }
        }
        System.out.println(result);
    }
}
