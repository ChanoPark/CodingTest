import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6_10 {
    public static boolean calculate(int[] arr, int mid, int n, int c) {
        int prev = arr[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] - prev >= mid) {
                prev = arr[i];
                cnt++;
            }
        }
        return cnt >= c;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int lt = 1;
        int rt = Integer.MIN_VALUE;
        int mid;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (rt < arr[i]) rt = arr[i];
        }
        rt -= lt;

        Arrays.sort(arr);

        int answer = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (calculate(arr, mid, n, c)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;

            }
        }
        System.out.println(answer);
    }
}
