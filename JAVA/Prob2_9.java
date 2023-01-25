import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int colSum = 0;
        int rowSum = 0;
        int leftCrossSum = 0;
        int rightCrossSum = 0;
        int answer;

        for (int i = 0; i < N; i++) {
            int rowSumTmp = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                rowSumTmp += value;
                arr[i][j] = value;
            }
            if (rowSumTmp > rowSum) rowSum = rowSumTmp;
        }

        for (int i = 0; i < N; i++) {
            int colSumTmp = 0;
            for (int j = 0; j < N; j++) {
                colSumTmp += arr[j][i];
            }
            if (colSumTmp > colSum) colSum = colSumTmp;
            rightCrossSum += arr[i][i];
            leftCrossSum += arr[N - 1 - i][N - 1 - i];
        }

        answer = Math.max(colSum, rowSum);
        answer = Math.max(Math.max(answer, rightCrossSum), leftCrossSum);

        System.out.println(answer);
    }
}
