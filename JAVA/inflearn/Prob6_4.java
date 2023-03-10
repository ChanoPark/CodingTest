import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int s = Integer.parseInt(input.split(" ")[0]);
        int n = Integer.parseInt(input.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) inputArr[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[s];
        Arrays.fill(arr, 0);

        for (int target : inputArr) {
            int idx = 0;

            //타겟 찾기
            for (int i = 0; i < s; i++) {
                if (arr[i] == target) {
                    idx = i;
                    break;
                }
            }

            //idx가 0이면 다 한칸씩 밀고 0에 넣기
            if (idx == 0) {
                int prev = arr[0];
                for (int j = 1; j < s; j++) {
                    int tmp = arr[j];
                    arr[j] = prev;
                    prev = tmp;
                }
            } else {
                int prev = arr[0];
                for (int j = 1; j <= idx; j++) {
                    int tmp = arr[j];
                    arr[j] = prev;
                    prev = tmp;
                }
            }

            arr[0] = target;
        }
        for (int x : arr) System.out.print(x + " ");
    }
}
