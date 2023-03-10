import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i])
                System.out.print(" " + arr[i]);
        }
    }
}
