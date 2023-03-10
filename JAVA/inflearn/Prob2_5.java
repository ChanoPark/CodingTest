import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob2_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);

        int answer = 0;

        for (int i = 2; i < n; i++) {

            if (arr[i] == -1) {
                continue;
            } else if (arr[i] == 0) {
                answer++;
                int k = 1;
                while (i * k <= n) {
                    arr[i * k] = -1;
                    k++;
                }
            }
        }
        System.out.println(answer);
    }
}
