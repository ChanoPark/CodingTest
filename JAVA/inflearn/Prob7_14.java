import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob7_14 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<ArrayList<Integer>> graph = new ArrayList<>();
        int[] complete = new int[n + 1];
        int[] answer = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            graph.get(n1).add(n2);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        complete[1] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer x = queue.poll();
                List<Integer> vList = graph.get(x);

                for (Integer v : vList) {
                    if (complete[v] == 0) {
                        answer[v] = answer[x] + 1;
                        complete[v] = 1;
                        queue.offer(v);
                    }
                }

            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}
