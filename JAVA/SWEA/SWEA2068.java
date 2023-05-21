package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2068 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1 ; tc <= TC ; tc++) {
            String[] input = br.readLine().split(" ");
            int answer = Integer.MIN_VALUE;

            for (String c : input) {
                answer = Math.max(answer, Integer.parseInt(c));
            }


            System.out.println("#" + tc + " " + answer);
        }
    }
}
