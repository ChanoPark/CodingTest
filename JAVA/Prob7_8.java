import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Prob7_8 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int[] moves = {1, -1, 5};
        int[] ch = new int[10001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ch[s] = 1;
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                for (int move : moves) {
                    int movePos = pos + move;

                    if (pos == e) {
                        System.out.println(answer);
                        return;
                    }

                    if (movePos >= 0 && movePos <= 10000 && ch[movePos] == 0) {
                        queue.offer(movePos);
                        ch[movePos] = 1;
                    }
                }
            }
            answer++;
        }
    }

    public static void main(String[] args) throws Exception {
//        solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int answer = 0;

        while (s != e) {
            if (s < e) {
                if (Math.abs(e - s) >= 4) s += 5;
                else s++;
            } else s--;

            answer++;
        }

        System.out.println(answer);
    }
}
