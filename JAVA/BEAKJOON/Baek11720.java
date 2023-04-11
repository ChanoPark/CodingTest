package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] nums = br.readLine().toCharArray();
        int result = 0;

        for (char x : nums) {
            result += x - '0';
        }

        System.out.println(result);
    }
}
