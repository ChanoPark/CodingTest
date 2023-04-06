import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Integer[] arr = new Integer[n];
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());

        int temp = 0;
        int answer = 0;
        int i = 0;

        while (temp < k) {
            int t = k - temp;

            if (t >= arr[i]) {
                answer += t / arr[i];
                temp += (t / arr[i]) * arr[i];
            }
            i++;
        }
        System.out.println(answer);
    }
}
