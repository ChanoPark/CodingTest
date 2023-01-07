import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] aArr = new int[n];
        int[] bArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            int a = aArr[i];
            int b = bArr[i];

            if (a - b == 0) answer[i] = 'D';
            else if (a - b == -1) answer[i] = 'B';
            else if (a - b == -2) answer[i] = 'A';
            else if (a - b == 1) answer[i] = 'A';
            else answer[i] = 'B';
        }

        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }
}
