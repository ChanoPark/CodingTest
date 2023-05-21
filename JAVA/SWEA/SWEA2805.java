package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }

            int center = n / 2;
            int answer = 0;
            int range;
            for (int i = 0; i < n; i++) {
                answer += arr[i][center];

                if (i <= center) range = i;
                else range = n - i - 1;

                for (int j = 1; j <= range; j++) answer += arr[i][center + j] + arr[i][center - j];
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
