import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6_8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;
        int mid = (lt + rt) / 2;

        while (arr[mid] != m) {
            if (arr[mid] > m) {
                rt = mid - 1;
            } else if (arr[mid] < m) {
                lt = mid + 1;
            } else break;
            mid = (lt + rt) / 2;
        }
        System.out.println(mid + 1);
    }
}
