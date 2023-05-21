package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2806 {
    private static int N;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            arr = new int[N];

            dfs(0);
            System.out.println("#" + tc + " " + answer);
        }
    }

    public static void dfs(int depth) {
        if (depth == N) {
            answer++;
        } else {
            for (int i = 0; i < N; i++) {
                arr[depth] = i;
                if (check(depth))
                    dfs(depth + 1);
            }
        }
    }

    public static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false;
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}
