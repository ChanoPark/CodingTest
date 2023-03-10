import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        //i, j는 학생의 번호(인덱스로 접근X)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int mentorIdx = -1;
                int menteeIdx = -1;
                int cnt = 0;

                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) mentorIdx = l;
                        if (arr[k][l] == j) menteeIdx = l;
                    }
                    if (mentorIdx > menteeIdx) cnt++;
                }
                if (cnt == m) answer++;
            }
        }

        System.out.println(answer);
    }
}