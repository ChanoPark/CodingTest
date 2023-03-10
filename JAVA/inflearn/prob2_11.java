import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class prob2_11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j][i] == arr[k][i]) {
                        map.get(j).add(k);
                        map.get(k).add(j);
                    }
                }
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                answer = entry.getKey();
                max = entry.getValue().size();
            }
        }
        System.out.println(answer + 1);
    }
}
