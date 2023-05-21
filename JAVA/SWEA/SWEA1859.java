package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            long answer = 0;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int max = arr[N-1];

            for (int i=N-2; i>=0; i--) {
                if (max < arr[i]) {
                    //최대값보다 크면
                    max = arr[i];
                } else {
                    //최대값보다 작으면
                    answer += max - arr[i];
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}

//DFS: 시간초과
//class Solution {
//    private static int answer;
//    private static int N;
//    private static int[] arr;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        for (int tc = 1; tc <= T; tc++) {
//            N = Integer.parseInt(br.readLine());
//            arr = new int[N];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
//
//            answer = 0;
//            dfs(0, 0, 0, 0);
//            System.out.println("#" + tc + " " + answer);
//        }
//    }
//
//    public static void dfs(int idx, int buy, int cnt, int sum) {
//        if (idx == N) {
//            answer = Math.max(answer, sum);
//        } else {
//            dfs(idx + 1, buy + arr[idx], cnt + 1, sum); //샀음
//
//            sum += arr[idx] * cnt - buy;
//            dfs(idx + 1, 0, 0, sum); //팔았음
//        }
//    }
//}
