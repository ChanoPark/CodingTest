import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob7_4 {
    static int[] fibo;

    public static int recursive(int n) {
        if (fibo[n] > 0) return fibo[n];
        else if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = recursive(n - 2) + recursive(n - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /**
         * 재귀함수(DFS)
         */
//        fibo = new int[n + 1];
//        recursive(n);
//        for (int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
        /**
         * 반복문
         */
        fibo = new int[n];

        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i < n; i++) fibo[i] = fibo[i - 1] + fibo[i - 2];

        for (int x : fibo) System.out.print(x + " ");
    }
}
