import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Prob4_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(map.keySet().size());

        int lt = 0;

        while (lt < N - K) {
            if (map.get(numbers[lt]) == 1) map.remove(numbers[lt]);
            else map.put(numbers[lt], map.get(numbers[lt]) - 1);

            map.put(numbers[lt + K], map.getOrDefault(numbers[lt + K], 0) + 1);

            answer.add(map.keySet().size());
            lt++;
        }

        for (Integer x : answer) System.out.print(x + " ");
    }
}
