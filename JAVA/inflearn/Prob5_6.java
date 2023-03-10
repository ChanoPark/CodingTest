import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Prob5_6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) queue.add(i + 1);
        int cnt = 1;

        while (queue.size() > 1) {
            if (cnt == K) {
                queue.poll();
                cnt = 1;
            } else {
                queue.add(queue.poll());
                cnt++;
            }
        }

        System.out.println(queue.peek());
    }
}
