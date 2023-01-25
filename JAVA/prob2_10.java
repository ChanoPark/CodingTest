import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob2_10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n + 2][n + 2];
        Arrays.fill(input[0], 0);
        Arrays.fill(input[n + 1], 0);
        for (int i = 1; i < n + 1; i++) {
            int[] tmp = new int[n + 2];
            tmp[0] = 0;
            tmp[n + 1] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tmp[j + 1] = Integer.parseInt(st.nextToken());
            }
            input[i] = tmp;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            Row:
            for (int j = 1; j < n + 1; j++) {
                int value = input[i][j];

                for (int k = 0; k < 4; k++) {
                    if (input[i + dy[k]][j + dx[k]] >= value) {
                        continue Row;
                    }
                }
                answer++;
            }
        }

        System.out.println(answer);
    }
}
