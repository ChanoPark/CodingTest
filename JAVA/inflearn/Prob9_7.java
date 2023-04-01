import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob9_7 {
    private static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int v = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);

        PriorityQueue<Road> pq = new PriorityQueue<>();
        unf = new int[v + 1];
        for (int i = 0; i <= v; i++) unf[i] = i;
        int answer = 0;

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Road(start, end, cost));
        }

        while (!pq.isEmpty()) {
            Road road = pq.poll();
            int start = road.getStart();
            int end = road.getEnd();

            if (find(start) != find(end)) {
                answer += road.getCost();
                union(start, end);
            }
        }

        System.out.println(answer);
    }

    public static int find(int v) {
        if (unf[v] == v) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    public static void union(int v1, int v2) {
        int findV1 = find(v1);
        int findV2 = find(v2);

        if (findV1 != findV2) {
            unf[findV1] = findV2;
        }
    }

    public static class Road implements Comparable<Road> {
        private int start;
        private int end;
        private int cost;

        @Override
        public int compareTo(Road o) {
            return this.cost - o.getCost();
        }

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }
    }
}
