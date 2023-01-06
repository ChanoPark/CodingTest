import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3_3 {
    /**
     * Sliding window
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int day = Integer.parseInt(input.split(" ")[1]);

        int[] sales = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sales[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < day; i++) {
            sum += sales[i];
        }

        int max = sum;

        for (int i = 0; i < n - day; i++) {
            if (sum > max) max = sum;

            sum -= sales[i];
            sum += sales[i + day];
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int day = Integer.parseInt(input.split(" ")[1]);

        int[] sales = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sales[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        int tmp;
        for (int i = 0; i < n - day; i++) {
            tmp = 0;
            for (int j = 0; j < day; j++)
                tmp += sales[j + i];

            if (tmp > max) max = tmp;
        }
        System.out.println(max);
    }
}
