import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob6_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int idx;
        int tmp;

        for (int i=0; i<n-1; i++) {
            idx = i;

            for (int j=i; j<n; j++) {
                if (arr[idx] > arr[j]) idx = j;
            }
            tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        for (int x : arr) System.out.print(x + " ");
    }
}
