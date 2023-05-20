package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) buildings[i] = Integer.parseInt(st.nextToken());
            int answer = 0;

            for (int i = 2; i < N - 2; i++) {
                int l = buildings[i] - Math.max(buildings[i - 1], buildings[i - 2]);
                int r = buildings[i] - Math.max(buildings[i + 1], buildings[i + 2]);

                if (l >= 0 && r >= 0) answer += Math.min(l, r);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
