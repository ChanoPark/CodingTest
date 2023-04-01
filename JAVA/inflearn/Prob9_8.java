import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob9_8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int v = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);

        int[] visited = new int[v + 1];
        int answer = 0;
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= v; i++) nodes.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes.get(v1).add(new Node(v2, cost));
            nodes.get(v2).add(new Node(v1, cost)); //무방향 그래프이므로 양 쪽 다 추가.
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Node n : nodes.get(1)) queue.offer(n);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nVex = node.getVex();
            if (visited[nVex] == 1) continue;
            visited[nVex] = 1;
            answer += node.getCost();

            for (Node n : nodes.get(nVex)) {
                if (visited[n.getVex()] == 0) queue.offer(n);
            }
        }
        System.out.println(answer);
    }

    public static class Node implements Comparable<Node> {
        private int vex;
        private int cost;

        public Node(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        public int getVex() {
            return vex;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.getCost();
        }
    }
}
