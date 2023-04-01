import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Prob9_5 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(id).add(new Edge(start, cost)); //Map이 아닌 ArrayList에 넣어서 관리
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(); //우선순위 큐를 활용해 시간복잡도 최소화(logn), 우선순위(cost가 낮은)에 따라 순서대로 추출
        pq.offer(new Edge(1, 0));
        dis[1] = 0;
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.getVex();
            int nowCost = tmp.getCost();
            if (nowCost > dis[now]) continue;

            for (Edge ob : graph.get(now)) {
                if (dis[ob.getVex()] > nowCost + ob.getCost()) {
                    dis[ob.getVex()] = nowCost + ob.getCost();
                    pq.offer(new Edge(ob.getVex(), nowCost + ob.getCost())); //따로 저장해놓는 것이 아닌 엣지에 값을 담아서 돌림, 최소값일 때만 큐에 넣음.
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.print(dis[i] + " ");
            else System.out.print("Impossible");
        }

    }

    public static void main(String[] args) throws Exception {
        solution();
        //반복문을 활용하면 O(n^2)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputs = br.readLine().split(" ");
//        int n = Integer.parseInt(inputs[0]);
//        int m = Integer.parseInt(inputs[1]);
//
//        Node[] nodes = new Node[n+1];
//        int[] costs = new int[n+1];
//        boolean[] visited = new boolean[n+1];
//
//        for (int i=1; i<=n; i++) nodes[i] = new Node();
//        Arrays.fill(costs, 500000);
//        costs[1] = 0;
//        visited[1] = true;
//
//        for (int i=0; i<m; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int id = Integer.parseInt(st.nextToken());
//            int start = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//            nodes[id].getNodeMap().put(start, cost);
//        }
//
//
//        for(int i=1; i<=n; i++) {
//            Map<Integer, Integer> map = nodes[i].getNodeMap();
//
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                Integer id = entry.getKey();
//                Integer cost = entry.getValue();
//                if (costs[id] > costs[i] + cost) costs[id] = costs[i] + cost;
//                visited[id] = true;
//
//            }
//        }
//
//        for (int i = 2; i<=n; i++) {
//            if (visited[i]) System.out.print(costs[i] + " ");
//            else System.out.print("Impossible");
//        }
    }

    public static class Node {
        private int id;
        private Map<Integer, Integer> nodeMap; //id, cost

        public Node(int id, Map<Integer, Integer> nodeMap) {
            this.id = id;
            this.nodeMap = nodeMap;
        }

        public Node() {
            this.nodeMap = new HashMap<>();
        }

        public int getId() {
            return id;
        }

        public Map<Integer, Integer> getNodeMap() {
            return nodeMap;
        }
    }

    public static class Edge implements Comparable<Edge> {
        private int vex;
        private int cost;

        public Edge(int vex, int cost) {
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
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

//6 9
//1 2 12
//1 3 4
//2 1 2
//2 3 5
//2 5 5
//3 4 5
//4 2 2
//4 5 5
//6 4 5
