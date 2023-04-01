import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob9_6 {
    private static int[] unf;

    public static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) unf[a] = findB;
    }

    public static int find(int v) {
        if (unf[v] == v) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        unf = new int[n + 1];
        for (int i = 0; i <= n; i++) unf[i] = i;

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int f1 = Integer.parseInt(inputs[0]);
            int f2 = Integer.parseInt(inputs[1]);

            union(f1, f2);
        }
        inputs = br.readLine().split(" ");
        int f1 = Integer.parseInt(inputs[0]);
        int f2 = Integer.parseInt(inputs[1]);

        System.out.println(Arrays.toString(unf));
        if (find(f1) == find(f2)) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        solution();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputs = br.readLine().split(" ");
//        int n = Integer.parseInt(inputs[0]);
//        int m = Integer.parseInt(inputs[1]);
//
//        int[] relation = new int[n + 1];
//        int temp = 1;
//        for (int i = 0; i < m; i++) {
//            inputs = br.readLine().split(" ");
//
//            int f1 = Integer.parseInt(inputs[0]);
//            int f2 = Integer.parseInt(inputs[1]);
//
//            if (relation[f1] == 0 && relation[f2] == 0) relation[f1] = relation[f2] = temp++;
//            else if (relation[f1] != 0) {
//                //f1으로 맞춰, 둘 다 0이 아니어도.
//                if (relation[f2] == 0) relation[f2] = relation[f1];
//                else {
//                    int prev = relation[f2];
//                    for (int j = 1; j <= n; j++) {
//                        if (relation[j] == prev) relation[j] = relation[f1];
//                    }
//                }
//            } else {
//                //f2로 맞춰
//                if (relation[f1] == 0) relation[f1] = relation[f2];
//                else {
//                    int prev = relation[f1];
//                    for (int j = 1; j <= n; j++) {
//                        if (relation[j] == prev) relation[j] = relation[f2];
//                    }
//                }
//            }
//        }
//
//        inputs = br.readLine().split(" ");
//        int f1 = Integer.parseInt(inputs[0]);
//        int f2 = Integer.parseInt(inputs[1]);
//
//        System.out.println(Arrays.toString(relation));
//
//        if (relation[f1] == relation[f2] && relation[f1] != 0) System.out.println("YES");
//        else System.out.println("NO");
    }
}
