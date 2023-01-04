import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        int[] answer = new int[n1 + n2];

        while (idx1 < n1 && idx2 < n2) {
            if (arr1[idx1] < arr2[idx2]) {
                answer[idx++] = arr1[idx1++];
            } else if (arr1[idx1] > arr2[idx2]) {
                answer[idx++] = arr2[idx2++];
            } else {
                answer[idx++] = arr1[idx1++];
                answer[idx++] = arr2[idx2++];
            }
        }
        if (idx1 == n1) {
            for (; idx < n1 + n2; idx++, idx2++) {
                answer[idx] = arr2[idx2];
            }
        }
        if (idx2 == n2) {
            for (; idx < n1 + n2; idx++, idx1++) {
                answer[idx] = arr1[idx1];
            }
        }

        System.out.print(answer[0]);
        for (int i = 1; i < n1 + n2; i++)
            System.out.print(" " + answer[i]);
    }
}
