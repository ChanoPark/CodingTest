package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1244 {
    private static char[] numbers;
    private static int cnt;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            numbers = input[0].toCharArray();
            cnt = Integer.parseInt(input[1]);

            if (cnt > numbers.length) cnt = numbers.length;
            answer = 0;

            dfs(0, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(int idx, int start) {
        if (idx == cnt) {
            int temp = 0;
            for (int i = 0; i < numbers.length; i++) temp += (numbers[numbers.length - 1 - i] - '0') * (int) Math.pow(10, i);
            answer = Math.max(answer, temp);
        } else {
            for (int i = start; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    swap(i, j);
                    dfs(idx + 1, i);
                    swap(j, i);
                }
            }
        }
    }

    private static void swap(int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
