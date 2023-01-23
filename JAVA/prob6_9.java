import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob6_9 {
    public static boolean calculate(int[] arr, int mid, int n, int m) {
        int cnt = 1; // 최초 1장은 있음.
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            if (tmp + arr[i] <= mid) tmp += arr[i];
            else {
                cnt++;
                tmp = arr[i];
            }
        }

        return cnt <= m;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int lt = 0;
        int rt = 0;
        int mid;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            rt += arr[i];
            if (arr[i] > lt) lt = arr[i];
        }

        int answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (calculate(arr, mid, n, m)) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
