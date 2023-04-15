package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek11724 {
    private static int[] check;
    private static int answer = 0;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        check = new int[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int t) {
        if (check[t] == 0) {
            check[t] = 1;
            for (int x : list.get(t)) {
                dfs(x);
            }
        }
    }
}
