import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob8_2 {
    private static int c;
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        c = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int idx, int sum) {
        if (idx == n) return sum;
        else {
            if (sum + arr[idx] > c) return dfs(idx + 1, sum);
            else return Math.max(dfs(idx + 1, sum + arr[idx]), dfs(idx + 1, sum));
        }
    }
}
