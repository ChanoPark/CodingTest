import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3_4 {
    /**
     * two pointer
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int sum = 0;
        int lt = 0;
        int rt = 0;

        while (lt < N) {
            if (sum < M) {
                sum += numbers[rt++];
            } else if (sum == M) {
                answer++;
                sum -= numbers[lt++];
            } else {
                sum -= numbers[lt++];
            }

            if (rt == N) {
                while (lt < rt) {
                    if (sum == M) {
                        answer++;
                    }
                    sum -= numbers[lt++];
                }
                break;
            }

        }


        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int tmp = 0;
            int point = 0;

            while (tmp <= M && point + i < N) {
                tmp += numbers[point + i];
                point++;

                if (tmp == M) answer++;
            }
        }
        System.out.println(answer);
    }
}
