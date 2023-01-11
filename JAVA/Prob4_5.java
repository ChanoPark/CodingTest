import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Prob4_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK = br.readLine();
        int N = Integer.parseInt(NK.split(" ")[0]);
        int K = Integer.parseInt(NK.split(" ")[1]);

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); //내림차순 정렬

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int l = j + 1; l < N; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (Integer x : set) {
            if (cnt == K - 1) {
                System.out.println(x);
                return;
            }
            cnt++;
        }

        System.out.println(-1);
    }
}
