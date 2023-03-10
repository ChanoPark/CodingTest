import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob6_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int min = arr[i];
            int j;

            //뒤로 가면서 하나씩 밀기
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > min) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = min;
        }

        for (int x : arr) System.out.print(x + " ");
    }
}
