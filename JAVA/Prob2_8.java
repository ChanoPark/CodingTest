import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_8 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer;
        for (int i = 0; i < N; i++) {
            answer = 1;
            for (int j = 0; j < N; j++) {
                if (arr[i] < arr[j]) answer++;
            }
            System.out.print(answer + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] reverse = new int[N];
        System.arraycopy(arr, 0, reverse, 0, N);

        int tmp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (reverse[i] > reverse[j]) {
                    tmp = reverse[i];
                    reverse[i] = reverse[j];
                    reverse[j] = tmp;
                }
            }
        }

        int idx;
        for (int target : arr) {
            idx = 1;
            for (int x : reverse) {
                if (target == x) {
                    System.out.print(idx + " ");
                    break;
                }
                idx++;
            }
        }
    }
}
